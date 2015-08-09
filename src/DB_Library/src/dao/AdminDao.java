package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Admin;

public class AdminDao {
	
	
	public boolean adminValidate(String sid, String spwd) {
		boolean flag = false;
		try {
			String sql = "select count(*) from tb_manager where sid='" + sid
					+ "' and spwd='" + spwd + "'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			int rows = rs.getInt(1);
			if (rows == 1)
				flag = true;
			SQLHelper.closeConnection();
		} catch (Exception ex) {

		}
		return flag;
	}
	public AdminDao()
	{
		
	}
	public Admin getAdmin(String sid)
	{
		Admin admin = new Admin();
		
		try {
			String sql = "select * from tb_manager where sid ='"+sid+"'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			admin.setSid(rs.getString("sid"));
			admin.setSname(rs.getString("sname"));
			admin.setSpwd(rs.getString("spwd"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return admin;
	}
	public void addAdmin(String string) {
		try {
			String sql = "insert into  tb_manager values('"+string+"')";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}

}
