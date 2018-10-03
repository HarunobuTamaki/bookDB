package model;

import dao.BookDBDAO;

public class DeleteBookLogic {

	public void execute(int id){
		BookDBDAO dao = new BookDBDAO();
		dao.delete(id);
	}

}
