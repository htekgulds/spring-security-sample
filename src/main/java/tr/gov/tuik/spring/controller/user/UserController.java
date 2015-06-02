package tr.gov.tuik.spring.controller.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.domain.UserCreateForm;
import tr.gov.tuik.spring.service.UserService;
import tr.gov.tuik.spring.validator.UserCreateFormValidator;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Controller
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Inject
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        return new ModelAndView("user", "user", userService.getUSerById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user_create";
        }
        try {
            userService.create(form);
        }
        catch (DataIntegrityViolationException e) {
            result.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/users";
    }
}
