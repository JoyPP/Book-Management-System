package UI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SQLHelper;

public class AllBorrowList extends JTable{
	
	JFrame jf = new JFrame();
	
	public AllBorrowList()
	{
		JTable jt = new JTable();
		jt.setSize(500, 200);
		DefaultTableModel dtm = new DefaultTableModel(new String[]{"bid", "bookname", "readerid", "borrowdate", "returndate"},1);
		dtm.setRowCount(0);
		String[] arr = new String[5];
		arr[0] = "索书号";
		arr[1] = "书名";
		arr[2] = "读者ID";
		arr[3] = "借阅时间";
		arr[4] = "归还时间";
				
		dtm.addRow(arr);
		
		String sql;
		try {
			sql = "select * from tb_borrowreturnrecord ";
			
			ResultSet rs = SQLHelper.executeQuery(sql);
			while (rs.next())
			{
				arr[0] = rs.getString("bookid");
				arr[1] = rs.getString("bookname");
				arr[2] = rs.getString("readerid");
				arr[3] = rs.getString("borrowdate");
				arr[4] = rs.getString("returndate");
				dtm.addRow(arr);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jt.setModel(dtm);
		jt.setVisible(true);
		jf.add(jt);
		jf.setTitle("查询列表");
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
