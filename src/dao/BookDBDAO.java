package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDBDAO {

	//フィールド変数
	private final String DRIVER_NAME ="org.h2.Driver";
	private final String DB_ADDRESS ="jdbc:h2:file:C:/180416AM/data/BookDB";
	private final String USER_ID ="sa";
	private final String USER_PASS ="";

	//SELECT文(全クエリ)実行メソッド
	public List<Book> findAll(){
		Connection conn = null;
		List<Book> bookList = new ArrayList<Book>();

		try{
			//JDBCドライバ読み込み
			Class.forName(DRIVER_NAME);

			//データベースに接続
			conn = DriverManager.getConnection(DB_ADDRESS,USER_ID,USER_PASS);

			//SELECT文を準備
			String sql = "SELECT ID,CATEGORY,TITLE,PRICE,UPDATED FROM BOOKS";
			PreparedStatement pStmt  =conn.prepareStatement(sql);

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表をList<Book>インスタンスに代入
			while(rs.next()){
				int id = rs.getInt("ID");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				int price = rs.getInt("PRICE");
				String updated = rs.getString("UPDATED");

				Book book = new Book(id,category,title,price,updated);
				bookList.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(conn!=null){
					//データベースを閉じる
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}

		return bookList;
	}

	//INSERT文実行メソッド
	public boolean create(Book book){
		Connection conn  = null;
		try{
			//データベースへ接続
			conn = DriverManager.getConnection(DB_ADDRESS,USER_ID,USER_PASS);

			//INSERT文を準備
			String sql = "INSERT INTO BOOKS(CATEGORY,TITLE,PRICE,UPDATED) VALUES (?,?,?,?)";
			PreparedStatement pStmt  =conn.prepareStatement(sql);
			//INSERT文の準備(idは自動連番なので設定しなくてよい)
			pStmt.setString(1, book.getCategory());
			pStmt.setString(2, book.getTitle());
			pStmt.setInt(3, book.getPrice());
			pStmt.setString(4, book.getUpdated());

			//INSERT文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			try{
				if(conn != null){
					//データベース切断
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return true;
	}

	//DELETE文実行メソッド(IDで検索)
	public boolean delete(int id){
		Connection conn = null;
		try{
			//データベースに接続
			conn = DriverManager.getConnection(DB_ADDRESS,USER_ID,USER_PASS);

			//DELETE文を準備
			String sql = "DELETE FROM BOOKS WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,id);

			//DELETE文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			try{
				if(conn != null){
					//データベース切断
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return true;
	}

	//タイトル検索メソッド
	public  List<Book> findLine(String bookTitle){
		Connection conn = null;
		List<Book> bookList = new ArrayList<Book>();

		try{
			//JDBCドライバ読み込み
			Class.forName(DRIVER_NAME);

			//データベースに接続
			conn = DriverManager.getConnection(DB_ADDRESS,USER_ID,USER_PASS);
			//SELECT文を準備
			String sql="SELECT * FROM BOOKS WHERE TITLE LIKE STRINGDECODE(?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+bookTitle+"%");
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//結果表をList<Book>インスタンスに代入
			while(rs.next()){
				int id = rs.getInt("ID");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				int price = rs.getInt("PRICE");
				String updated = rs.getString("UPDATED");

				Book book = new Book(id,category,title,price,updated);
				bookList.add(book);
			}
			for(Book addBook:bookList){
				System.out.println(addBook.getId());
				System.out.println(addBook.getCategory());
				System.out.println(addBook.getTitle());
				System.out.println(addBook.getPrice());
				System.out.println(addBook.getUpdated());
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				//データベース切断
				if(conn != null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return  bookList;
	}

	//ソート表示メソッド
	public List<Book> genreSort (String genre){
		Connection conn = null;
		List<Book> sortList = new ArrayList<Book>();

		try{
			//JDBCドライバ読み込み
			Class.forName(DRIVER_NAME);

			//データベースに接続
			conn = DriverManager.getConnection(DB_ADDRESS,USER_ID,USER_PASS);
			//SELECT文の準備
			String sql ="SELECT * FROM BOOKS WHERE CATEGORY IN (STRINGDECODE(?))";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, genre);
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("ID");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				int price = rs.getInt("PRICE");
				String updated = rs.getString("UPDATED");

				Book book = new Book(id,category,title,price,updated);
				sortList.add(book);
				System.out.println(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				//データベース切断
				if(conn != null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return  sortList;
	}

}
