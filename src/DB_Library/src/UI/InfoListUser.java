package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.transform.Source;

import dao.SQLHelper;
import entity.Reader;

/**
 * 用户信息显示
 * 
 * ID name pwd gender tel email
 * 
 * ok cancel
 */
public class InfoListUser extends JFrame implements ActionListener {
	private GridBagConstraints c;
	private JFrame jf = new JFrame();

	private Reader user;
	private JLabel lab_rid;
	private JLabel lab_rname;
	private JLabel lab_gender;
	private JLabel lab_tel;
	private JLabel lab_pwd;
	private JLabel lab_email;

	private JTextField txt_rid;
	private JTextField txt_rname;
	// private JTextField txt_gender;
	private JRadioButton male;
	private JRadioButton female;

	private JTextField txt_tel;
	private JPasswordField txt_pwd;
	private JTextField txt_email;

	private JButton jb_ok;
	private JButton jb_edit;

	private String gender = "";

	private void initComponent() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		// JPanel jp = new JPanel();
		// jp.setLayout(new GridLayout(9,1));
		lab_rid = new JLabel("ID");
		lab_rname = new JLabel("姓名");
		lab_email = new JLabel("邮箱");
		lab_gender = new JLabel("性别");
		lab_tel = new JLabel("电话");
		lab_pwd = new JLabel("密码");

		txt_rid = new JTextField(20);
		txt_rid.setText(user.getRid());
		txt_rid.setEditable(false);

		txt_rname = new JTextField(20);
		txt_rname.setText(user.getRname());
		txt_rname.setEditable(false);

		txt_email = new JTextField(20);
		txt_email.setText(user.getEmail());
		txt_email.setEditable(false);

		male = new JRadioButton("男");
		female = new JRadioButton("女");
		if (user.getGender().contentEquals("男")) {
			this.gender = "男";
			male.setSelected(true);
		} else {
			this.gender = "女";
			female.setSelected(true);
		}

		txt_pwd = new JPasswordField(20);
		txt_pwd.setText(user.getRpwd());
		txt_pwd.setEditable(false);

		txt_tel = new JTextField(20);
		txt_tel.setText(user.getTel());
		txt_tel.setEditable(false);

		jb_ok = new JButton("确认");
		jb_edit = new JButton("编辑");

		// jp.add(lab_rid);jp.add(txt_rid);
		// jp.add(lab_rname);jp.add(txt_rname);
		// jp.add(lab_gender);jp.add(male);jp.add(female);
		// jp.add(lab_pwd);jp.add(txt_pwd);
		// jp.add(lab_email);jp.add(txt_email);
		// jp.add(lab_tel);jp.add(txt_tel);
		//
		// id
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_rid, c);
		// id--输入框
		c.gridx++;
		// c.gridx++;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		// c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_rid, c);

		// 姓名
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_rname, c);
		// 姓名--输入框
		c.gridx++;
		// c.gridx++;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		// c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_rname, c);

		// 密码
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(lab_pwd, c);
		// c.gridx++;
		c.gridx++;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		// c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_pwd, c);

		// 性别
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		this.add(lab_gender, c);
		// 性别--输入框
		c.gridx++;
		ButtonGroup bg = new ButtonGroup();
		bg.add(female);
		c.gridx++;
		bg.add(male);
		// this.gender="男";
		c.gridx = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(male, c);
		c.gridx++;
		c.anchor = GridBagConstraints.WEST;
		this.add(female, c);

		// 电话
		c.gridx = 0;
		c.gridy++;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_tel, c);
		// 电话--输入框
		c.gridx++;
		c.gridwidth = 2;
		this.add(txt_tel, c);

		// 邮箱
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		this.add(lab_email, c);
		// 邮箱--输入框
		c.gridx++;
		c.gridwidth = 2;
		this.add(txt_email, c);
		c.gridx++;

		// 按钮
		c.gridx = 0;
		c.gridy++;
		this.add(jb_ok, c);
		c.gridx++;
		this.add(jb_edit, c);
		c.gridx++;

		// jp.add(jb_ok);
		// jp.add(jb_edit);

		// this.add(jp);
		this.female.addActionListener(this);
		this.male.addActionListener(this);
		jb_edit.addActionListener(this);
		jb_ok.addActionListener(this);

	}

	public InfoListUser(Reader user) {
		this.user = user;
		initComponent();
		this.setSize(400, 300);
		this.setVisible(true);

	}

	private void edit_Click() {
		txt_tel.setEditable(true);
		if (user.getGender().contentEquals("男")) {
			this.gender = "男";
			male.setSelected(true);
		} else {
			this.gender = "女";
			female.setSelected(true);
		}
		txt_pwd.setEditable(true);
		txt_email.setEditable(true);
	}

	private void ok_Click() {
		try {
			String sql = "select tel,rpwd,gender,email from tb_reader where rid = '"
					+ user.getRid() + "'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();

			if (txt_tel.getText().contentEquals(rs.getString("tel"))
					&& txt_pwd.getText().contentEquals(rs.getString("rpwd"))
					&& this.gender.contentEquals(rs.getString("gender"))
					&& txt_email.getText().contentEquals(rs.getString("email"))) {
				this.setVisible(false);
			} else {
				int flag = JOptionPane.showConfirmDialog(jb_ok,
						"您的信息已经发生更改，你还要继续下去吗？");
				if (flag == 0) {
					if (txt_pwd.getText().contentEquals(rs.getString("rpwd"))) {
						String sqlupdate = "update tb_reader set tel = '"
								+ txt_tel.getText() + "',rpwd='"
								+ txt_pwd.getText() + "',gender = '"
								+ this.gender + "',email = '"
								+ txt_email.getText() + "'	where rid ='"
								+ user.getRid() + "'";
						SQLHelper.executeUpdate(sqlupdate);
					} else {
						JPasswordField jtf = new JPasswordField();

						int flag1 = JOptionPane.showConfirmDialog(this, jtf,
								"请再次输入密码", JOptionPane.OK_CANCEL_OPTION);
						String check_pwd = jtf.getText();// 密码字符串
						// String check_pwd =
						// JOptionPane.showInputDialog("密码被修改，请再输一次确认");
						if (flag1 == 0) {
							if (check_pwd.contentEquals(txt_pwd.getText())) {
								String sqlupdate = "update tb_reader set tel = '"
										+ txt_tel.getText()
										+ "',rpwd='"
										+ txt_pwd.getText()
										+ "',gender = '"
										+ this.gender
										+ "'	where rid ='"
										+ user.getRid() + "'";
								SQLHelper.executeUpdate(sqlupdate);
								JOptionPane.showMessageDialog(this, "信息修改成功");
								this.setVisible(false);

							} else {
								JOptionPane.showMessageDialog(this, "确认密码错误");
							}
						}
					}
					this.setVisible(false);
				}
			}
			// SQLHelper.executeUpdate(sql);
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
		} else if (source == this.male) {
			this.gender = "男";
		} else if (source == this.female) {
			this.gender = "女";
		}

	}
}
