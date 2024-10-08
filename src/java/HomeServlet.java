import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet {
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.println("<a href='/ServletPractice/register.html' style='font-size:25px;'>Add Student</a>");
        out.println("<a href='/ServletPractice/view' style='font-size:25px;margin-left:10px;'>View Students</a>");
        out.close();
    }
}