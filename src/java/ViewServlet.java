import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/viewStudents")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {
            out.println("<html><head><title>Student Records</title></head><body>");
            out.println("<h2 style='text-align:center;'>Student Records</h2>");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblab", "root", "13071977@edm");
                 Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

                if (!rs.next()) {
                    out.println("<h4 style='text-align:center;'>No Records</h4>");
                } else {
                    out.println("<table border='1' style='margin:auto;'>");
                    out.println("<tr><th>First Name</th><th>Last Name</th><th>Register No</th><th>Address</th></tr>");
                    
                    // Move the cursor back to the first row
                    rs.beforeFirst();
                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + escapeHtml(rs.getString("firstname")) + "</td>");
                        out.println("<td>" + escapeHtml(rs.getString("lastname")) + "</td>");
                        out.println("<td>" + escapeHtml(rs.getString("registerno")) + "</td>");
                        out.println("<td>" + escapeHtml(rs.getString("address")) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            } catch (SQLException e) {
                out.println("<h4 style='text-align:center;'>Database Error: " + e.getMessage() + "</h4>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String escapeHtml(String input) {
        if (input == null) {
            return null;
        }
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }
}
