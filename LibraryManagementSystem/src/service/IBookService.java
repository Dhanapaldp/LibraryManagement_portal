package service;

import java.util.List;

import dataTransferObjects.Book;
import dataTransferObjects.IssueBookBean;
import dataTransferObjects.Student;


public interface IBookService {
	
	public String addBook(Book book);
	public Book searchBook(Integer id);
	public String updateBook(Book book);
	public String deleteBook(Integer id);
	public List<Book> viewBooks();
	public List<IssueBookBean> viewBookUsers();
	public String issueBook(IssueBookBean bean);
	public String returnBook(Integer bookid,int sid);
	public String registerStudent(Student student);
}
