package dataTransferObjects;

import java.io.Serializable;

public class Book implements Serializable{

	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private Integer bookQuantity;
	
	
	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public Integer getBookQuantity() {
		return bookQuantity;
	}


	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookQuantity="
				+ bookQuantity + "]";
	}
	
	
	
}
