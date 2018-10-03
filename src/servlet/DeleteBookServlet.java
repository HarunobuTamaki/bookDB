package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.DeleteBookLogic;
import model.GetBookListLogic;
import model.SearchBookLogic;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Bookテーブルを取得して、リクエストスコープに保存
		GetBookListLogic getBookListLogic = new GetBookListLogic();
		List<Book> bookList = getBookListLogic.execute();
		request.setAttribute("bookList", bookList);

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決める「action」の値を
		//リクエストパラメーターから取得

		String action = request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		if(action == null){
			forwardPath = "/WEB-INF/jsp/delete.jsp";
		}
		//削除確認画面から「削除」をリクエストされたときの処理
		else if(action.equals("done")){
			//セッションスコープに保存された登録ユーザーの取得
			HttpSession session = request.getSession();

			Book deleteBook = (Book)session.getAttribute("deleteBook");

			//削除処理の呼び出し
			DeleteBookLogic logic = new DeleteBookLogic();
			logic.execute(deleteBook.getId());

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerBook");

			//削除後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/deleteBookDone.jsp";
		}

		//設定されたフォワード先にフォワードする
		RequestDispatcher dispatcher  =
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("BookTitle"));

		//削除する本の情報を設定
		SearchBookLogic searchBookLogic= new SearchBookLogic();
		Book deleteBook =searchBookLogic.execute(id);

		//セッションスコープに登録した本を保存
		HttpSession session = request.getSession();
		session.setAttribute("deleteBook", deleteBook);

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/deleteBookConfirm.jsp");
		dispatcher.forward(request, response);

	}

}
