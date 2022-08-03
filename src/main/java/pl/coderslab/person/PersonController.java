package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDetailsDao personDetailsDao;
    private final PersonDao personDao;

    public PersonController(PersonDetailsDao personDetailsDao, PersonDao personDao) {
        this.personDetailsDao = personDetailsDao;
        this.personDao = personDao;
    }
    @GetMapping("/add")
    public String add(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/add";
    }
    @PostMapping("/add")
    @ResponseBody
    public String save(Person person) {
        personDao.savePerson(person);
        return "ok";
    }

    //    @PostMapping("/add")
//    @ResponseBody
//    public String save(@RequestParam String login,
//                       @RequestParam String password,
//                       @RequestParam String email) {
//        personDao.save(Person.builder()
//                .login(login)
//                .password(password)
//                .email(email)
//                .build());
//        return "ok";
//    }
    @RequestMapping("/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }
    @RequestMapping("/person/update/{id}/{login}/{password}/{email}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login, @PathVariable String password,
                             @PathVariable String email) {
        Person person = personDao.findById(id);
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.update(person);
        return person.toString();
    }
    @RequestMapping("/person/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "deleted";
    }
}
