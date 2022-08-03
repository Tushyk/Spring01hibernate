package pl.coderslab.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisher-form")
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }
    @PostMapping("/add")
    public String save(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()){
            return "publisher/add";
        }
        publisherDao.savePublisher(publisher);
        return "redirect:/publisher-form/list";
    }
    @GetMapping("/confirm-delete/{id}")
    public String confirm(Model model, @PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisher/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/publisher-form/list";
    }
    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisher/edit";
    }
    @PostMapping("/update-publisher")
    public String update(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()){
            return "publisher/edit";
        }
        publisherDao.update(publisher);
        return "redirect:/publisher-form/list";
    }
}
