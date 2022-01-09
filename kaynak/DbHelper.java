import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper  {
      private String name="root";
      private String password="41084108";
      private String dbUrl="jdbc:mysql://localhost:3306/product";
      public Connection getConnection() throws SQLException {
    	   return DriverManager.getConnection(dbUrl, name, password);
      }
      public void errorMesage(Exception e) {
    	 System.out.println("hata burada="+e.getMessage()); 
      }
}
