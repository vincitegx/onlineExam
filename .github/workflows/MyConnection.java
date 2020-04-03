package ConnectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TEGA
 */
public class MyConnection {
    
    private String url="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull";
    private String username="test";
    private String password="test";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static Connection getConnection(){
        MyConnection myconn = new MyConnection();
        String url = myconn.getUrl();
        String username = myconn.getUsername();
        String password = myconn.getPassword();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch (SQLException ex) { 
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
