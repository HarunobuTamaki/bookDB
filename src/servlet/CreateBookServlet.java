package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.CreateBookLogic;
import model.GetDateLogic;


@WebServlet("/CreateBookServlet")
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメーターから取得

		String action=request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		if(action == null){
			//フォワード先を設定
			forwardPath ="/WEB-INF/jsp/create.jsp";
		}
		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("done")){
			System.out.println("action=done");
			//セッションスコープに保存された登録ユーザーの取得
			HttpSession session = request.getSession();

			Book registerBook = (Book)session.getAttribute("registerBook");

			//登録処理の呼び出し
			CreateBookLogic logic = new CreateBookLogic();
			logic.execute(registerBook);

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerBook");

			//登録後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/createBookDone.jsp";
		}

		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワードパス
		String forward = "/WEB-INF/jsp/createBookConfirm.jsp";

		GetDateLogic logic = new GetDateLogic();

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String sPrice = request.getParameter("price");

		//エラーメッセージを用意
		String errorMsg="";

		//日付を取得
		String updated = logic.execute();
		String lineCd = System.getProperty("line.separator");

		//分類が入力されていない場合
		if(category == null || category.length()==0){
			errorMsg += "分類が入力されていません"+lineCd;
		}

		//名前が入力されていない場合
		if(title == null || title.length()==0){
			errorMsg += "名前が入力されていません"+lineCd;
		}

		//読み取った値段の文字列を整数型に変える
		int price = 0;
		//正規表現のパターンを作り、文字列の中の文字と数値を判別する。
		//パターンに0から9の数値を指定
		String regex = "^-?[0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		//入力した値段の文字列とパターンの比較
		Matcher matcher = pattern.matcher(sPrice);

		//文字列が数字&入力した文字列が空じゃない場合
		if(matcher.find() && sPrice.length()!=0){
			price = Integer.parseInt(sPrice);
			//なおかつ、値段が0の場合
			if(price == 0){
				errorMsg += "値段を正しく入力してください";
			}
		}else {
			errorMsg += "値段を正しく入力してください";
		}

		//登録する本の情報を設定
		Book registerBook = new Book(category,title,price,updated);

		//セッションスコープに登録した本を保存
		HttpSession session =request.getSession();
		session.setAttribute("registerBook",registerBook);

		//エラーメッセージをリクエストスコープに保存
		request.setAttribute("errorMsg", errorMsg);

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

}
