package model;

import java.util.List;

import dao.BookDBDAO;

public class GetBookListLogic {

	public List<Book> execute(){
		BookDBDAO dao = new BookDBDAO();
		List<Book> bookList = dao.findAll();
		return bookList;
	}
}
