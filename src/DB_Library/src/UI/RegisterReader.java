package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.SQLHelper;
import dao.ReaderDao;
import entity.Reader;

public class RegisterReader extends JPanel implements ActionListener,
		KeyListener {

	// private UserService userService;
	private GridBagConstraints c;
	private JFrame jf = new JFrame();
	private Reader reader = new Reader();
	private JLabel lab_name;
	private JLabel lab_pwd;
	private JLabel lab_tel;
	private JLabel lab_gender;
	private JTextField txt_name;
	// private JTextField txt_pwd;
	private JTextField txt_tel;

	private JRadioButton male;
	private JRadioButton female;

	private JButton btn_ok;
	private JButton btn_reset;
	private JPasswordField jpwd;
	private JLabel lab_email;
	private JTextField txt_email;

	private String gender;

	public RegisterReader() {

		initComponentNormal();

		this.setSize(340, 300);
		this.setVisible(true);
		jf.setSize(340, 300);
		jf.setVisible(true);
		jf.add(this);

	}

	// 初始化组件——读者
	private void initComponentNormal() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		lab_name = new JLabel("姓名: ");
		txt_name = new JTextField(10);
		lab_tel = new JLabel("电话: ");
		txt_tel = new JTextField(10);
		lab_gender = new JLabel("性别: ");
		male = new JRadioButton("男");
		female = new JRadioButton("女");
		male.setSelected(true);
		lab_pwd = new JLabel("密码:");
		jpwd = new JPasswordField(10);
		// jpwd.setText("000000");
		jpwd.setEditable(true);
		lab_email = new JLabel("邮箱:");
		txt_email = new JTextField(10);

		btn_ok = new JButton("确定");
		btn_reset = new JButton("重置");

		// 姓名
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_name, c);
		// 姓名--输入框
		c.gridx++;
		// c.gridx++;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 1, 0);
		this.add(txt_name, c);

		// 密码
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_pwd, c);
		// c.gridx++;
		c.gridx++;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 1, 0);
		this.add(jpwd, c);

		// 性别
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_gender, c);
		// 性别--输入框
		c.gridx++;
		JPanel rbp = new JPanel();
		rbp.setLayout(new GridLayout(1, 2));
		rbp.add(male);
		rbp.add(female);
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		this.gender = "男";
		c.anchor = GridBagConstraints.WEST;
		this.add(male, c);
		// c.gridx++;
		c.anchor = GridBagConstraints.CENTER;
		this.add(female, c);

		// 电话
		c.gridx = 0;
		c.gridy++;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_tel, c);
		// 电话--输入框
		c.gridx++;
		c.anchor = GridBagConstraints.WEST;
		this.add(txt_tel, c);

		// 邮箱
		c.gridx = 0;
		c.gridy++;
		c.anchor = GridBagConstraints.CENTER;
		this.add(lab_email, c);
		// 邮箱--输入框
		c.gridx++;
		c.anchor = GridBagConstraints.WEST;
		this.add(txt_email, c);
		c.gridx++;

		// 按钮
		c.gridx = 0;
		c.gridy++;
		c.anchor = GridBagConstraints.CENTER;
		this.add(btn_ok, c);
		c.gridx++;
		this.add(btn_reset, c);
		c.gridx++;

		// 注册监听器
		this.female.addActionListener(this);
		this.male.addActionListener(this);
		this.btn_ok.addActionListener(this);
		this.btn_reset.addActionListener(this);
		this.txt_tel.addKeyListener(this);
	}

	// 重置
	private void reset() {
		this.txt_name.setText(null);
		this.jpwd.setText(null);
		this.txt_tel.setText(null);
		this.male.setSelected(true);
		this.txt_email.setText(null);
	}

	// 添加联系人的信息输入是否有效 姓名密码和电话必填
	private boolean validator() {
		String s1 = this.txt_name.getText();
		String s3 = this.jpwd.getText();
		String s2 = this.txt_tel.getText();
		if ((s1 == null || "".equals(s1)) || ("".equals(s2) || s2 == null)
				|| ("".equals(s3) || s3 == null)) {
			if ((s1 == null || "".equals(s1))) {
				JOptionPane.showMessageDialog(this, "姓名不能为空！");
			} else if ((s3 == null || "".equals(s3))) {
				JOptionPane.showMessageDialog(this, "密码不能为空！");
			} else
				JOptionPane.showMessageDialog(this, "电话不能为空！");
			return false;
		} else
			return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.male) {
			this.gender = "男";
		} else if (source == this.female) {
			this.gender = "女";
		} else if (source == this.btn_ok) {
			if (validator()) {
				reader.setRname(txt_name.getText());
				reader.setRpwd(jpwd.getText());
				reader.setGender(this.gender);
				reader.setTel(txt_tel.getText());
				reader.setEmail(txt_email.getText());
				reader.setRid(ReaderDao.genID());
				JPasswordField jtf = new JPasswordField();

				int flag = JOptionPane.showConfirmDialog(this, jtf, "请再次输入密码",
						JOptionPane.OK_CANCEL_OPTION);
				String check_pwd = jtf.getText();// 密码字符串
				// String checkpwd = JOptionPane.showInputDialog("请再次输入密码");
				if (flag == 0) {
					if (check_pwd.contentEquals(jpwd.getText())) {
						ReaderDao.addReader(toSQL(reader)); // 添加插入数据库
						SQLHelper.call_procedure("info_sync('"
								+ reader.getRid() + "','" + reader.getRname()
								+ "','" + reader.getRpwd() + "','"
								+ reader.getGender() + "','" + reader.getTel()
								+ "','" + reader.getEmail() + "')");
						JOptionPane.showMessageDialog(this, "用户注册成功！您的ID为"
								+ reader.getRid());
						this.setVisible(false);
						jf.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(this, "确认密码错误");
					}
				}

			}
		} else if (source == this.btn_reset) {
			reset();
		} else {

		}
	}

	public String toSQL(Reader reader) {
		return "'" + reader.getRid() + "'," + "'" + reader.getRname() + "',"
				+ "'" + reader.getRpwd() + "'," + "'" + reader.getGender()
				+ "'," + "'" + reader.getTel() + "'," + "'" + reader.getEmail()
				+ "'";
	}

	public void checkUserName(String name) {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.txt_tel) {
			int kc = arg0.getKeyChar();
			if (kc < KeyEvent.VK_0 || kc > KeyEvent.VK_9)
				arg0.consume();
		}
	}
}
