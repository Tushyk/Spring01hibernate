package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findFirstByEmail(String email);
    Author findFirstByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);
}
