package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.dto.LoginForm;
import pl.sda.eventmanager.mymanager.repository.EventRepository;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.EventService;
import pl.sda.eventmanager.mymanager.service.UserService;

import java.util.Arrays;

@Controller
//@ComponentScan("pl.sda.eventmanager.mymanager")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;
    private EventService eventService;
    private EventRepository eventRepository;

    @Autowired
    public UserController(UserRepository userRepository
                        , UserService userService
                        , EventService eventService
                        , EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    /*@GetMapping("/")
    ModelAndView getHome() {
        return new ModelAndView("index");
    }*/

    @GetMapping("login")
    public ModelAndView loginInForm(){
        return new ModelAndView("login", "loginForm", new LoginForm());
    }

    @GetMapping("youAreLoggedIn")
    public ModelAndView logForm(/*Authentication authentication*/){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("youAreLoggedIn"/*, "loginForm", new LoginForm()*/);
        modelAndView.addObject(authentication.getPrincipal());
        // ta linijka nic nie robi oprocz wyswietlania informacji o widoku "login"
        System.out.println(loginInForm().addObject(modelAndView));

        return modelAndView;
    }

    @PostMapping("validation")
    public String postSubitForm(@ModelAttribute LoginForm loginForm) {
        loginForm.setEmail(userService.readLoginFormEmail(loginForm));
        return "youAreLoggedIn";
    }
}
