import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhận dữ liệu login form
        String user = req.getParameter("txtUser");
        String pass = req.getParameter("txtPass");
        
        // Kiểm tra tài khoản (giả định dữ liệu được lấy từ DB) có hợp lệ không
        if(user.equals("admin") && pass.equals("abc@123")){
            // Nếu đăng nhập thành công thì điều hướng về trang home.jsp
            // Khai báo 1 session
            HttpSession session = req.getSession();
            // Cung cấp dữ liệu cho session
            session.setAttribute("account", user);
            resp.sendRedirect("home.jsp");
        }else{
            // Nếu đăng nhập thất bại -> Chuyển tiếp req về login.jsp
            req.setAttribute("message", "Invalid username or password");
            // Chuyển tiếp (forward) đối tượng (req, res) về index.jsp
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
