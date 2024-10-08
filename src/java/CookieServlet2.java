
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "cookie2", urlPatterns = {"/cookieServlet2"})
public class CookieServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        Cookie[] c=req.getCookies();
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.print(c[0].getName()+" ");
        out.print(c[0].getValue());
       
    }
    
}
