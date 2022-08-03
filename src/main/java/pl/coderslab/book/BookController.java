package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;


    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }
    @RequestMapping("/book/add")
    @ResponseBody
    public String save() {
        Book book = new Book();
        Publisher publisher = publisherDao.findById(2);
        Author author = authorDao.findById(2);
        Author author1 = authorDao.findById(3);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        book.setTitle("Thinking in Java");
        book.setDescription("o javie");
        book.setRating(10);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookDao.saveBook(book);
        return "Id dodanej ksiazki to:"
                + book.getId();
    }
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }
    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        bookRepository.findAllByTitle("Java")
                .forEach(b -> System.out.println(b.getId()));
        System.out.println("-------");
        bookRepository.findAllByCategory(categoryRepository.getOne(1l))
                .forEach(b -> System.out.println(b.getId()));

        System.out.println("-------");
        bookRepository.findAllByCategoryId(2l)
                .forEach(b -> System.out.println(b.getId()));
        return "ok";
    }
}
