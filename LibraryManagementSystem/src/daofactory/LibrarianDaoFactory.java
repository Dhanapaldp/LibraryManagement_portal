package daofactory;

import daoLayer.ILibrarianDao;
import daoLayer.LibrarianDaoImpl;

public class LibrarianDaoFactory {
	
	static ILibrarianDao librarianDao=null;
	private LibrarianDaoFactory()
	{
		
	}
	public static ILibrarianDao getLibrarianDao()
	{
		librarianDao=new LibrarianDaoImpl();
		return librarianDao;
		
	}

}
