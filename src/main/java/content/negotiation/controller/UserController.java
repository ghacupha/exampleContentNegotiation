package content.negotiation.controller;

import content.negotiation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView userDetails(){
        ModelAndView modelAndView = new ModelAndView();

        List userDetails = userService.getUserDetails();

        modelAndView.addObject("users",userDetails);

        modelAndView.setViewName("userDetails");

        return modelAndView;
    }
}
