
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet1"})
public class NewServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy parameter từ URL/form
        String username = request.getParameter("username");

        // Lấy method request
        String method = request.getMethod();

        // Lấy URL
        String url = request.getRequestURL().toString();

        // Lấy URI
        String uri = request.getRequestURI();

        // Lấy context path
        String contextPath = request.getContextPath();

        // Lấy IP client
        String ip = request.getRemoteAddr();

        // Lấy header
        String userAgent = request.getHeader("User-Agent");

        PrintWriter out = resp.getWriter();
        out.println("Parameter: "+ username);
        out.println("Method: "+ method);
        out.println("URL: "+ url);
        out.println("URI: "+ uri);
        out.println("Context path: "+ contextPath);
        out.println("IP: "+ ip);
        out.println("User agent: "+ userAgent);
    }
}
