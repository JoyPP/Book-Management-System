package UI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SQLHelper;

public class AllReaderList extends JTable{
	
	JFrame jf = new JFrame();
	
	public AllReaderList()
	{
		JTable jt = new JTable();
		jt.setSize(500, 200);
		DefaultTableModel dtm = new DefaultTableModel(new String[]{"rid", "rname", "gender", "tel", "email"},1);
		dtm.setRowCount(0);
		String[] arr = new String[5];
		arr[0] = "读者ID";
		arr[1] = "姓名";
		arr[2] = "性别";
		arr[3] = "电话";
		arr[4] = "邮箱";
				
		dtm.addRow(arr);
		
		String sql;
		try {
			sql = "select * from tb_reader ";
			
			ResultSet rs = SQLHelper.executeQuery(sql);
			while (rs.next())
			{
				arr[0] = rs.getString("rid");
				arr[1] = rs.getString("rname");
				arr[2] = rs.getString("gender");
				arr[3] = rs.getString("tel");
				arr[4] = rs.getString("email");
				dtm.addRow(arr);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		jt.setModel(dtm);
		jt.setVisible(true);
		jf.add(jt);
		jf.setTitle("所有读者列表");
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
