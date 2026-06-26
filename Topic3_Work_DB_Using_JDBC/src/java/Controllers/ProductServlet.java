
package Controllers;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DTO.ProductDTO;
import Models.Category;
import Models.Product;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name="ProductServlet", urlPatterns={"/products/*"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        // Nếu người dùng không chỉ định URL pattern thì -> default: /products
        if (path == null || path.equals("/")) {
            path = "/list";
        }
        
        switch (path) {
            case "/add":
                // Kiểm tra session của user (role='admin')
                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("admin_info");
                if(user!=null && user.getRole().trim().equals("admin")){
                    // Lấy dữ liệu của Categoies
                    List<Category> categories = new CategoryDAO().getCategories();
                    // Truyền dữ liệu qua attribute của request
                    req.setAttribute("categories", categories);
                    req.getRequestDispatcher("/AddProduct.jsp").forward(req, resp);
                }else{
                    session.setAttribute("msgError", "Not Authorized. Login please!");
                    resp.sendRedirect(req.getContextPath()+"/users/login");
                }
                break;
            case "/edit":
                // Lấy id từ Query String
                int id = Integer.parseInt(req.getParameter("id"));
                // Lấy dữ liệu của product từ DB theo id
                Product product = new ProductDAO().getProductById(id);
                if(product!=null){
                    // Lấy dữ liệu của Categoies
                    List<Category> categories = new CategoryDAO().getCategories();
                    // Truyền dữ liệu qua attribute của request
                    req.setAttribute("categories", categories);
                    req.setAttribute("product", product);
                    req.getRequestDispatcher("/EditProduct.jsp").forward(req, resp);
                }else{
                    // Tự viết điều hướng về trang NotFound.jsp
                }
                
                break;
            case "/delete":
                
                break;
            case "/list":
                List<ProductDTO> products = new ProductDAO().getProducts();
                if(products!=null)
                    req.setAttribute("products", products);
                else
                    req.setAttribute("errorMessage", "No data");
                
                req.getRequestDispatcher("/ProductList.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        // Nếu người dùng không chỉ định URL pattern thì -> default: /products
        if (path == null || path.equals("/")) {
            path = "/list";
        }
        
        switch (path) {
            case "/add":
                // Kiểm tra session của user (role='admin')
                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("admin_info");
                if(user!=null && user.getRole().trim().equals("admin")){
                    // Lấy dữ liệu trên Form
                    String name = req.getParameter("txtPName");
                    int price = Integer.parseInt(req.getParameter("txtPrice"));
                    int stock = Integer.parseInt(req.getParameter("txtInStock"));
                    int catId = Integer.parseInt(req.getParameter("ddlCategory"));
                    Product newProduct = new Product(name, price, stock, catId);
                    int insertedRow = new ProductDAO().createNewProduct(newProduct);
                    if(insertedRow>0){
                        session.setAttribute("msgSuccess", "Create success!");
                        resp.sendRedirect(req.getContextPath() + "/products/list");
                    }else{
                        req.setAttribute("error", "Create False!");
                        req.getRequestDispatcher("/AddProduct.jsp").forward(req, resp);
                    }
                }else{
                    session.setAttribute("msgError", "Not Authorized. Login please!");
                    resp.sendRedirect(req.getContextPath()+"/users/login");
                }
                break;
            case "/edit":
                
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
}
