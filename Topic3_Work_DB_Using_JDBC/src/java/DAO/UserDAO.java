
package DAO;

import DAL.DBContext;
import Models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mô tả các hoạt động tác động tới dữ liệu kiểu User: CRUD
 * @author admin
 */
public class UserDAO extends DBContext{
    // Mục đích: Khi đối tượng kiểu UserDAO được khởi tạo, thì DBContext() cũng được gọi
    // Khi đó, connection mới có dữ liệu
    public UserDAO(){
        super();
    }
    
    /***
     * Trả về một danh sách các đối tượng có kiểu User
     * @return List<User>
     */
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        // Tạo chuỗi truy vấn -> Quyết định chức năng làm gì: Read (SELECT)
        String sql = "SELECT * FROM Users";
        try {
            // Tạo đối tượng Statement -> Thực thi truy vấn
            Statement st = connection.createStatement();
            // Tạo ResultSet để tiếp nhận kết quả trả về từ truy vấn SELECT
            ResultSet rs = st.executeQuery(sql);
            // Duyệt từng bản ghi dữ liệu từ ResultSet để đẩy vào List<User>
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("Id"));
                u.setEmail(rs.getString("Email"));
                u.setGender(rs.getString("Gender"));
                u.setDob(rs.getDate("Dob"));
                u.setPhone(rs.getString("Phone"));
                u.setFullname(rs.getString("Fullname"));
                u.setRole(rs.getString("Role"));
                
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }

    public int createNewUser(User newUser) {
        int result = 0;
        try {
            // Giả định email chưa được đăng kí (Đã kiểm tra sự tồn tại của User theo email)
            String sql = "INSERT INTO Users(Email,Password,Fullname,Gender,Dob,Phone,Role) VALUES(?,?,?,?,?,?,?)";
            // Khởi tạo đối tượng PrepareStatement để thực thi truy vấn
            PreparedStatement ps = connection.prepareStatement(sql);
            // Làm sạch dữ liệu cho câu truy vấn
            ps.setString(1, newUser.getEmail());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, newUser.getFullname());
            ps.setString(4, newUser.getGender());
            ps.setDate(5, newUser.getDob());
            ps.setString(6, newUser.getPhone());
            ps.setString(7, newUser.getRole());
            
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public User getUser(User loginUser) {
        try {
            String sql = "SELECT * FROM Users WHERE Email=? AND Password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, loginUser.getEmail());
            ps.setString(2, loginUser.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setEmail(rs.getString("Email"));
                user.setFullname(rs.getString("Fullname"));
                user.setGender(rs.getString("Gender"));
                user.setDob(rs.getDate("Dob"));
                user.setPhone(rs.getString("Phone"));
                user.setRole(rs.getString("Role"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null; // TH: Không tồn tại User theo email, password đăng nhập
    }
}
