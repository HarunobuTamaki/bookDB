package test;

import model.DeleteBookLogic;

public class DeleteBookTest {

	public static void main(String[] args){
		int id = 14;

		DeleteBookLogic dBook = new DeleteBookLogic();
		dBook.execute(id);

		System.out.println("実行しました。");
	}
}
