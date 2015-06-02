package tr.gov.tuik.spring.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }
}
