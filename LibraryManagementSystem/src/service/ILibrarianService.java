package service;

import dataTransferObjects.Librarian;

public interface ILibrarianService {
	
	public String addLibrarian(Librarian librarian);
	public Librarian searchLibrarian(Integer id);
	public String updateLibrarian(Librarian librarian);
	public String deleteLibrarian(Integer id);


}
