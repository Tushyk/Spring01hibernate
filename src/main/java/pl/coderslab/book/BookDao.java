package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Book> findAll(){
        return entityManager
                .createQuery("select b from Book b", Book.class)
                .getResultList();
    }
    public List<Book> findAllByRating(int rating){
        return entityManager
                .createQuery("select b from Book b where b.rating=:rat")
                .setParameter("rat", rating)
                .getResultList();
    }
    public List<Book> findAllWithPublishers(){
        return entityManager
                .createQuery("select b from Book b join b.publisher")
                .getResultList();
    }
    public List<Book> findAllByPublisher(Publisher publisher){
        return entityManager
                .createQuery("select b from Book b where b.publisher=:pub")
                .setParameter("pub", publisher)
                .getResultList();
    }
    public List<Book> findAllByAuthor(Author author){
        return entityManager
                .createQuery("select distinct b from Book b join FETCH b.authors where :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }


    public void saveBook(Book book) {
        entityManager.persist(book);
    }
    public Book findById (long id) {
        return entityManager.find(Book.class, id);
    }
    public void update (Book book) {
        entityManager.merge(book);
    }
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book)); }
}
