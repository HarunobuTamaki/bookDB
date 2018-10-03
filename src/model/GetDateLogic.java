package model;

import java.text.SimpleDateFormat;
import java.util.Date;

//日付取得クラス
public class GetDateLogic {

	public String execute(){

		Date date = new Date();	//今日の日付

		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd"); //日付のフォーマット

		String today = day.format(date); //フォーマットに日付を代入

		return today;
	}

}
