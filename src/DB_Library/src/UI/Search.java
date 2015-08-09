package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Search  extends JFrame implements ActionListener{

	private GridBagConstraints c;
	
	private JLabel lbl_name ;
	private JTextField txt_content;
	private JRadioButton rbm_bookname;
	private JRadioButton rbm_bookid;
	private JRadioButton rbm_author;	
	private JButton btn_ok;
	private JButton btn_cancel ;
	
	String right;
	
	public Search()
	{
		initComponent();
		
		this.setSize(340, 200);
		this.setVisible(true);

	}
    
	public void initComponent() {

		setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		
		lbl_name = new JLabel("请输入查询内容：");
		txt_content = new JTextField(18);
		rbm_bookname = new JRadioButton("书名");
		rbm_bookname.setSelected(true);
		rbm_bookid = new JRadioButton("索书号");
		rbm_bookid.setSelected(true);
		rbm_author = new JRadioButton("作者");
		rbm_author.setSelected(true);
		btn_ok = new JButton("确认");
		btn_cancel = new JButton("取消");
		
		//
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.ipady=1;
		c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.WEST;
		this.add(lbl_name, c);
		//文本框
		c.gridx++;
		//c.gridy;
		c.gridwidth=8;
		c.weightx=1;
		c.weighty=0;
		//c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.WEST;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_content, c);
		//查询选项
		c.gridwidth =1;
		c.gridx=1;
		c.gridy++;
		JPanel rbp=new JPanel();
		rbp.setLayout(new GridLayout(1, 3));
		rbp.add(rbm_bookname);
		rbp.add(rbm_bookid);
		rbp.add(rbm_author);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbm_bookname);
		bg.add(rbm_bookid);
		bg.add(rbm_author);
		this.right= "bookname";
		this.add(rbm_bookname,c);
		c.gridx++;
		this.add(rbm_bookid, c);
		c.gridx++;
		this.add(rbm_author, c);
		
		//添加按钮
		c.gridx=0;
		c.gridwidth =1;
		c.gridy++;
		c.anchor=GridBagConstraints.EAST;
		this.add(btn_ok, c);
		c.gridx++;
		c.gridx++;
		c.anchor=GridBagConstraints.WEST;
		this.add(btn_cancel,c);
		
		
		
		//this.add(jp);
		
		
		
		//监听
		this.rbm_bookname.addActionListener(this);
		this.rbm_bookid.addActionListener(this);
		this.rbm_author.addActionListener(this);
		this.btn_cancel.addActionListener(this);
		this.btn_ok.addActionListener(this);
	
		this.setTitle("查询书籍相关信息");
	}

	public void  actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.rbm_bookname)
			this.right = "bookname";
		else if (source == this.rbm_bookid)
			this.right = "bookid";
		else if (source == this.rbm_author)
			this.right = "author";
		else if (source == this.btn_ok)
			btn_ok_Clicked();
		else if (source == this.btn_cancel)
			btn_cancel_Clicked();
	}
	
	private void btn_ok_Clicked() 
	{
		String content = this.txt_content.getText().trim();
		SearchList searchlist = new SearchList(content,right);
	}	
	private void reset()
	{
		this.txt_content.setText("");
	}

	private void btn_cancel_Clicked()
	{
		this.setVisible(false);
		//System.exit(0);
	}

}
