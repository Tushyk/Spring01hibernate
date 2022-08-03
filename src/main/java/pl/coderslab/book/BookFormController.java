package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.publisher.PublisherDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final PublisherDao publisherDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao, CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String save(Model model, @Valid Book book, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("publishers", publisherDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            model.addAttribute("categories",categoryRepository.findAll());
            return "book/add";
        }
        bookRepository.save(book);
        return "redirect:/book-form/list";
    }
    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable int id) {
        Book book1 = new Book();
        Book book = bookDao.findById(id);
        book1.setTitle(book.getTitle());
        book1.setDescription(book.getDescription());
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("book", book);
        return "book/edit";
    }
    @PostMapping("/updateBook")
    public String update(@Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            return "book/edit";
        }
        bookDao.update(book);
        return "redirect:/book-form/list";
    }
    @GetMapping("/confirm-delete/{id}")
    public String confirm(Model model, @PathVariable int id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "book/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:/book-form/list";
    }



}
