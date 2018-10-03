package model;

import java.io.Serializable;

public class Book implements Serializable{

	private int id;	//id
	private String category;	//分類
	private String title; //名前
	private int price; //値段
	private String updated; //更新日

	public Book(){}

	public Book(int id,String category,String title,int price,String updated){
		this.id = id;
		this.category = category;
		this.title= title;
		this.price = price;
		this.updated = updated;
	}

	public Book(String category,String title,int price,String updated){
		this.category = category;
		this.title= title;
		this.price = price;
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public String getUpdated() {
		return updated;
	}

}
