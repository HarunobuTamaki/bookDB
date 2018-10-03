package model;

import java.util.List;

import dao.BookDBDAO;

public class SortGenreLogic {

	public List<Book> execute(String genre){
		BookDBDAO dao = new BookDBDAO();
		List<Book> sortList = dao.genreSort(genre);
		return sortList;
	}

}
