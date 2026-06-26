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


@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy dữ liệu từ Login form
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPassword");
        
        // Kiểm tra tính hợp lệ của dữ liệu: Email, Password
        List<String> errors = new ArrayList<>();
        
        if(email == null || email.trim().isEmpty()){
            errors.add("Email is required");
        }
        
        if(pass == null || pass.trim().isEmpty()){
            errors.add("Password is required");
        }
        
        // Case: Dữ liệu trên form hợp lệ -> Lấy dữ liệu từ Session để so khớp
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user_info");
        
        // So sánh dữ liệu từ form login có khớp với dữ liệu từ session không
        if(!user.getEmail().equals(email) || !user.getPassword().equals(pass)){
            errors.add("Email or password incorrect");
        }else{
            // Điều hướng sang /home 
            resp.sendRedirect("home");
        }
        
        // Case: Dữ liệu không hợp lệ
        if(!errors.isEmpty()){
            // Tổ chức dữ liệu cho đối tượng request để chuyển tiếp về Form hiển thị lỗi
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }  
}
