package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.dto.LoginForm;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.UserService;

@Controller
@ComponentScan("pl.sda.eventmanager.mymanager")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

//    @GetMapping("login")
//    public ModelAndView loginIn(){
//        return new ModelAndView("login", "user", new User());
//    }

    @GetMapping("login")
    public ModelAndView loginInForm(){
        return new ModelAndView("login", "loginForm", new LoginForm());
    }

    @GetMapping("youAreLoggedIn")
    public ModelAndView logForm(Authentication authentication){

        System.out.println("getAuthorities: " + authentication.getAuthorities());
        System.out.println("getPrincipal: " + authentication.getPrincipal());
        System.out.println("getDetails: " + authentication.getDetails());
        System.out.println("isAuthenticated: " + authentication.isAuthenticated());

        ModelAndView modelAndView = new ModelAndView("youAreLoggedIn"/*, "loginForm", new LoginForm()*/);
//        modelAndView.addObject("nick", Arrays.asList(authentication.getPrincipal()));
        return modelAndView;
    }

//    @PostMapping("login")
//    public String postSubmit(@ModelAttribute User user) {
//        user.setEmail(userService.readUserEmail(user));
//        return "youAreLoggedIn";
//    }

    @PostMapping("validation")
    public String postSubitForm(@ModelAttribute LoginForm loginForm) {
        loginForm.setEmail(userService.readLoginFormEmail(loginForm));
        return "youAreLoggedIn";
    }
}
