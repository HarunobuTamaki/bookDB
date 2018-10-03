package model;

import dao.BookDBDAO;

//CreateBookLogicクラス
//BookDBDAOインスタンスのcreateメソッドを呼び出す(分かりやすくする)
public class CreateBookLogic {

	public void execute(Book book){
		BookDBDAO bookdao = new BookDBDAO();
		bookdao.create(book);
	}
}
