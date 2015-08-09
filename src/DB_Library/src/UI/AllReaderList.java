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
		arr[0] = "����ID";
		arr[1] = "����";
		arr[2] = "�Ա�";
		arr[3] = "�绰";
		arr[4] = "����";
				
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
		jf.setTitle("���ж����б�");
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
