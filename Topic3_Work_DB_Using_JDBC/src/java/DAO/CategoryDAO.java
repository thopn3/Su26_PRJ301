package DAO;

import DAL.DBContext;
import Models.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBContext{
    public CategoryDAO(){
        super();
    }
    
    public List<Category> getCategories(){
        List<Category> list = new ArrayList<>();
        // Tạo chuỗi truy vấn -> Quyết định chức năng làm gì: Read (SELECT)
        String sql = "SELECT * FROM Categories";
        try {
            // Tạo đối tượng Statement -> Thực thi truy vấn
            Statement st = connection.createStatement();
            // Tạo ResultSet để tiếp nhận kết quả trả về từ truy vấn SELECT
            ResultSet rs = st.executeQuery(sql);
            // Duyệt từng bản ghi dữ liệu từ ResultSet để đẩy vào List<User>
            while(rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("Id"));
                c.setName(rs.getString("Name"));
                
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
