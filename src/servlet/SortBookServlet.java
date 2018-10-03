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
import model.SortGenreLogic;

@WebServlet("/SortBookServlet")
public class SortBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/sortGenre.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String genre = request.getParameter("genre");

		//表示するジャンルの本の情報を設定
		SortGenreLogic sortGenreLogic = new SortGenreLogic();
		List<Book> sortList = sortGenreLogic.execute(genre);

		//リクエストスコープに保存
		request.setAttribute("sortList",sortList );

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/sortGenreResult.jsp");

		dispatcher.forward(request,response);

	}

}
