package dataTransferObjects;

import java.io.Serializable;

public class Student implements Serializable{
	
	private Integer sid;
	private String sname;
	private String sbranch;
	private long mobile;
	private Integer borrowbooks;
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}
	public Integer getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	public String getSbranch() {
		return sbranch;
	}
	public void setMobile(long mobile) {
		this.mobile=mobile;
	}
	public long getMobile() {
		return mobile;
	}
	
	

}
