package UI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Reader;
import dao.SQLHelper;

public class CurrentBorrowList extends JTable{
	
	Reader reader = new Reader();
	
	JFrame jf = new JFrame();
	
	public CurrentBorrowList(Reader reader)
	{
		this.reader = reader;
		JTable jt = new JTable();
		jt.setSize(500, 200);
		DefaultTableModel dtm = new DefaultTableModel(new String[]{"bookid", "bookname", "readerid", "borrrowdate"},1);
		dtm.setRowCount(0);
		String[] arr = new String[4];
		arr[0] = "书号"; 
		arr[1] = "书名";
		arr[2] = "读者号";
		arr[3] = "借阅日期";	
				
		dtm.addRow(arr);
		
		
		try {
			String sql = "select * from tb_borrowreturnrecord where readerid =  '"+reader.getRid()+"'and returndate IS NULL";
			ResultSet rs = SQLHelper.executeQuery(sql);
			while (rs.next())
			{
				arr[0] = rs.getString("bookid");
				arr[1] = rs.getString("bookname");
				arr[2] = rs.getString("readerid");
				arr[3] = rs.getString("borrowdate");
				dtm.addRow(arr);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jt.setModel(dtm);
		jt.setVisible(true);
		jf.add(jt);
		jf.setTitle("当前借阅记录");
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
