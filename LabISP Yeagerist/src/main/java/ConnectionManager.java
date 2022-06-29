import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager 
{
	Connection con = null;
	ResourceBundle rb;
	
	public static Connection getConnection() throws URISyntaxException, SQLException 
	{
	    String dbUrl = System.getenv("JDBC_DATABASE_URL");
	    return DriverManager.getConnection(dbUrl);
	}
	
}
