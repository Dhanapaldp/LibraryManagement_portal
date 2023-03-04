package daofactory;

import daoLayer.BookDaoImpl;
import daoLayer.IBookDao;

public class BookDaoFactory {

	static IBookDao bookDao=null;
	private BookDaoFactory()
	{
		
	}
	public static IBookDao getBookDao()
	{
		bookDao=new BookDaoImpl();
		return bookDao;
		
	}
}
