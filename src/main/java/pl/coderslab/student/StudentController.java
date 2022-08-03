package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.person.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @ModelAttribute("countryItems")
    public List<String> country() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("gaming", "music", "cars", "football", "sport");
    }
    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("java", "php", "js", "python", "c++");
    }
    @GetMapping("/add")
    public String add(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/add";
    }
    @PostMapping("/add")
    public String save(Student student, Model model){
        model.addAttribute("student", student);
        return "student/success";
    }

}
