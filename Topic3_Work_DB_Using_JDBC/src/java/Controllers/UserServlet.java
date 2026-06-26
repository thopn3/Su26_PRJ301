package Controllers;

import DAO.UserDAO;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/users/*"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo(); // Ví dụ: /register; /login

        // Nếu người dùng không chỉ định URL pattern thì -> default: /users/list
        if (path == null || path.equals("/")) {
            path = "/list";
        }

        switch (path) {
            case "/register":
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                break;
            case "/login":
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                break;
            case "/profile":
                req.getRequestDispatcher("/profile.jsp").forward(req, resp);
                break;
            case "/list":
                // Kiểm tra session của user (role='admin')
                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("admin_info");
                if (user != null && user.getRole().trim().equals("admin")) {
                    // Khởi tạo đối tượng kiểu UserDAO
                    UserDAO userDao = new UserDAO();
                    // Khai báo danh sách kiểu List<User>
                    List<User> list = userDao.getUsers();
                    // Bổ sung vào attribute của request
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/ListUser.jsp").forward(req, resp);
                } else {
                    session.setAttribute("msgError", "Not Authorized. Login please!");
                    resp.sendRedirect(req.getContextPath() + "/users/login");
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); // Ví dụ: /register; /login

        // Nếu người dùng không chỉ định URL pattern thì -> default: /users/list
        if (path == null || path.equals("/")) {
            path = "/list";
        }

        switch (path) {
            case "/register":
                // Lấy dữ liệu từ Register form -> Đóng gói thành 1 đối tượng kiểu User
                String email = req.getParameter("txtEmail");
                String password = req.getParameter("txtPassword");
                String fullname = req.getParameter("txtFullname");
                String gender = req.getParameter("rbGender");
                Date dob = Date.valueOf(req.getParameter("txtDob"));
                String phone = req.getParameter("txtPhone");
                String role = "customer";

                User newUser = new User(email, password, fullname, gender, dob, phone, role);
                // Khởi tạo đối tượng kiểu UserDAO (chứa các hàm bussiness logic)
                UserDAO userDao = new UserDAO();
                int result = userDao.createNewUser(newUser);

                if (result > 0) {
                    HttpSession session = req.getSession();
                    session.setAttribute("msgSuccess", "Registration Success!");
                    resp.sendRedirect(req.getContextPath() + "/users/list");
                } else {
                    req.setAttribute("error", "Registration False!");
                    req.getRequestDispatcher("/register.jsp").forward(req, resp);
                }

                break;
            case "/login":
                String txtEmail = req.getParameter("txtEmail");
                String txtPass = req.getParameter("txtPass");

                User user = new User();
                user.setEmail(txtEmail);
                user.setPassword(txtPass);

                UserDAO userDao1 = new UserDAO();
                User existUser = userDao1.getUser(user);

                HttpSession session = req.getSession();
                if (existUser == null) {
                    session.setAttribute("msgError", "This account not registered!");
                    resp.sendRedirect(req.getContextPath() + "/users/login");
                } else {
                    // Kiểm tra role của existUser
                    if (existUser.getRole().trim().equals("admin")) {
                        session.setAttribute("admin_info", existUser);
                        resp.sendRedirect(req.getContextPath() + "/products/add");
                    } else {
                        session.setAttribute("msgError", "You are not permission!");
                        resp.sendRedirect(req.getContextPath() + "/users/login");
                    }
                }

                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
}
