package model;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Book.getAll", query = "Select e from Book e") })
public class Book {
	@Id
	@Column
	private String bookID;
	@Column
	private String writer;
	@Column
	private String title;
	@Column
	private String status;

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public Book(String bookID, String writer, String title, String status) {
		this.bookID = bookID;
		this.writer = writer;
		this.title = title;
		this.status = status;
	}

	public Book() {
	}
}