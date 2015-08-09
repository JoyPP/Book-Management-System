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

import dao.BooktypeDao;
import dao.PublishingDao;
import dao.SQLHelper;
import entity.Book;

public class EditBook extends JFrame implements ActionListener {

	private Book book;
	private JLabel lab_bid;
	private JLabel lab_bname;
	private JLabel lab_btypeid;
	private JLabel lab_author;
	private JLabel lab_isbn;
	private JLabel lab_bookcase;
	private JLabel lab_storage;

	private JTextField txt_bid;
	private JTextField txt_bname;
	private JTextField txt_btypeid;
	private JTextField txt_author;
	private JTextField txt_isbn;
	private JTextField txt_bookcase;
	private JTextField txt_storage;

	private JButton jb_ok;
	private JButton jb_edit;

	private void initComponent() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(9, 1));
		lab_bid = new JLabel("索书号");
		lab_bname = new JLabel("书名");
		lab_btypeid = new JLabel("类型");
		lab_author = new JLabel("作者");
		lab_isbn = new JLabel("出版社");
		lab_bookcase = new JLabel("借阅室");
		lab_storage = new JLabel("库存量");

		txt_bid = new JTextField(book.getBid());
		txt_bid.setEditable(false);

		txt_bname = new JTextField(book.getBname());
		txt_bname.setEditable(false);

		txt_btypeid = new JTextField(book.getBtypeid());
		txt_btypeid.setEditable(false);

		txt_author = new JTextField(book.getAuthor());
		txt_author.setEditable(false);

		txt_isbn = new JTextField(book.getIsbn());
		txt_isbn.setEditable(false);

		txt_bookcase = new JTextField(book.getBookcase());
		txt_bookcase.setEditable(false);

		txt_storage = new JTextField(Integer.toString(book.getStorage()));
		txt_storage.setEditable(false);

		jp.add(lab_bid);
		jp.add(txt_bid);
		jp.add(lab_bname);
		jp.add(txt_bname);
		jp.add(lab_btypeid);
		jp.add(txt_btypeid);
		jp.add(lab_author);
		jp.add(txt_author);
		jp.add(lab_isbn);
		jp.add(txt_isbn);
		jp.add(lab_bookcase);
		jp.add(txt_bookcase);
		jp.add(lab_storage);
		jp.add(txt_storage);

		jb_ok = new JButton("确定");
		jb_edit = new JButton("编辑");

		jp.add(jb_ok);
		jp.add(jb_edit);

		this.add(jp);

		jb_edit.addActionListener(this);
		jb_ok.addActionListener(this);

	}

	public EditBook(Book book) {
		this.book = book;
		initComponent();
		this.setSize(350, 500);
		this.setVisible(true);
	}

	private void edit_Click() {
		txt_bname.setEditable(true);
		txt_btypeid.setEditable(true);
		txt_author.setEditable(true);
		txt_isbn.setEditable(true);
		txt_bookcase.setEditable(true);
		// txt_storage.setEditable(true);
	}

	// 修改图书信息
	private void ok_Click() {
		try {
			if (!txt_bname.getText().contentEquals(book.getBname())
					|| !txt_btypeid.getText().contentEquals(book.getBtypeid())
					|| !txt_author.getText().contentEquals(book.getAuthor())
					|| !txt_isbn.getText().contentEquals(book.getIsbn())
					|| !txt_bookcase.getText()
							.contentEquals(book.getBookcase())) {
				int flag = JOptionPane.showConfirmDialog(jb_ok, book.getBid()
						+ "的信息已经发生更改，你还要继续下去吗？");
				if (flag == 0) {
					//
					// String sql = "update_book('"+book.getBid()+"')";
					// SQLHelper.call_procedure(sql);
					//

					// 修改type和ISBN
					try {

						if (!txt_btypeid.getText().contentEquals(
								book.getBtypeid())) {
							String s = "update tb_booktype set typecount = typecount - 1 where typename = '"
									+ book.getBtypeid() + "'";
							SQLHelper.executeUpdate(s);
							// 然后查看改后的有没有
							String sql1 = "select count(*) from tb_booktype where typename = '"
									+ txt_btypeid.getText() + "'";
							ResultSet rs1 = SQLHelper.executeQuery(sql1);
							rs1.next();
							int rows1;
							rows1 = rs1.getInt(1);
							if (rows1 == 1) // 修改booktype
							{
								String s1 = "update tb_booktype set typecount = typecount + 1 where typename = '"
										+ txt_btypeid.getText() + "'";
								SQLHelper.executeUpdate(s1);
							} else {
								String s1 = "'" + BooktypeDao.genID() + "','"
										+ txt_btypeid.getText() + "',1";
								BooktypeDao.addBookType(s1);
							}

						}

						if (!txt_isbn.getText().contentEquals(book.getIsbn())) {
							String s = "update tb_publishing set pubcount = pubcount - 1 where pubname = '"
									+ book.getIsbn() + "'";
							SQLHelper.executeUpdate(s);
							// 然后查看改后的有没有
							String sql2 = "select count(*) from tb_publishing where pubname = '"
									+ txt_isbn.getText() + "'";
							ResultSet rs2 = SQLHelper.executeQuery(sql2);
							rs2.next();
							int rows2;
							rows2 = rs2.getInt(1);
							if (rows2 == 1) // 修改publishing
							{
								String s1 = "update tb_publishing set pubcount = pubcount + 1 where pubname = '"
										+ txt_isbn.getText() + "'";
								SQLHelper.executeUpdate(s1);
							} else {
								String s1 = "'" + PublishingDao.genID() + "','"
										+ txt_isbn.getText() + "',1";
								PublishingDao.addPublishing(s1);
							}
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					String sqlupdate = "update tb_book set bookname = '"
							+ txt_bname.getText() + "',typeID='"
							+ txt_btypeid.getText() + "',author = '"
							+ txt_author.getText() + "',ISBN='"
							+ txt_isbn.getText() + "',bookcase = '"
							+ txt_bookcase.getText() + "' where bid ='"
							+ book.getBid() + "'";
					SQLHelper.executeUpdate(sqlupdate);

					String sqlborrowlist = "update tb_borrowreturnrecord set bookname = (select bookname from tb_book where bid = '"
							+ book.getBid()
							+ "')  where bookid = '"
							+ book.getBid() + "'";
					SQLHelper.executeUpdate(sqlborrowlist);
					JOptionPane.showMessageDialog(this, "信息修改成功");
					this.setVisible(false);

				} else
					reset();
			} else {
				this.setVisible(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "修改失败");
			reset();
			e.printStackTrace();
		}

	}

	private void reset() {
		txt_bname.setText(book.getBname());
		txt_btypeid.setText(book.getBtypeid());
		txt_author.setText(book.getAuthor());
		txt_isbn.setText(book.getIsbn());
		txt_bookcase.setText(book.getBookcase());
		txt_storage.setText(Integer.toString(book.getStorage()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == jb_edit) {
			edit_Click();
		} else if (source == jb_ok) {
			ok_Click();
		}

	}
}
