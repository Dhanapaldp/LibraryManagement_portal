package servicefactory;


import service.BookServiceImpl;
import service.IBookService;

public class BookServiceFactory {

	static IBookService bookService=null;
	private BookServiceFactory()
	{
		
	}
	public static IBookService getBookService()
	{
		bookService=new BookServiceImpl();
		return bookService;
		
	}
}
