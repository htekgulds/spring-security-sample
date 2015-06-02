package tr.gov.tuik.spring.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Controller
public class UsersController {
    
    private final UserService userService;
    
    @Inject
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }
}
