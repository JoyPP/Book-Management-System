package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BookDao {

	public static void addBook(String string) {
		try {
			String sql = "insert into tb_book values("+string+")";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {
			
		}
	}
	
	public static String genID()		
	{
		
		String id = "";
			try
			{
				String sql = "select bid from tb_book where true";
				ResultSet rs = SQLHelper.executeQuery(sql);
				int max = 0;
				int j = 0;
				
				String bid = "==";
				System.out.println("**********");
				while(rs.next())
				{					
					bid = rs.getString("bid");
					
					j=Integer.parseInt(bid.substring(1, 5));
					
					if(max < j){		//读者号改为5位
						max = j;
					}
				}
				max++;
				String subId = String.valueOf(max);
				int len = subId.length();
				id = "B";
				for(int i=4-len;i>0;i--)
				{
					id = id+"0";
				}
				id = id+subId;
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		return id;
		
	}
	/*
	public static String generateRID(String did,String pid)
	{
		String eid="";
		try
		{
			String sql = "select eid from employment_record where did='"+did+"' and pid='"+pid+"'" ;
			ResultSet rs  = SQLHelper.executeQuery(sql);
			String id="";
			int max=0;
			while(rs.next())
			{
				id = rs.getString("eid");
				if(max < Integer.parseInt(id.substring(5, 7)))
					max = Integer.parseInt(id.substring(5, 7));
			}
			max++;
			if(max<10)
			{
				eid = did+pid+"E0"+max;
			}else {
				eid = did+pid+"E"+max;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return eid;
	}*/
	
}
