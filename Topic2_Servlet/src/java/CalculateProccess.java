import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculateProccess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Khởi tạo đối tượng cho luồng ghi dữ liệu vào response
        PrintWriter output = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        // Lấy dữ liệu từ các parameter trên URL, thông qua đối tượng req
        int x = Integer.parseInt(req.getParameter("txtX"));
        int y = Integer.parseInt(req.getParameter("txtY"));
        String op = req.getParameter("txtOp");
        
        switch (op) {
            case "+":
                output.println("<h2>Addition of X and Y: "+ (x+y) +"</h2>");
                break;
            case "-":
                output.println("<h2>Subtraction of X and Y: "+ (x-y) +"</h2>");
                break;
            case "*":
                output.println("<h2>Multiply of X and Y: "+ (x*y) +"</h2>");
                break;
            case "/":
                if(y==0)
                    output.println("<h2 style='color:red'>y not equal 0</h2>");
                else
                    output.println("<h2>Division of X and Y: "+ ((float)x/y) +"</h2>");
                break;
            default:
                output.println("<h2 style='color:red'>Invalid operator!</h2>");
        }
    }
}
