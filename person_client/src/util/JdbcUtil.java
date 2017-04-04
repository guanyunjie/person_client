package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	private static String driveClassName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/person_data?useUnicode=true&characterEncoding=utf8&useSSL=true";

	private static String username = "root";
	private static String password = "8525abcd";

	public static Connection connect(){
		Connection conn = null;  
        
        //load driver  
        try {  
            Class.forName(driveClassName);  
        //connect db  
            conn = DriverManager.getConnection(url, username, password);  
        }catch (ClassNotFoundException  e) {  
            System.out.println("load driver failed!");  
            e.printStackTrace();  
        }   
        catch (SQLException e) {  
            System.out.println("connect failed!");  
            e.printStackTrace();  
        }         
        return conn;  
	}
	




}
