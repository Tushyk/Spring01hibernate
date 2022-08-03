package pl.coderslab.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findFirstByNip(String nip);
    Publisher findFirstByRegon(String regon);
    Publisher findFirstByName(String name);
}
