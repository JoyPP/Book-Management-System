package entity;

public class Book {
	private String bid ;
	private String bname;
	private String btypeid ;
	private String author ;
	private String isbn ;
	private String bookcase ;
	private int storage;
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtypeid() {
		return btypeid;
	}
	public void setBtypeid(String btypeid) {
		this.btypeid = btypeid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookcase() {
		return bookcase;
	}
	public void setBookcase(String bookcase) {
		this.bookcase = bookcase;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
}
