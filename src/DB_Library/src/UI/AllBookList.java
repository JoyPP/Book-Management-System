package UI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SQLHelper;

public class AllBookList extends JTable{
	
	JFrame jf = new JFrame();
	
	public AllBookList()
	{
		JTable jt = new JTable();
		jt.setSize(500, 200);
		DefaultTableModel dtm = new DefaultTableModel(new String[]{"bid", "bookname", "typeID", "author", "ISBN", "bookcase", "storage"},1);
		dtm.setRowCount(0);
		String[] arr = new String[7];
		arr[0] = "索书号";
		arr[1] = "书名";
		arr[2] = "类型";
		arr[3] = "作者";
		arr[4] = "出版社";
		arr[5] = "阅览室";
		arr[6] = "库存量";
				
		dtm.addRow(arr);
		
		String sql;
		try {
			sql = "select * from tb_book ";
			
			ResultSet rs = SQLHelper.executeQuery(sql);
			while (rs.next())
			{
				arr[0] = rs.getString("bid");
				arr[1] = rs.getString("bookname");
				arr[2] = rs.getString("typeID");
				arr[3] = rs.getString("author");
				arr[4] = rs.getString("ISBN");
				arr[5] = rs.getString("bookcase");
				arr[6] = rs.getString("storage");
				dtm.addRow(arr);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jt.setModel(dtm);
		jt.setVisible(true);
		jf.add(jt);
		jf.setTitle("所有图书列表");
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
