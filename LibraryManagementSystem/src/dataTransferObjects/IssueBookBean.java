package dataTransferObjects;

import java.io.Serializable;
import java.sql.Date;

public class IssueBookBean implements Serializable{
	
	private Integer bookId;
	private Integer sid;
	private String sname;
	private long mobile;
	private Date issueDate;
	private String returnDate;
	private Integer fineAmount;
	
	
	public Integer getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(Integer fineAmount) {
		this.fineAmount = fineAmount;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String string) {
		this.sname = string;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date date) {
		this.issueDate = date;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "IssueBookBean [bookId=" + bookId + ", sid=" + sid + ", sname=" + sname + ", mobile=" + mobile
				+ ", issueDate=" + issueDate + ", returndate=" + returnDate + ", FineAmount=" + fineAmount
				+ "]";
	}
	

	
}
