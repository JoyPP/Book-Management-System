package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import dao.BooktypeDao;
import dao.PublishingDao;
import dao.SQLHelper;
import dao.BookDao;
import entity.Book;


public class AddBook extends JPanel implements  ActionListener{

	//private UserService userService;
	private GridBagConstraints c;
	private JFrame jf = new JFrame();
	private Book book = new Book();
	private JLabel lab_bookname;
	private JLabel lab_typeID;
	private JLabel lab_author;
	private JLabel lab_ISBN;
	private JLabel lab_bookcase;
	private JLabel lab_storage;
	private JTextField txt_bookname;
	private JTextField txt_typeID;
	private JTextField txt_author;
	private JTextField txt_ISBN;
	private JTextField txt_bookcase;
	private JTextField txt_storage;
	private JButton btn_ok;
	private JButton btn_reset;
	
	public AddBook() {
		
		initComponentNormal();

		this.setSize(340, 300);
		this.setVisible(true);
		jf.setSize(340,300);
		jf.setVisible(true);
		jf.add(this);
		
	}
	//
	private void initComponentNormal(){
		setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		lab_bookname=new JLabel("                   书名: ");
		//lab_bookname=new JLabel("      			  书名: ");
		txt_bookname=new JTextField(15);
		lab_typeID=new JLabel("       类型: ");
		txt_typeID=new JTextField(15);
		lab_author=new JLabel("       作者: ");
		txt_author=new JTextField(15);
		lab_ISBN=new JLabel("       出版社: ");
		txt_ISBN=new JTextField(15);
		lab_bookcase=new JLabel("       借阅室: ");
		txt_bookcase=new JTextField(15);
		lab_storage=new JLabel("      库存量: ");
		txt_storage=new JTextField(15);
		txt_storage.setText("1");
		txt_storage.setEditable(false);
		
		

		btn_ok=new JButton("确认");
		btn_reset=new JButton("重置");
		
		//书名
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.ipady=1;
		c.anchor=GridBagConstraints.CENTER;
		this.add(lab_bookname, c);
		//书名--输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_bookname, c);
		
		//类型
		c.gridx=0;
		c.gridy++;
		c.anchor=GridBagConstraints.CENTER;
		this.add(lab_typeID,c);
		//类型-输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_typeID,c);
	

		//作者
		c.gridx=0;
		c.gridy++;
		this.add(lab_author,c);
		//作者-输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_author,c);
	

		//ISBN
		c.gridx=0;
		c.gridy++;
		this.add(lab_ISBN,c);
		//ISBN-输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_ISBN,c);
	

		//书架
		c.gridx=0;
		c.gridy++;
		this.add(lab_bookcase,c);
		//书架-输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_bookcase,c);
	

		//库存
		c.gridx=0;
		c.gridy++;
		this.add(lab_storage,c);
		//库存-输入框
		c.gridx++;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=0;
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(0, 0, 1, 0);
		this.add(txt_storage,c);
		txt_storage.setEditable(false);
		
		//添加按钮
		c.gridx=0;
		c.gridy++;
		this.add(btn_ok, c);
		c.gridx++;
		this.add(btn_reset, c);
		
		this.btn_ok.addActionListener(this);
		this.btn_reset.addActionListener(this);
		
	
	}
	
	
	//重置
	private void reset(){
		this.txt_bookname.setText(null);
		this.txt_typeID.setText(null);
		this.txt_author.setText(null);
		this.txt_ISBN.setText(null);
		this.txt_bookcase.setText(null);
	//	this.txt_storage.setText(null);
	}
	
	//是否有效
	private boolean validator(){
		String s1=this.txt_bookname.getText();
		String s2=this.txt_typeID.getText();
		String s3=this.txt_author.getText();
		String s4=this.txt_ISBN.getText();
		String s5=this.txt_bookcase.getText();
	//	String s6=this.txt_storage.getText();
		
		if ((s1==null || "".equals(s1)) || ("".equals(s2) || s2==null)
				 || ("".equals(s3) || s3==null) || ("".equals(s4) || s4==null)
				 || ("".equals(s5) || s5==null) ){//|| ("".equals(s6) || s6==null)) {
			JOptionPane.showMessageDialog(this, "上述信息不能为空！");
			return false;
		}
/*		else if (!"1".equals(s6))
		{
			JOptionPane.showMessageDialog(this, "库存量只能设为1！");
			System.exit(0);
			return false;
		}*/
		else
			return true;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==this.btn_ok){
			if (validator())
			{
				book.setBname(txt_bookname.getText());
				book.setBtypeid(txt_typeID.getText());
				book.setAuthor(txt_author.getText());
				book.setIsbn(txt_ISBN.getText());
				book.setBookcase(txt_bookcase.getText());
				book.setStorage(1);
				book.setBid(BookDao.genID());
				BookDao.addBook(toSQL(book));
				//修改type和ISBN
				try {
					
					String sql1 = "select count(*) from tb_booktype where typename = '"+book.getBtypeid()+"'";
					ResultSet rs1 = SQLHelper.executeQuery(sql1);
					rs1.next();
					int rows1;
					rows1 = rs1.getInt(1);
					if (rows1 == 1)	//修改booktype
					{
						String s = "update tb_booktype set typecount = typecount + 1 where typename = '"+book.getBtypeid()+"'";
						SQLHelper.executeUpdate(s);
					}
					else{
						String s = "'"+BooktypeDao.genID()+"','"+book.getBtypeid()+"',1";
						BooktypeDao.addBookType(s);
					}
					
					String sql2 = "select count(*) from tb_publishing where pubname = '"+book.getIsbn()+"'";
					ResultSet rs2 = SQLHelper.executeQuery(sql2);
					rs2.next();
					int rows2;
					rows2 = rs2.getInt(1);
					if (rows2 == 1)	//修改publishing
					{
						String s = "update tb_publishing set pubcount = pubcount + 1 where pubname = '"+book.getIsbn()+"'";
						SQLHelper.executeUpdate(s);
					}
					else{
						String s = "'"+PublishingDao.genID()+"','"+book.getIsbn()+"',1";
						PublishingDao.addPublishing(s);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(this, "图书添加成功！此书索书号为"+book.getBid());
				this.setVisible(false);
				jf.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(this, "图书添加失败！");
			}
		}
		else if(source==this.btn_reset){
			reset();
		}
	}
	public String toSQL(Book book)
	{
		return "'"+book.getBid()+"',"+"'"+book.getBname()+"',"+"'"+book.getBtypeid()+"',"+"'"+book.getAuthor()+"',"+"'"+book.getIsbn()+"',"+"'"+book.getBookcase()+"',"+"1";
	}
	public void checkUserName(String name)
	{
		
	}


}
