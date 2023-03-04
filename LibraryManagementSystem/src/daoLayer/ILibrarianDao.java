package daoLayer;

import dataTransferObjects.Librarian;

public interface ILibrarianDao {
	
	public String addLibrarian(Librarian librarian);
	public Librarian searchLibrarian(Integer id);
	public String updateLibrarian(Librarian librarian);
	public String deleteLibrarian(Integer id);
	public boolean authenticate(Integer lid,String password);

}
