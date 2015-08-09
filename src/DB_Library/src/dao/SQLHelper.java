package dao;

import java.sql.*;

import cons.cons;

public class SQLHelper {
	
	private static String driver = cons.DBDriver;
	private static String url = cons.DBUrl;
	private static String user = cons.DBUser;
	private static String pwd = cons.DBPassword;
	private  static Connection con;
	
	static{
		try{
			Class.forName(driver);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//执行查询语句,返回结果集
	public static ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try{
			con=DriverManager.getConnection(url,user,pwd);
			Statement cmd=con.createStatement();
			rs=cmd.executeQuery(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	//执行增删改等语句
	public static void executeUpdate(String sql){
		try{
			con=DriverManager.getConnection(url,user,pwd);
			Statement cmd=con.createStatement();
			cmd.executeUpdate(sql);
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	//无返回值的调用
	public static void call_procedure(String procedure)
	{
		try {
			con=DriverManager.getConnection(url,user,pwd);
			CallableStatement call = con.prepareCall("{call "+procedure+"}"); 
            call.execute(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//关闭数据库连接
	public static void closeConnection(){
		try{
			if(con!=null&&!con.isClosed())
				con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
