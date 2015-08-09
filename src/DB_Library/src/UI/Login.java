package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;

import entity.Admin;
import entity.Reader;
import dao.AdminDao;
import dao.NormalDao;


public class Login extends JFrame implements ActionListener{
	
	private GridBagConstraints c;
	private JLabel lbl_name ;
	private JLabel lbl_pwd;
	private JTextField txt_name;
	private JPasswordField txt_pwd;
	private JRadioButton rbm_admin;
	private JRadioButton rbm_reader;	
	private JButton btn_ok;
	private JButton btn_cancel ;
	private JButton btn_register;
	private JButton btn_search;
	
	
    
	String right;
	String name;
	String password;
	
	static Main  frm = new Main();
    
	public Login() {
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		
		lbl_name = new JLabel("  ID");
		lbl_pwd = new JLabel("  密码");
		txt_name = new JTextField(10);
		txt_pwd = new JPasswordField(10);
		rbm_reader = new JRadioButton("Reader");
		rbm_reader.setSelected(true);
		rbm_admin = new JRadioButton("Admin");	
		btn_ok = new JButton("登录");
		btn_cancel = new JButton("返回");
		btn_register = new JButton("注册");
		btn_search = new JButton("搜索");
		
		//用户名
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.ipady=1;
		c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.CENTER;
		jp.add(lbl_name, c);
		//用户名--输入框
		c.gridx++;
		c.gridwidth=4;
		c.weightx=1;
		c.weighty=0;
		//c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.WEST;
		c.insets=new Insets(0, 0, 1, 0);
		jp.add(txt_name, c);
		//密码
		c.gridx=0;
		c.gridy++;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.CENTER;
		jp.add(lbl_pwd, c);
		//密码--输入框
		c.gridx++;
		c.gridwidth=4;
		c.weightx=1;
		c.anchor=GridBagConstraints.WEST;
		c.fill=GridBagConstraints.WEST;
		jp.add(txt_pwd, c);
		
		//权限
		c.gridwidth =1;
		c.gridx=0;
		c.gridy++;
		JPanel rbp=new JPanel();
		rbp.setLayout(new GridLayout(1, 2));
		rbp.add(rbm_reader);
		rbp.add(rbm_admin);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbm_reader);
		bg.add(rbm_admin);
		this.right= "Reader";
		c.anchor=GridBagConstraints.EAST;
		jp.add(rbm_reader,c);
		c.gridx++;
		c.anchor=GridBagConstraints.CENTER;
		jp.add(rbm_admin, c);
		
		//按钮
		c.gridx=0;
		c.gridwidth =1;
		c.gridy++;
		jp.add(btn_ok, c);
		c.gridx++;
		jp.add(btn_register, c);
		/*
		c.gridx=0;
		c.gridwidth =1;
		c.gridy++;
		jp.add(btn_search, c);*/
		c.gridx++;
		jp.add(btn_cancel,c);
		
		
		
		this.add(jp);
		
		
		
		//添加监听
		this.rbm_admin.addActionListener(this);
		this.rbm_reader.addActionListener(this);
		this.btn_cancel.addActionListener(this);
		this.btn_register.addActionListener(this);
		//this.btn_search.addActionListener(this);
		this.btn_ok.addActionListener(this);
	
		
		
		this.setTitle("用户登录");
	}

	public void  actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.rbm_admin)
			this.right = "Admin";
		else if (source == this.rbm_reader)
			this.right = "Reader";
		else if (source == this.btn_ok)
			btn_ok_Clicked();
		else if (source == this.btn_register)
			btn_register_Click();
		else if (source == this.btn_search)
			btn_search_Click();
		else if (source == this.btn_cancel)
			btn_cancel_Clicked();
	}
	
	private void btn_ok_Clicked() 
	{
		String id = this.txt_name.getText().trim();
		String pwd = this.txt_pwd.getText().trim();
		if(right == "Reader")
		{
			
			NormalDao nd = new NormalDao();
			
			if(nd.readerValidate(txt_name.getText(), txt_pwd.getText()))
			{
				frm.setVisible(false);
				
				Reader reader = new Reader();
				reader = nd.getReader(id);
				MainFrameReader mfu = new MainFrameReader(reader);
				mfu.setSize(700, 500);
				mfu.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this,"读者ID或密码错误，请重新输入");
				reset();
			}

			//判定登陆是否正确，查数据库
		}else {
			AdminDao ad = new AdminDao();
			if(ad.adminValidate(id, pwd))
			{
				frm.setVisible(false);
				
				Admin admin = new Admin();
				admin = ad.getAdmin(id);
				MainFrameAdmin  mf =new MainFrameAdmin(admin);
				mf.setSize(700, 500);
				mf.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "管理员ID或密码错误");
				reset();
			}
			//判定登陆是否正确，查数据库
		}
	}	
	private void reset()
	{
		this.txt_name.setText("");
		this.txt_pwd.setText("");
	}
	
	private void btn_register_Click()
	{
		RegisterReader ad = new RegisterReader();
		frm.setVisible(false);
	}
	
	private void btn_search_Click()
	{
		Search se = new Search();
	}

	private void btn_cancel_Clicked()
	{
		this.setVisible(false);
		//System.exit(0);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Main frm = new Main();
		frm.setSize(200, 120);
		frm.setResizable(false);
		frm.setVisible(true);
	}

}
