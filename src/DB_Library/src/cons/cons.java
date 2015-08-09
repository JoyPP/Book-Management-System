package cons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class cons {
	
	
	public static String DBDriver;
	public static String DBUrl;
	public static String DBUser;
	public static String DBPassword;
	
	static{
		Properties p = new Properties();
		try {
			InputStream in =  new FileInputStream("project.properties");		
			p.load(in);
			DBDriver = p.getProperty("dbdriver");
			DBUrl = p.getProperty("dburl");
			DBUser = p.getProperty("dbuser");
			DBPassword = p.getProperty("dbpassword");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
