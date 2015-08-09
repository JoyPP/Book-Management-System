package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.transform.Source;

import dao.SQLHelper;
import entity.Admin;
import entity.Reader;

public class InfoListAdmin extends JFrame implements ActionListener {

	private Admin admin;
	private JLabel lab_sid;
	private JLabel lab_sname;
	private JLabel lab_spwd;

	private JTextField txt_sid;
	private JTextField txt_sname;
	private JPasswordField txt_spwd;

	private JButton jb_ok;
	private JButton jb_edit;

	private void initComponent() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 1));
		lab_sid = new JLabel("管理员ID");
		lab_sname = new JLabel("管理员姓名");
		lab_spwd = new JLabel("管理员密码");

		txt_sid = new JTextField(admin.getSid());
		txt_sid.setEditable(false);

		txt_sname = new JTextField(admin.getSname());
		txt_sname.setEditable(false);

		txt_spwd = new JPasswordField();
		txt_spwd.setText(admin.getSpwd());
		txt_spwd.setEditable(false);

		jp.add(lab_sid);
		jp.add(txt_sid);
		jp.add(lab_sname);
		jp.add(txt_sname);
		jp.add(lab_spwd);
		jp.add(txt_spwd);

		jb_ok = new JButton("确认");
		jb_edit = new JButton("编辑");

		jp.add(jb_ok);
		jp.add(jb_edit);

		this.add(jp);

		jb_edit.addActionListener(this);
		jb_ok.addActionListener(this);

	}

	public InfoListAdmin(Admin admin) {
		this.admin = admin;
		initComponent();
		this.setSize(350, 150);
		this.setVisible(true);
	}

	private void edit_Click() {
		txt_spwd.setEditable(true);
	}

	private void ok_Click() {
		try {
			String sql = "select spwd from tb_manager where sid = '"
					+ admin.getSid() + "'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			if (!txt_spwd.getText().contentEquals(rs.getString("spwd"))) {
				int flag = JOptionPane.showConfirmDialog(jb_ok,
						"您的信息已经发生更改，你还要继续下去吗？");
				if (flag == 0) {
					JPasswordField jtf = new JPasswordField();

					int flag1 = JOptionPane.showConfirmDialog(this, jtf,
							"请再次输入密码", JOptionPane.OK_CANCEL_OPTION);
					String check_pwd = jtf.getText();// 密码字符串
					// String check_pwd =
					// JOptionPane.showInputDialog("密码被修改，请再输一次确认");
					if (flag1 == 0) {
						if (check_pwd.contentEquals(txt_spwd.getText())) {
							String sqlupdate = "update tb_manager set spwd='"
									+ check_pwd + "'	where sid ='"
									+ admin.getSid() + "'";
							SQLHelper.executeUpdate(sqlupdate);
							JOptionPane.showMessageDialog(this, "信息修改成功");
							this.setVisible(false);

						} else {
							JOptionPane.showMessageDialog(this, "确认密码错误");
						}
					}
				}

			} else {
				this.setVisible(false);
			}

		} catch (Exception e) {
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == jb_edit) {
			edit_Click();
		} else if (source == jb_ok) {
			ok_Click();
		}

	}
}
