package Classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TEGA
 */
@WebServlet(name = "Classnames", urlPatterns = {"/Classnames"})
public class Classnames extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection conn= ConnectionPackage.MyConnection.getConnection();
            PrintWriter out = response.getWriter();
            PreparedStatement ps;
            ResultSet rs;
            String class_name;
            int class_id;
            ps = conn.prepareStatement("SELECT class.class_name,class.id FROM class WHERE 1");
            rs = ps.executeQuery();
            while(rs.next()){
                class_name = rs.getString("class_name");
                class_id = rs.getInt("id");
                out.println("<option value="+class_id+">"+class_name+"</option>");
            }
            ps.close();
            rs.close();
            conn.close();
        }catch(Exception ex){}
    }
}
