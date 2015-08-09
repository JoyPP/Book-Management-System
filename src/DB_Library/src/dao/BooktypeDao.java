package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BooktypeDao {
	
	public static void addBookType(String string) {
		try {
			String sql = "insert into tb_booktype values("+string+")";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}
	
	public static String genID()		
	{
		
		String id = "";
		
			try
			{
				String sql = "select typeID from tb_booktype";
				ResultSet rs = SQLHelper.executeQuery(sql);
				int max = 0;
				
				String typeID = "";
				while(rs.next())
				{
					typeID = rs.getString("typeID");
					if(max < Integer.parseInt(typeID.substring(1, 5)))		//类型号改为5位
						max = Integer.parseInt(typeID.substring(1, 5));
				}
				max++;
				String subId = String.valueOf(max);
				int len = subId.length();
				id = "T";
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

}
