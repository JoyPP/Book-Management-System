package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublishingDao {
	
	public static void addPublishing(String string) {
		try {
			String sql = "insert into tb_publishing values("+string+")";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}
	
	public static String genID()		
	{
		
		String id = "";
		
			try
			{
				String sql = "select ISBN from tb_publishing";
				ResultSet rs = SQLHelper.executeQuery(sql);
				int max = 0;
				
				String ISBN = "";
				while(rs.next())
				{
					ISBN = rs.getString("ISBN");
					if(max < Integer.parseInt(ISBN.substring(1, 5)))		//类型号改为5位
						max = Integer.parseInt(ISBN.substring(1, 5));
				}
				max++;
				String subId = String.valueOf(max);
				int len = subId.length();
				id = "I";
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
