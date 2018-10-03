package test;

import java.util.List;

import model.Book;
import model.GetBookListLogic;

public class BookViewTest {

	public static void main(String[] args){

		GetBookListLogic bo = new GetBookListLogic();
		List<Book> bookList = bo.execute();

		for(Book book:bookList){
			System.out.println("ID:"+book.getId());
			System.out.println("分類:"+book.getCategory());
			System.out.println("名前:"+book.getTitle());
			System.out.println("値段:"+book.getPrice());
			System.out.println("更新日:"+book.getUpdated()+"\n");
		}
	}

}
