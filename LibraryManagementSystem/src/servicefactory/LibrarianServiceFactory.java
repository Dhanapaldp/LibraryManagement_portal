package servicefactory;


import service.ILibrarianService;
import service.LibrarianServiceImpl;

public class LibrarianServiceFactory {
	
	static ILibrarianService librarianService=null;
	//Make constructor private o avoid object creation(Singleton)
	private LibrarianServiceFactory()
	{
		
	}
	public static ILibrarianService getLibrarianService()
	{
		librarianService=new LibrarianServiceImpl();
		return librarianService;
		
	}
	

}

