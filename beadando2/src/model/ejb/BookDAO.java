package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import model.Book;

/**
 * Session Bean implementation class BookDAO
 */
@Stateless
@LocalBean
public class BookDAO {
	
	@Resource(name="jdbc/bookDB")
	private DataSource ds;
	
	public void addBook(Book book) {
		String sql = "INSERT INTO BOOK VALUES('"+ book.getBookID() +"', '"+ book.getWriter() +"', '"+ book.getTitle() +"', '"+ book.getState() + "')";
		executeModifyQuery(sql);
	}
	
	public void editBook(Book book) {
		String sql = "UPDATE BOOK SET WRITER='"+ book.getWriter() +"', TITLE= '"+ book.getTitle() +"', STATE= '"+ book.getState() +"' WHERE BOOKID='"+ book.getBookID();
		executeModifyQuery(sql);
	}
	
	public void deleteBook(Book book) {
		String sql = "DELETE FROM BOOK WHERE BOOKID='"+ book.getBookID() +"'";
		executeModifyQuery(sql);
	}
	
	public Book getBook(String id) {
		Book book = new Book();
		String sql = "SELECT * FROM BOOK WHERE BOOKID='"+ id +"'";
		System.out.println(sql);
		ResultSet rs = executeFetchQuery(sql);
		try {
			if (rs.next()) {
				book.setBookID(rs.getString("BOOKID"));
				book.setWriter(rs.getString("WRITER"));
				book.setTitle(rs.getString("TITLE"));
				book.setState(rs.getString("STATE"));
			}			
		} catch (SQLException ex) {
			System.err.println("GS" + ex.getMessage());
		}
		return book;
	}
	
	public ArrayList<Book> getAllBook() {
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM BOOK";
		ResultSet rs = executeFetchQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setBookID(rs.getString("BOOKID"));
				book.setWriter(rs.getString("WRITER"));
				book.setTitle(rs.getString("TITLE"));
				book.setState(rs.getString("STATE"));
				list.add(book);
			}			
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return list;
	}
	
	public void executeModifyQuery(String sql) {
		try {
			Connection conn = ds.getConnection();
			conn.createStatement().execute(sql);
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ResultSet executeFetchQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = ds.getConnection();
			rs = conn.createStatement().executeQuery(sql);
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
