package service;

import java.util.List;

import daoLayer.IBookDao;
import daofactory.BookDaoFactory;
import dataTransferObjects.Book;
import dataTransferObjects.IssueBookBean;
import dataTransferObjects.Student;

public class BookServiceImpl implements IBookService {

	IBookDao bookDao=null;
	@Override
	public String addBook(Book book) {
		bookDao=BookDaoFactory.getBookDao();
		
		return bookDao.addBook(book);
	}

	@Override
	public Book searchBook(Integer id) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.searchBook(id);
	}

	@Override
	public String updateBook(Book book) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.updateBook(book);
	}

	@Override
	public String deleteBook(Integer id) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.deleteBook(id);
	}

	@Override
	public List<Book> viewBooks() {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.viewBooks();
	}

	@Override
	public List<IssueBookBean> viewBookUsers() {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.viewBookUsers();
	}

	@Override
	public String issueBook(IssueBookBean bean) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.issueBook(bean);
	}

	@Override
	public String returnBook(Integer bookid, int sid) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.returnBook(bookid, sid);
	}
	@Override
	public String registerStudent(Student student) {
		bookDao=BookDaoFactory.getBookDao();
		return bookDao.registerStudent(student);
	}

}
