package pl.coderslab.author;

import org.springframework.stereotype.Repository;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Author> findAll(){
        return entityManager
                .createQuery("select a from Author a")
                .getResultList();
    }
    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
    public void update(Author author) {
        entityManager.merge(author);
    }
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author)); }
}
