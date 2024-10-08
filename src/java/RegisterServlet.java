import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        String firstname=req.getParameter("firstname");
        String lastname=req.getParameter("lastname");
        String registerno=req.getParameter("registerno");
        String address=req.getParameter("address");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weblab","root","13071977@edm");
            PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?)");
            ps.setString(1,firstname);
            ps.setString(2, registerno);
            ps.setString(3, lastname);
            ps.setString(4, address);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            res.sendRedirect("/ServletPractice/register.html");
        }
    }
}
