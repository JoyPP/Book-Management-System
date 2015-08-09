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


public class Main extends JFrame implements ActionListener{
	
	private GridBagConstraints c;

	private JButton btn_ok;
	private JButton btn_search;
	
	
    
	String right;
	String name;
	String password;
    
	public Main() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		btn_ok = new JButton("登录");
		
		btn_search = new JButton("搜索");
		/*
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
		jp.add(rbm_admin, c);*/
		
		//按钮
		c.gridx=0;
		c.gridwidth =1;
		c.gridy=0;
		c.anchor=GridBagConstraints.CENTER;
		jp.add(btn_ok, c);
		
		c.gridx++;
		c.gridx++;
		c.gridwidth =1;
		//c.gridy++;
		c.anchor=GridBagConstraints.CENTER;
		jp.add(btn_search, c);

		
		
		
		this.add(jp);
		
		
		
		//添加监听
		this.btn_search.addActionListener(this);
		this.btn_ok.addActionListener(this);
	
		
		
		this.setTitle("Welcome!");
	}

	public void  actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.btn_ok)
			btn_ok_Clicked();

		else if (source == this.btn_search)
			btn_search_Click();

	}
	
	private void btn_ok_Clicked() 
	{
		Login frm = new Login();
		frm.setSize(300, 200);
		frm.setVisible(true);
		//this.setVisible(false);
	}
	
	private void btn_search_Click()
	{
		Search se = new Search();
	}

/*
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Main frm = new Main();
		frm.setSize(300, 200);
		frm.setResizable(false);
		frm.setVisible(true);
	}
*/
}
