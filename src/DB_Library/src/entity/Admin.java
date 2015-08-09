package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SQLHelper;

public class Admin {
	
	private String sid ;
	private String sname;
	private String spwd;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	
	public static String getpwdfromid(String id)
	{
		String pwd="";
		try {
			String sql = "select spwd from tb_manager where sid = '"+id+"'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			pwd = rs.getString("spwd");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pwd;
	}
}

