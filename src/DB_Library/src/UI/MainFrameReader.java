package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.*;

import dao.SQLHelper;
import entity.Admin;
import entity.Reader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainFrameReader extends JFrame{
	private JMenu m1;
	private JMenu m2;
	private JMenu m3;

	private Reader reader ;
	
	private void m11_Clicked(){
		reader = Reader.getReader(reader.getRid());
		InfoListUser infoList  =new InfoListUser(reader);
	}
	private void m12_Clicked()		//閫�嚭绯荤粺
	{
		JOptionPane.showMessageDialog(this, "书是人类进步的阶梯！");
		System.exit(0);
	}
	private void m21_Click()	//鍘嗗彶鍊熼槄璁板綍
	{
		HistoricalBorrowList historicalList = new HistoricalBorrowList(reader);
		
	}
	private void m22_Click()	//褰撳墠鍊熼槄璁板綍
	{
		CurrentBorrowList currentList = new CurrentBorrowList(reader);
	}
	private void m31_Click()
	{
		Search search = new Search();
	}
	
	private void m32_Click()
	{
		AllBookList abl = new AllBookList();
	}
	
	private void initMenu(){
		
		m1=new JMenu("用户信息");
		m2=new JMenu("借阅记录");
		m3=new JMenu("查询图书");
		
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
		
		JMenuItem m21 = new JMenuItem("历史借阅记录");
		m21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m21_Click();
				
			}
		});
		m2.add(m21);
		
		JMenuItem m22 = new JMenuItem("当前借阅记录");
		m22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				m22_Click();
			}
		});
		m2.add(m22);
		
		JMenuItem m31=new JMenuItem("查找书籍相关信息");
		m31.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
				m31_Click();
			}
		});
		m3.add(m31);
		
		JMenuItem m32=new JMenuItem("查看所有书籍相关信息");
		m32.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
				m32_Click();
			}
		});
		m3.add(m32);
		
		JMenuBar bar=new JMenuBar();
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		this.setJMenuBar(bar);

		
	}
	
	
    public MainFrameReader(Reader reader){
    	this.reader = reader;
    	initMenu();
    	JPanel jp = (JPanel) this.getContentPane();
    	this.setTitle("Welcome "+reader.getRname()+"!" );
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
