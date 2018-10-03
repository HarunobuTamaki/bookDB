package test;

import java.util.List;

import model.Book;
import model.SearchBookLogic;

public class TitleSearchTest {

	public static void main(String[] args){
		titleSearchTest1();	//検索結果にヒットした場合
		titleSearchTest2(); //検索結果にヒットしなかった場合
	}

	//検索結果にヒットした場合
	public static void titleSearchTest1(){
		SearchBookLogic bo = new SearchBookLogic();
		List<Book> tSearch = bo.SearchTitle("北斗");
		if(tSearch != null){
			System.out.println("titleSearchTest1:成功しました");
		}else{
			System.out.println("titleSearchTest1:失敗しました");
		}
	}

	//検索結果にヒットしなかった場合
	public static void titleSearchTest2(){
		SearchBookLogic bo = new SearchBookLogic();
		List<Book> tSearch = bo.SearchTitle("シャンプー");
		if(tSearch == null){
			System.out.println("titleSearchTest2:成功しました");
		}else{
			System.out.println("titleSearchTest2:失敗しました");
			for(Book sBook:tSearch){
				System.out.println(sBook.getId());
				System.out.println(sBook.getCategory());
				System.out.println(sBook.getTitle());
				System.out.println(sBook.getPrice());
				System.out.println(sBook.getUpdated());
			}
		}
	}


}
