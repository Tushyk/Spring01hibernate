package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }
    @GetMapping("/validate")
    public String test(Model model) {
        Book book = new Book();
        book.setTitle("22");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        constraintViolations.forEach(
                cv -> System.out.println(cv.getPropertyPath() + " : " + cv.getMessage())
        );
        model.addAttribute("errors", constraintViolations);
        return "validate/errors";
    }
}
