package model;

import java.util.List;

import dao.BookDBDAO;

public class SearchBookLogic {
	BookDBDAO dao = new BookDBDAO();
	List<Book> bookList= dao.findAll();

	//idから本を探すメソッド(id(自動振り当て)なので戻り値はBookインスタンス)
	public Book execute(int id){
		Book getBook = null;;
		for(Book book:bookList){
			if(id == book.getId()){
				getBook = book;
			}
		}
		return getBook;
	}

	//タイトル検索メソッド
	public List<Book> SearchTitle(String title){
		List<Book> sTitle= dao.findLine(title);
		if(sTitle == null){
			System.out.println("sTitleはnullです。");
		}
		for(Book addBook:sTitle){
			System.out.println(addBook.getId());
			System.out.println(addBook.getCategory());
			System.out.println(addBook.getTitle());
			System.out.println(addBook.getPrice());
			System.out.println(addBook.getUpdated());
		}
		return sTitle;
	}
}
