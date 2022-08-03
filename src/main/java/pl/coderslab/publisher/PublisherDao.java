package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Publisher> findAll(){
        return entityManager
                .createQuery("select p from Publisher p")
                .getResultList();
    }
    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher)); }

}
