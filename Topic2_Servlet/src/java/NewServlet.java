import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class NewServlet extends HttpServlet {
    // Phương thức này tiếp nhận request từ Web Client theo phương thức GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Thiết lập kiểu dữ liệu trả về cho Web Client
        resp.setContentType("text/html;charset=utf-8");
        // Tạo đối tượng PrintWriter để đóng gói thông tin cua Response -> Trả về cho client
        PrintWriter out = resp.getWriter();
        out.println("<h2>Chào mừng bạn đến với NewServlet</h2>");
    }
}
