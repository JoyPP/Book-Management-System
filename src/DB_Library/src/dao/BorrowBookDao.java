package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class BorrowBookDao {

	public static void addBorrowBook(String string) {
		try {
			System.out.println("insert string is "+string);
			String sql = "insert into tb_borrowreturnrecord values("+string+")";
			SQLHelper.executeUpdate(sql);
		} catch (Exception ex) {

		}
	}
	
	public static void borrow(String bookid){
		try{
			
			
			String sql = "update tb_book set storage = 0 where bid = '"+bookid+"' and storage = 1";
			SQLHelper.executeUpdate(sql);
		}catch(Exception ex){

		}
	}
	
	public static void returnbook(String bookid){
		try{
			Date now = new Date();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sql1 = "update tb_book set storage = 1 where bid = '"+bookid+"'";
			SQLHelper.executeUpdate(sql1);
			String sql2 = "update tb_borrowreturnrecord set returndate = '"+df.format(now)+"' where bookid = '"+bookid+"' and returndate IS NULL ";                  
			SQLHelper.executeUpdate(sql2);
			
		}catch(Exception ex){
			
		}
	}
}
