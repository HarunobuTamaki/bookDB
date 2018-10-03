package test;

import model.GetDateLogic;

public class GetDateTest {

	public static void main(String[] args){
		GetDateLogic bo = new GetDateLogic();
		String today = bo.execute();
		System.out.println(today);
	}
}
