
package DAO;

import DAL.DBContext;
import DTO.ProductDTO;
import Models.Category;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends DBContext{
    
    public ProductDAO(){
        super();
    }
    
    public int createNewProduct(Product newProduct) {
        try {
            // Giả định email chưa được đăng kí (Đã kiểm tra sự tồn tại của User theo email)
            String sql = "INSERT INTO Products(Name,Price,UnitsInStock,CategoryId) VALUES(?,?,?,?)";
            // Khởi tạo đối tượng PrepareStatement để thực thi truy vấn
            PreparedStatement ps = connection.prepareStatement(sql);
            // Làm sạch dữ liệu cho câu truy vấn
            ps.setString(1, newProduct.getName());
            ps.setInt(2, newProduct.getPrice());
            ps.setInt(3, newProduct.getUnitsInStock());
            ps.setInt(4, newProduct.getCategoryId());
            
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<ProductDTO> getProducts(){
        List<ProductDTO> list = new ArrayList<>();
        // Tạo chuỗi truy vấn -> Quyết định chức năng làm gì: Read (SELECT)
        String sql = "SELECT p.Id, p.Name, p.Price, c.Name as Category "
                + "FROM Products p, Categories c "
                + "WHERE p.CategoryId = c.Id";
        try {
            // Tạo đối tượng Statement -> Thực thi truy vấn
            Statement st = connection.createStatement();
            // Tạo ResultSet để tiếp nhận kết quả trả về từ truy vấn SELECT
            ResultSet rs = st.executeQuery(sql);
            // Duyệt từng bản ghi dữ liệu từ ResultSet để đẩy vào List<User>
            while(rs.next()){
                int pId = rs.getInt("Id");
                String pName = rs.getString("Name");
                int pPrice = rs.getInt("Price");
                String category = rs.getString("Category");
                ProductDTO productDto = new ProductDTO(pId, pName, pPrice, category);
                list.add(productDto);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public Product getProductById(int id) {
        Product product = new Product();
        try {
            String sql = "SELECT * FROM Products WHERE Id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getInt("Price"));
                product.setUnitsInStock(rs.getInt("UnitsInStock"));
                product.setCategoryId(rs.getInt("CategoryId"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return product;
    }
    
    public int editProduct(Product existProdut){
        try {
            // Giả định email chưa được đăng kí (Đã kiểm tra sự tồn tại của User theo email)
            String sql = "UPDATE Products SET Name=?,Price=?,UnitsInStock=?,CategoryId=? WHERE Id=?";
            // Khởi tạo đối tượng PrepareStatement để thực thi truy vấn
            PreparedStatement ps = connection.prepareStatement(sql);
            // Làm sạch dữ liệu cho câu truy vấn
            ps.setString(1, existProdut.getName());
            ps.setInt(2, existProdut.getPrice());
            ps.setInt(3, existProdut.getUnitsInStock());
            ps.setInt(4, existProdut.getCategoryId());
            ps.setInt(5,existProdut.getId());
            
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
