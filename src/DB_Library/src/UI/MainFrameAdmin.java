package UI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.*;

import dao.BorrowBookDao;
import dao.SQLHelper;
import entity.Admin;
import entity.Book;
import entity.Reader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Admin
 * 用户信息	图书管理	读者管理	借阅管理
 * 查询和修改	增加		增加		增加
 * 退出系统	删除		删除		修改
 * 			修改		修改		查询
 * 			查询		查询
 */
public class MainFrameAdmin extends JFrame{
	private JMenu m1;
	private JMenu m2;
	private JMenu m3;
	private JMenu m4;

	private Admin admin ;
	
	private void m11_Clicked(){
		admin.setSpwd(Admin.getpwdfromid(admin.getSid()));
		InfoListAdmin infoList  =new InfoListAdmin(admin);
	}
	private void m12_Clicked()
	{
		JOptionPane.showMessageDialog(this, "祝工作顺利！");
		System.exit(0);
	}
	
	private void m21_Click()	//增加图书信息
	{
		AddBook ab = new AddBook();
	}
	private void m22_Click()	//删除图书
	{
		String deletebid =JOptionPane.showInputDialog("请输入所要删除的书籍的索书号");
		if(deletebid!=null && deletebid.trim()!="")
		{
			String name ="";
			try {
				String sql = "select bookname from tb_book where bid = '"+deletebid+"'";
				ResultSet rs = SQLHelper.executeQuery(sql);
				rs.next();
				name = rs.getString("bookname");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "无效ID");
				return ;
			}
			int flag = JOptionPane.showConfirmDialog(this, "确定要删除索书号为"+deletebid+"的图书《"+name+"》吗？");
			if(flag ==0)
			{
				try {
					String sql = "delete_book('"+deletebid+"')";
					SQLHelper.call_procedure(sql);
					JOptionPane.showMessageDialog(this, "删除成功");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	private void m23_Click()	//修改图书信息
	{
		String changebid = JOptionPane.showInputDialog("输入你要修改书籍的索书号");
		if (changebid!=null){
			Book book = new Book();
			try {
				String sql = "select * from tb_book where bid = '"+changebid+"'";
				ResultSet rs = SQLHelper.executeQuery(sql);
				rs.next();
				book.setBid(changebid);
				book.setBname(rs.getString("bookname"));
				book.setBtypeid(rs.getString("typeID"));
				book.setAuthor(rs.getString("author"));
				book.setIsbn(rs.getString("ISBN"));
				book.setBookcase(rs.getString("bookcase"));
				book.setStorage(rs.getInt("storage"));
				EditBook eu = new EditBook(book);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "输入索书号有误，无法查到此图书");
				e.printStackTrace();
			}
			
		}
			
	}
	
	private void m24_Click()//查找图书信息
	{
		Search search = new Search();

	}
	private void m25_Click()//查看所有图书
	{
		AllBookList abl = new AllBookList();
	}
	
 	private void m31_Click()//增加读者信息
	{
		AddReader ab = new AddReader();
	}
	private void m32_Click()	///删除读者信息
	{
		String deleterid ="";
		deleterid =JOptionPane.showInputDialog("请输入所要删除的读者ID");
		if(deleterid!=null&&deleterid.trim()!="")
		{
			String name ="";
			try {
				String sql = "select rname from tb_reader where rid = '"+deleterid+"'";
				ResultSet rs = SQLHelper.executeQuery(sql);
				rs.next();
				name = rs.getString("rname");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "无效ID");
				return ;
			}
			int flag = JOptionPane.showConfirmDialog(this, "确定要删除ID为"+deleterid+"的读者"+name+"吗？");
			if(flag ==0)
			{
				try {
//					String sql = "delete_reader('"+deleterid+"')";
//					SQLHelper.call_procedure(sql);
					String sql = "delete from tb_reader where rid='"+deleterid+"'";
					SQLHelper.executeUpdate(sql);
					String sql1 = "delete from tb_borrowreturnrecord where readerid='"+deleterid+"'";
					SQLHelper.executeUpdate(sql1);
					JOptionPane.showMessageDialog(this, "删除成功");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	private void m33_Click()	//修改读者信息
	{
		String changerid = JOptionPane.showInputDialog("输入你要修改读者的ID");
		if (changerid!=null){
			Reader reader = new Reader();
			try {
				String sql = "select * from tb_reader where rid = '"+changerid+"'";
				ResultSet rs = SQLHelper.executeQuery(sql);
				rs.next();
				reader.setRid(changerid);
				reader.setRname(rs.getString("rname"));
				reader.setGender(rs.getString("gender"));
				reader.setTel(rs.getString("tel"));
				reader.setEmail(rs.getString("email"));
				ObserveReader or = new ObserveReader(reader);
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	private void m34_Click()	//查找读者
	{
		SearchReader sr = new SearchReader();
	}
	private void m35_Click()	//查看所有读者
	{
		AllReaderList arl = new AllReaderList();
	}
	
	private void m41_Click()	//增加借阅信息
	{
		AddBorrowList abl = new AddBorrowList();
	}
	private void m42_Click()	//修改借阅信息
	{
		String bookid = JOptionPane.showInputDialog("输入要归还书籍的索书号");
		if (bookid!=null){
			try {
				String sql = "select count(*) from tb_borrowreturnrecord  where bookid = '"+bookid+"' and returndate IS NULL ";                  
				ResultSet rs = SQLHelper.executeQuery(sql);
				rs.next();
				int rows = rs.getInt(1);
				if (rows ==1){
					BorrowBookDao.returnbook(bookid);
					JOptionPane.showMessageDialog(this, "还书成功！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "索书号错误或该书未被借阅无法归还！");
			}
		}
	}
	private void m43_Click()	//查找借阅信息
	{
		SearchBorrow bw = new SearchBorrow();
	}
	
	private void m44_Click()	//查看所有借阅信息
	{
		AllBorrowList alb = new AllBorrowList();
	}
	
	
	private void initMenu(){
		
		m1=new JMenu("用户信息");
		m2=new JMenu("图书管理");
		m3=new JMenu("读者管理");
		m4=new JMenu("借阅管理");
		
		JMenuItem m11=new JMenuItem("查询和修改");
		m11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
				m11_Clicked();
			}
		});
		m1.add(m11);
		JMenuItem m12 =new JMenuItem("退出系统");
		m12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m12_Clicked();
			}
		});
		m1.add(m12);
		
		JMenuItem m21 = new JMenuItem("增加图书");
		m21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m21_Click();
				
			}
		});
		m2.add(m21);
		
		JMenuItem m22 = new JMenuItem("删除图书");
		m22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				m22_Click();
			}
		});
		m2.add(m22);
		
		JMenuItem m23 = new JMenuItem("修改图书信息");
		m23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m23_Click();
			}
		});
		m2.add(m23);
		
		JMenuItem m24 = new JMenuItem("查找图书信息");
		m24.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m24_Click();
			}
		});
		m2.add(m24);
		
		JMenuItem m25 = new JMenuItem("查看所有图书信息");
		m25.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m25_Click();
			}
		});
		m2.add(m25);
		
		JMenuItem m31 = new JMenuItem("增加读者");
		m31.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m31_Click();
			}
		});
		m3.add(m31);

		JMenuItem m32 = new JMenuItem("删除读者");
		m32.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m32_Click();
			}
		});
		m3.add(m32);
		
		
		JMenuItem m33 = new JMenuItem("修改读者信息");
		m33.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m33_Click();
			}
		});
		m3.add(m33);
		
		JMenuItem m34 = new JMenuItem("查找读者信息");
		m34.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m34_Click();
			}
		});
		m3.add(m34);
		
		JMenuItem m35 = new JMenuItem("查看所有读者信息");
		m35.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m35_Click();
			}
		});
		m3.add(m35);
		
		JMenuItem m41 = new JMenuItem("借阅图书");
		m41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m41_Click();
			}
		});
		m4.add(m41);
		
		JMenuItem m42 = new JMenuItem("归还图书");
		m42.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m42_Click();
			}
		});
		m4.add(m42);
		
		JMenuItem m43 = new JMenuItem("查找借阅信息");
		m43.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m43_Click();
			}
		});
		m4.add(m43);
		
		JMenuItem m44 = new JMenuItem("查看所有借阅信息");
		m44.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m44_Click();
			}
		});
		m4.add(m44);
		
		
		
		JMenuBar bar=new JMenuBar();
		bar.add(m1);bar.add(m2);bar.add(m3);bar.add(m4);
		this.setJMenuBar(bar);
	}
    public MainFrameAdmin(Admin admin){
    	this.admin = admin;
    	initMenu();
    	JPanel jp = (JPanel) this.getContentPane();
    	this.setTitle("Welcome "+admin.getSname()+"!" );
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
