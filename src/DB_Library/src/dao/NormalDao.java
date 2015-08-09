package dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Reader;


public class NormalDao {
	
	
	public boolean readerValidate(String rid, String rpwd) {
		boolean flag = false;
		try {
			String sql = "select count(*) from tb_reader where rid='" + rid
					+ "' and rpwd='" + rpwd + "'";
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
	public NormalDao()
	{
		
	}
	public Reader getReader(String rid)
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
/*	public void addReader(String rname, String gender,String rpwd,String tel,String email) {
		try {
			//what about pwd?
			String sql = "insert into  tb_reader values('"+rname+"','"+gender+"','"+rpwd+"','"+tel+"','"+email+"')";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}*/

}
