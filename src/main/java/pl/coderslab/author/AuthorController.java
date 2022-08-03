package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/author-form")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;

    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }
    @PostMapping("/add")
    public String save(@Valid Author author, BindingResult result) {
        if (result.hasErrors()){
            return "author/add";
        }
        authorDao.saveAuthor(author);
        return "redirect:/author-form/list";
    }
    @GetMapping("/confirm-delete/{id}")
    public String confirm(Model model, @PathVariable int id) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/author-form/list";
    }
    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable int id) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/edit";
    }
    @PostMapping("/update-author")
    public String update(@Valid Author author, BindingResult result) {
        if (result.hasErrors()){
            return "author/edit";
        }
        authorDao.update(author);
        return "redirect:/author-form/list";
    }
}
