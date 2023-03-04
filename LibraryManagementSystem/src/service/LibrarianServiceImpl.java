package service;

import daoLayer.ILibrarianDao;
import daoLayer.LibrarianDaoImpl;
import daofactory.LibrarianDaoFactory;
import dataTransferObjects.Librarian;


public class LibrarianServiceImpl implements ILibrarianService {

	ILibrarianDao librarianDao=null;
	@Override
	public String addLibrarian(Librarian librarian) {
		librarianDao = LibrarianDaoFactory.getLibrarianDao();
		return librarianDao.addLibrarian(librarian);
	}

	@Override
	public Librarian searchLibrarian(Integer id){
		librarianDao = LibrarianDaoFactory.getLibrarianDao();
		return librarianDao.searchLibrarian(id);
	}

	@Override
	public String updateLibrarian(Librarian librarian) {
		librarianDao = LibrarianDaoFactory.getLibrarianDao();
		return librarianDao.updateLibrarian(librarian);
	}

	@Override
	public String deleteLibrarian(Integer id) {
		librarianDao = LibrarianDaoFactory.getLibrarianDao();
		return librarianDao.deleteLibrarian(id);
	}

	
	public  static boolean authenticate(Integer lid, String password) {
		ILibrarianDao librarianDao = LibrarianDaoFactory.getLibrarianDao();
		return librarianDao.authenticate(lid, password);
	}

}
