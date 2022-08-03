package pl.coderslab.category;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.publisher.Publisher;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
