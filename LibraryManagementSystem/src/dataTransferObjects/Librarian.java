package dataTransferObjects;

public class Librarian {
	
	private Integer id;
	private String name;
	private String password;
	private long mobile;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public long getMobile() {
		return mobile;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile + "]";
	}
	
	

}
