package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long id);
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(int rating);
    Book findFirstByCategoryOrderByTitle(Category category);
    List<Book> findAllByAuthorsContainsIgnoreCase(Author author);
}
