package model.ejb;

import java.awt.print.Book;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




/**
 * Session Bean implementation class ClientDAO
 */
@Stateless
@LocalBean
public class BookDAO {

    @PersistenceContext private EntityManager em;
    
    public void addBook(Book book) {
        em.persist(book);
    }
    public void editBook(Book book){
        em.merge(book);
    }
    public void deleteBook(String id){
    	Book book = em.find(Book.class, id);
        em.remove(book);
    }
    public Book getBook(String id){
        return em.find(Book.class, id);
    }
    public List getAllBooks(){
        return em.createNamedQuery("Book.getAll").getResultList();
    }
}
