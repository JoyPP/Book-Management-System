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
import javax.swing.JTextField;
import javax.xml.transform.Source;

import dao.SQLHelper;
import entity.Reader;

/**用户信息显示
 * 
 * ID
 * name
 * pwd
 * gender
 * tel
 * email	
 * 
 * ok     cancel
 */
public class ObserveReader extends JFrame implements ActionListener{

	private Reader user;
	private JLabel lab_rid;
	private JLabel lab_rname;
	private JLabel lab_gender;
	private JLabel lab_tel;
	private JLabel lab_pwd;
	private JLabel lab_email;
	
	private JTextField txt_rid;
	private JTextField txt_rname;
	private JTextField txt_gender;
	private JTextField txt_tel;
	private JTextField txt_pwd;
	private JTextField txt_email;
	
	private JButton jb_ok;
	private JButton jb_edit;
	
	private void initComponent()
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(9,1));
		lab_rid = new JLabel("ID");
		lab_rname = new JLabel("姓名");
		lab_email = new JLabel("邮箱");
		lab_gender = new JLabel("性别");
		lab_tel = new JLabel("电话");
	//	lab_pwd = new JLabel("密码");
		
		txt_rid = new JTextField(user.getRid());
		txt_rid.setEditable(false);
		
		txt_rname = new JTextField(user.getRname());
		txt_rname.setEditable(false);
		
		txt_email = new JTextField(user.getEmail());
		txt_email.setEditable(false);
		
		txt_gender = new JTextField(user.getGender());
		txt_gender.setEditable(false);
		
	//	txt_pwd = new JTextField(user.getRpwd());
	//	txt_pwd.setEditable(false);
		
		txt_tel = new JTextField(user.getTel());
		txt_tel.setEditable(false);
		
		jp.add(lab_rid);jp.add(txt_rid);
		jp.add(lab_rname);jp.add(txt_rname);
		jp.add(lab_gender);jp.add(txt_gender);
	//	jp.add(lab_pwd);jp.add(txt_pwd);
		jp.add(lab_email);jp.add(txt_email);
		jp.add(lab_tel);jp.add(txt_tel);
		
		jb_ok = new JButton("确认");
		jb_edit = new JButton("编辑");
		
		jp.add(jb_ok);
		jp.add(jb_edit);
		
		
		
		this.add(jp);
		
		jb_edit.addActionListener(this);
		jb_ok.addActionListener(this);
		
		
		
		
	}
	
	public ObserveReader(Reader user)
	{
		this.user = user;
		initComponent();
		this.setSize(350, 500);
		this.setVisible(true);
	}

	private void edit_Click()
	{
		txt_tel.setEditable(true);
		txt_gender.setEditable(true);
//		txt_pwd.setEditable(true);
		txt_email.setEditable(true);
	}
	private void ok_Click()
	{
		try {
			String sql="select tel,gender,email from tb_reader where rid = '"+user.getRid()+"'";
			ResultSet rs = SQLHelper.executeQuery(sql);
			rs.next();
			if(txt_tel.getText().contentEquals(rs.getString("tel"))&&
		//			txt_pwd.getText().contentEquals(rs.getString("pwd"))&&
					txt_gender.getText().contentEquals(rs.getString("gender"))&&
					txt_email.getText().contentEquals(rs.getString("email")))
			{
				JOptionPane.showMessageDialog(this, "未修改信息");
				this.setVisible(false);
			}else{
				int flag = JOptionPane.showConfirmDialog(jb_ok,"您的信息已经发生更改，你还要继续下去吗？");
				if(flag==0)
				{
					String sqlupdate = "update tb_reader set tel = '"+txt_tel.getText()+"',"+
									"gender = '"+txt_gender.getText()+"'	where rid ='"+user.getRid()+"'";
					SQLHelper.executeUpdate(sqlupdate);
					JOptionPane.showMessageDialog(this, "信息修改成功");
					this.setVisible(false);
				}
			}
			//SQLHelper.executeUpdate(sql);
		} catch (Exception e) {
		}
		
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == jb_edit)
		{
			edit_Click();
		}else if (source == jb_ok)
		{
			ok_Click();
		}
		
	}
}
