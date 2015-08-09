package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderDao {

	public static void addReader(String string) {
		try {
			String sql = "insert into tb_reader values("+string+")";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}
	
	public static String genID()		
	{
		
		String id = "";
		
			try
			{
				String sql = "select rid from tb_reader";
				ResultSet rs = SQLHelper.executeQuery(sql);
				int max = 0;
				
				String rid = "";
				while(rs.next())
				{
					rid = rs.getString("rid");
					if(max < Integer.parseInt(rid.substring(1, 5)))		//读者号改为5位
						max = Integer.parseInt(rid.substring(1, 5));
				}
				max++;
				String subId = String.valueOf(max);
				int len = subId.length();
				id = "R";
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
