package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.SearchBookLogic;

@WebServlet("/SearchTitleServlet")
public class SearchTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("search");
		String errorMsg = "";

		//検索ロジックを実行する
		SearchBookLogic searchBookLogic = new SearchBookLogic();
		List<Book> sTitle = searchBookLogic.SearchTitle(title);

		//検索文字が0文字の場合
		if(title == null || title.length() == 0){
			errorMsg = "文字を入力してください。";
		}

		//検索結果がなかった場合
		if(sTitle == null || sTitle.isEmpty()){
			errorMsg = "検索結果は見つかりませんでした。";
		}

		//リクエストスコープに保存
		//検索にかかった本
		request.setAttribute("sTitle", sTitle);
		//検索した文字
		request.setAttribute("title",title );
		//エラーメッセージ
		request.setAttribute("errorMsg",errorMsg);

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/searchTitleResult.jsp");
		dispatcher.forward(request, response);
	}

}
