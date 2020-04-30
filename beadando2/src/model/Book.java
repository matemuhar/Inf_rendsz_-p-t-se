
package model;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({@NamedQuery(name="Book.getAll", query="Select e from Book e")})
public class Book {
    @Id
    @Column
    private String bookID;
    @Column
    private String writer;
    @Column
    private String title;
    @Column
    private String state;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    
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
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Book(String bookID, String writer, String title, String state) {
        this.bookID = bookID;
        this.writer = writer;
        this.title = title;
        this.state = state;
    }
    public Book(){}
}
