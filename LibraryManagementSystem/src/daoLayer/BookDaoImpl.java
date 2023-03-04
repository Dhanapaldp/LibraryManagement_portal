package daoLayer;

import java.io.IOException;
import dataTransferObjects.IssueBookBean;
import dataTransferObjects.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dataTransferObjects.Book;
import util.JdbcUtil;

public class BookDaoImpl implements IBookDao {

	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet resultSet=null;
	static Integer fine;
	@Override
	public String addBook(Book book) {
		
		String myQuery="insert into bookdetails(bookname,bookauthor,bookquantity) values(?,?,?)";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setString(1, book.getBookName());
				pst.setString(2,book.getBookAuthor());
				pst.setInt(3, book.getBookQuantity());
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}

	@Override
	public Book searchBook(Integer id) {
		
		Book book=null;
		String myQuery="select * from bookdetails where bookid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setInt(1,id);
				
				resultSet = pst.executeQuery();
			}
			if(resultSet!=null)
			{
				book=new Book();
				if(resultSet.next())
				{
					book.setBookId(resultSet.getInt(1));
				    book.setBookName(resultSet.getString(2));
			        book.setBookAuthor(	resultSet.getString(3));
				    book.setBookQuantity(resultSet.getInt(4));
				    return book;
				}
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return null;
		
	}

	@Override
	public String updateBook(Book book) {
		String myQuery="update bookdetails set bookName=?,bookauthor=?,bookquantity=? where bookid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setString(1, book.getBookName());
				pst.setString(2,book.getBookAuthor());
				pst.setInt(3, book.getBookQuantity());
				pst.setInt(4, book.getBookId());
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}

	@Override
	public String deleteBook(Integer id) {
		String myQuery="delete from bookdetails where bookid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setInt(1, id);
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}
	

	public List<Book> viewBooks() {
		List<Book> list=new ArrayList<Book>();
		try{
			connection=JdbcUtil.getConnect();
			pst=connection.prepareStatement("select * from bookdetails");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Book bean=new Book();
				bean.setBookId(rs.getInt(1));
				bean.setBookName(rs.getString(2));
				bean.setBookAuthor(rs.getString(3));
				bean.setBookQuantity(rs.getInt(4));
				
				list.add(bean);
			}
			connection.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public List<IssueBookBean> viewBookUsers() {
		List<IssueBookBean> list=new ArrayList<IssueBookBean>();
		try{
			connection=JdbcUtil.getConnect();
			pst=connection.prepareStatement("select * from issuebook");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				IssueBookBean bean=new IssueBookBean();
				bean.setBookId(rs.getInt(1));
				bean.setSid(rs.getInt(2));
				bean.setSname(rs.getString(3));
				bean.setMobile(rs.getLong(4));
				bean.setIssueDate(rs.getDate(5));
				bean.setReturnDate(rs.getString(6));
				bean.setFineAmount(rs.getInt(7));
				
				list.add(bean);
			}
			connection.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public static boolean checkIssue(Integer id){
		boolean status=false;
		try{
			Connection con=JdbcUtil.getConnect();
			PreparedStatement ps=con.prepareStatement("select * from bookdetails where bookid=? and bookquantity>0");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static boolean checkBorrowBooks(Integer id){
		boolean status=false;
		try{
			Connection con=JdbcUtil.getConnect();
			PreparedStatement ps=con.prepareStatement("select borrowbooks from student where student_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int quantity=rs.getInt("borrowbooks");
				if(quantity<3) {
				  status=true;
				}
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public String issueBook(IssueBookBean bean){
		Integer id=bean.getBookId();
		Integer sid = bean.getSid();
		boolean checkstatus=checkIssue(id);
		boolean checkstatus1=checkBorrowBooks(sid);
		if(checkstatus && checkstatus1){
			int status=0;
			try{
				Connection con=JdbcUtil.getConnect();
				PreparedStatement ps=con.prepareStatement("insert into issuebook(book_id,student_id,student_name,mobile_number,Issued_date) values(?,?,?,?,?)");
				ps.setInt(1,bean.getBookId());
				ps.setInt(2,bean.getSid());
				ps.setString(3,bean.getSname());
				ps.setLong(4,bean.getMobile());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps1=con.prepareStatement("update student set borrowbooks=borrowbooks+1 where student_id=?");
					ps1.setInt(1,sid);
					status=ps1.executeUpdate();
					
					PreparedStatement ps2=con.prepareStatement("update bookdetails set bookquantity=bookQuantity-1 where bookid=?");
					ps2.setInt(1,id);
					status=ps2.executeUpdate();
					return "success";
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);
			return "failed";}	
		}else{
			return "failure";
		}
		return "failure";
	}
	
	public  String returnBook(Integer bookid,int sid){
		int status=0;
		Integer fineAmount=0;
			try{
				
				java.sql.Date returnDate=new java.sql.Date(System.currentTimeMillis());
				Connection con=JdbcUtil.getConnect();
				PreparedStatement ps=con.prepareStatement("update issuebook set Return_Date=?, Fine_Amount=? where book_id=? and student_id=?");
				PreparedStatement ps1=con.prepareStatement("select Issued_date from issuebook where book_id=? and student_id=?");
				ps1.setInt(1,bookid);
				ps1.setInt(2,sid);
				ResultSet rs = ps1.executeQuery();
				
				if(rs.next()) {
				   fineAmount=calculateFine(rs.getDate("Issued_date"),returnDate);
				}
				
				ps.setDate(1, returnDate);
				ps.setInt(2,fineAmount);
				ps.setInt(3,bookid);
				ps.setInt(4, sid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps3=con.prepareStatement("update student set borrowbooks=borrowbooks-1 where student_id=?");
					ps3.setInt(1,sid);
					status=ps3.executeUpdate();
					
					PreparedStatement ps2=con.prepareStatement("update bookdetails set bookquantity=bookQuantity+1 where bookid=?");
					ps2.setInt(1, bookid);
					status=ps2.executeUpdate();
					if(status>0)
					return "success";
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return "failure";
	}
	private static Integer calculateFine(java.sql.Date issuedDate,java.sql.Date returnDate)
	{
		;
		long diff =issuedDate.getTime()-returnDate.getTime();
		Integer days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if(days>15) {
		   fine=(days-15)*10;
		   return fine;
		}else
		return 0;
		
	}

	@Override
	public String registerStudent(Student student) {
		String myQuery="insert into student(student_id,student_name,student_branch,student_mobile,borrowbooks) values(?,?,?,?,?)";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setInt(1, student.getSid());
				pst.setString(2, student.getSname());
				pst.setString(3,student.getSbranch());
				pst.setLong(4,student.getMobile());
				pst.setInt(5, 0);
				System.out.println("The vales are set");
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";	}
	

}
