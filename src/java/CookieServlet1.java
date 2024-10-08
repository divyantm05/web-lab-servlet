

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "cookie1", urlPatterns = {"/cookieServlet1"})
public class CookieServlet1 extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("username");
        out.println("hello "+name);
        Cookie c=new Cookie("name","divyan");
        c.setMaxAge(60*60*24);
        res.addCookie(c);
        out.println("<a href='cookieServlet2'>VISIT</a>");
    }
}
