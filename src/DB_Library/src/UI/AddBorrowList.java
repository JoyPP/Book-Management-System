package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BorrowBookDao;
import dao.SQLHelper;
import entity.BorrowBook;


public class AddBorrowList extends JPanel implements  ActionListener{

	//private UserService userService;
	private GridBagConstraints c;
	private JFrame jf = new JFrame();
	private BorrowBook borrowbook = new BorrowBook();
	private JLabel lab_bookid;
//	private JLabel lab_bookname;
	private JLabel lab_readerid;
	private JLabel lab_borrowdate;
//	private JLabel lab_returndate;
	private JTextField txt_bookid;
	private String bookname = "";
	private JTextField txt_readerid;
	private JTextField txt_borrowdate;
//	private JTextField txt_returndate;
	private JButton btn_ok;
	private JButton btn_reset;
	
	public AddBorrowList() {
		
		initComponentNormal();

		this.setSize(340, 180);
		this.setVisible(true);
		jf.setSize(340,300);
		jf.setVisible(true);
		jf.add(this);
		
	}
	//
	private void initComponentNormal(){
		setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		lab_bookid=new JLabel("�����: ");
		txt_bookid=new JTextField(15);
	//	lab_bookname=new JLabel("        ����: ");
	//	txt_bookname=new JTextField(10);
		lab_readerid=new JLabel("����ID: ");
		txt_readerid=new JTextField(15);
	//	lab_borrowdate=new JLabel("        ����ʱ��: ");
	//	txt_borrowdate=new JTextField(10);
	//	lab_returndate=new JLabel("        �黹ʱ��: ");
	//	txt_returndate=new JTextField(15);
		
		btn_ok=new JButton("ȷ��");
		btn_reset=new JButton("����");
		
		//�����
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.ipady=1;
		c.anchor=GridBagConstraints.CENTER;
		this.add(lab_bookid, c);
		//�����--�����
		c.gridx++;
		//c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.WEST;
		//c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_bookid, c);

		//����ID
		c.gridx=0;
		c.gridy++;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.CENTER;
		this.add(lab_readerid,c);
		//����ID-�����
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.WEST;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_readerid,c);

		//��Ӱ�ť
		c.gridx=0;
		c.gridy++;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.EAST;
		this.add(btn_ok, c);
		c.gridx++;
		c.anchor=GridBagConstraints.CENTER;
		this.add(btn_reset, c);
		
		this.btn_ok.addActionListener(this);
		this.btn_reset.addActionListener(this);
	}
	
	
	//����
	private void reset(){
		this.txt_bookid.setText(null);
	//	this.txt_bookname.setText(null);
		this.txt_readerid.setText(null);
	//	this.txt_borrowdate.setText(null);
	}
	
	//�Ƿ���Ч
	private boolean validator(){
		String s1=this.txt_bookid.getText();
		//String s2=this.txt_bookname.getText();
		String s3=this.txt_readerid.getText();
		//String s4=this.txt_borrowdate.getText();
		//�����Ч��--���Ƿ���bookid��readerid��bookname�Զ�����
		
		if ((s1==null || "".equals(s1))
				 || ("".equals(s3) || s3==null)){// || ("".equals(s4) || s4==null)) {
			JOptionPane.showMessageDialog(this, "������Ϣ����Ϊ�գ�");
			return false;
		}
		else {
			
			try {
				String sql1 = "select count(*) from tb_book where bid = '"+s1+"' and storage = 1";
				ResultSet rs1 = SQLHelper.executeQuery(sql1);
				rs1.next();
				int rows1 = rs1.getInt(1);
				if (rows1 != 1){
					JOptionPane.showMessageDialog(this, "����Ų����ڻ�ͼ���ѱ����ߣ�");
					return false;
				}
				else{
					String sql = "select bookname from tb_book where bid = '"+s1+"'";
					ResultSet rs = SQLHelper.executeQuery(sql);
					rs.next();
					bookname = rs.getString("bookname");
				}
				String sql2 = "select count(*) from tb_reader where rid = '"+s3+"'";
				ResultSet rs2 = SQLHelper.executeQuery(sql2);
				rs2.next();
				int rows2 = rs2.getInt(1);
				if (rows2 != 1){
					JOptionPane.showMessageDialog(this, "����ID�����ڣ�");
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==this.btn_ok){
			if (validator())
			{
				Date now = new Date();
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				borrowbook.setBookid(txt_bookid.getText());
				borrowbook.setBookname(bookname);
				borrowbook.setReaderid(txt_readerid.getText());
				borrowbook.setBorrowdate(df.format(now));
				BorrowBookDao.addBorrowBook(toSQL(borrowbook));
				BorrowBookDao.borrow(borrowbook.getBookid());
//				SQLHelper.call_procedure("info_sync('"+borrowbook.getBookid()+"','"+
	//				borrowbook.getBookname()+"','"+borrowbook.getReaderid()+"','"+borrowbook.getBorrowdate()+"')");
				JOptionPane.showMessageDialog(this, "������Ϣ��ӳɹ������������Ϊ"+borrowbook.getBookid()+"����IDΪ"+borrowbook.getReaderid());
				this.setVisible(false);
				jf.setVisible(false);
			}
		}
		else if(source==this.btn_reset){
			reset();
		}
	}
	public String toSQL(BorrowBook borrowbook)
	{
		//System.out.println(borrowbook.getReturndate());
		return "'"+borrowbook.getBookid()+"',"+"'"+borrowbook.getBookname()+"',"+"'"+borrowbook.getReaderid()+"',"+"'"+borrowbook.getBorrowdate()+"', null";                
	}
	

}
