package LoginPackage;

import Classes.Classnames;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TEGA
 */
@WebServlet(name = "StudentLogin", urlPatterns = {"/StudentLogin"})
public class StudentLogin extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection conn= ConnectionPackage.MyConnection.getConnection();
            int roleId =6,state=1;
            PreparedStatement ps;
            ResultSet rs;
            HttpSession ss = request.getSession(true);
            String classId = request.getParameter("class_name");
            String rollno = request.getParameter("student_rollno"),role,name,picture;
            String id;
            ps = conn.prepareStatement("SELECT students.userId,user.full_name,user.picture,roleinfo.name FROM students INNER JOIN user ON (students.userId = user.id) INNER JOIN roleinfo ON (user.roleId = roleinfo.id) WHERE students.rollno = '"+rollno+"' AND students.classId ='"+classId+"' AND user.roleId ="+roleId+" AND user.state = "+state+" ");
            rs = ps.executeQuery();
            if(rs.next()){
                role = rs.getString("name");
                name = rs.getString("full_name");
                picture = rs.getString("picture");
                id = rs.getString("userId");
                ss.setAttribute("full_name", name);
                ss.setAttribute("user_role", role);
                ss.setAttribute("user_picture", picture);
                ss.setAttribute("userId", id);
                response.sendRedirect(request.getContextPath()+ "/StudentProfile.jsp" );
            }else{
                request.setAttribute("loginErrorMessage", "Incorrect Details, Try Again");
                request.getRequestDispatcher("/StudentLogin.jsp").forward(request, response);
            }
        }catch(Exception ex){}
    }
}
