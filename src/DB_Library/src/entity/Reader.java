package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SQLHelper;

public class Reader {
	private String rid ;
	private String rname ;
	private String gender;
	private String rpwd;
	private String tel ;
	private String email ;
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String pwd) {
		this.rpwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static Reader getReader(String rid)
	{
		Reader reader = new Reader();
		
		try {
			String sql = "select * from tb_reader where rid ='"+rid+"'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			reader.setRid(rs.getString("rid"));
			reader.setRname(rs.getString("rname"));
			reader.setGender(rs.getString("gender"));
			reader.setRpwd(rs.getString("rpwd"));
			reader.setTel(rs.getString("tel"));
			reader.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return reader;
	}
	
}
