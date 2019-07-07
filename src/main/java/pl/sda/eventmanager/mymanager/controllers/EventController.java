package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan("pl.sda.eventmanager.mymanager")
public class EventController /*implements ApplicationRunner*/ {

    private final UserRepository userRepository;
    private  final UserService userService;

    @Autowired
    public EventController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/index")
    ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @GetMapping("/delete")
    ModelAndView getDelete() {
        return new ModelAndView("delete");
    }

    @GetMapping("/newUser")
    ModelAndView getNewUser() {
        return new ModelAndView("newUser");
    }

    @GetMapping("/password")
    ModelAndView getPasswor() {
        return new ModelAndView("password");
    }

    @GetMapping("/settings")
    ModelAndView getSettings() {
        return new ModelAndView("settings");
    }

    @GetMapping("/youAreLoggedIn")
    ModelAndView getYouAreLoggedIn() {
        return new ModelAndView("youAreLoggedIn");
    }

    @GetMapping("/youAreLoggedOut")
    ModelAndView getYouAreLoggedOut() {
        return new ModelAndView("youAreLoggedOut");
    }

    /*@GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }*/

    /*@PostMapping("/loginVerify")
    public String loginSubmit(@ModelAttribute User user) {
        return "youAreLoggedIn";
    }*/

//    @Autowired
//    public Controller(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

   /* @Override
    public void run(ApplicationArguments args) throws Exception {

    }*/
}
