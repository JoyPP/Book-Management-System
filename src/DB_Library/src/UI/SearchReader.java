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

public class SearchReader  extends JFrame implements ActionListener{

	private GridBagConstraints c;
	private JLabel lbl_rid ;
	private JTextField txt_content;
	private JRadioButton rbm_rid;
	private JRadioButton rbm_rname;
	private JButton btn_ok;
	private JButton btn_cancel ;
	
	String right;
	
	public SearchReader()
	{
		initComponent();
		
		this.setSize(340, 180);
		this.setVisible(true);

	}
    
	public void initComponent() {

		setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		
		lbl_rid = new JLabel("请输入查询的读者信息");
		txt_content = new JTextField(18);
		
		rbm_rname = new JRadioButton("读者名");
		rbm_rname.setSelected(true);
		rbm_rid = new JRadioButton("读者ID");
		rbm_rid.setSelected(true);
		
		btn_ok = new JButton("确认");
		btn_cancel = new JButton("取消");
		
		//
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=4;
		c.gridheight=1;
		c.ipady=1;
		c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.WEST;
		this.add(lbl_rid, c);
		//锟矫伙拷锟斤拷--锟斤拷锟斤拷锟�
		c.gridx++;
		//c.gridy++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		//c.fill=GridBagConstraints.NORTHWEST;
		c.anchor=GridBagConstraints.EAST;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_content, c);
		//权锟斤拷
		//查询选项
		c.gridwidth =1;
		c.gridx=1;
		c.gridy++;
		JPanel rbp=new JPanel();
		rbp.setLayout(new GridLayout(1, 2));
		
		rbp.add(rbm_rname);
		rbp.add(rbm_rid);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbm_rname);
		bg.add(rbm_rid);
		this.right= "rname";
		c.gridwidth =2;
		c.anchor=GridBagConstraints.CENTER;
		this.add(rbm_rname,c);
		c.gridx++;
		c.anchor=GridBagConstraints.WEST;
		this.add(rbm_rid, c);
		
		//添加按钮
		c.gridx=0;
		c.gridwidth =1;
		c.gridy++;
		c.anchor=GridBagConstraints.EAST;
		this.add(btn_ok, c);
		c.gridx++;
		c.gridx++;
		c.anchor=GridBagConstraints.CENTER;
		this.add(btn_cancel,c);
		
		
		
		//监听
		this.rbm_rid.addActionListener(this);
		this.rbm_rname.addActionListener(this);
		this.btn_cancel.addActionListener(this);
		this.btn_ok.addActionListener(this);
	
		this.setTitle("查询读者相关信息");
	}

	public void  actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.rbm_rid){
			this.right = "rid";
		}
		else if (source == this.rbm_rname){
			this.right = "rname";
		}
		if (source == this.btn_ok)
			btn_ok_Clicked();
		else if (source == this.btn_cancel)
			btn_cancel_Clicked();
	}
	
	private void btn_ok_Clicked() 
	{
		String content = this.txt_content.getText().trim();
		SearchListReader slr = new SearchListReader(content,right);
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
