package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author admin
 */
@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    // Thực hiện ghi đè hàm doGet() của HttpServlet -> Tiếp nhận các yêu cầu từ client theo phương thức GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Chuyển tiếp request từ người dùng tại URL: http://localhost:8080/register -> Sang register.jsp
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    // Phương thức tiếp nhận dữ liệu từ Register form (register.jsp) gửi theo phương thức là POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Tiếp nhận dữ liệu từ Register form gửi sang
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPassword");
        String dob = req.getParameter("txtDob");
        String gender = req.getParameter("rbGender");
        String city = req.getParameter("cbCity");
        // Lấy dữ liệu từ các checkbox tạo thành 1 mảng kiểu String, rồi nối các phần tử lại thành 1 chuỗi
        //String favs = String.join("; ", req.getParameterValues("chkFav")) ;
        
        // Validation: Kiểm tra tính hợp lệ của dữ liệu đầu vào
        List<String> errors = new ArrayList<>();
        
        if(email == null || email.trim().isEmpty()){
            errors.add("Email is required");
        }
        
        if(pass == null || pass.trim().isEmpty()){
            errors.add("Password is required");
        }
        
        if(dob == null || dob.trim().isEmpty()){
            errors.add("DateOfBirth is required");
        }
        
        // Kiểm tra danh sách errors khác rỗng
        // Không hợp lệ
        if(!errors.isEmpty()){
            // Tổ chức dữ liệu cho đối tượng request để chuyển tiếp về Form hiển thị lỗi
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        
        // Dữ liệu hợp lệ
        // Thiết lập session (phiên làm việc)
        HttpSession session = req.getSession();
        User user = new User(email, pass, dob, gender, city);
        session.setAttribute("user_info", user);
        // Điều hướng về /login
        resp.sendRedirect("login");
    }
}
