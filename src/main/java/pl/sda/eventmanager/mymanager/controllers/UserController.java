package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.model.LoginForm;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.UserService;

import java.util.logging.Logger;

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

//    @PostMapping("/addContact")
//    public String addContactSubmit(@ModelAttribute Contact contact) {
//        Contact newContact = contactService.addContact(contact);
//        return "result";
//    }
//
//    @GetMapping("/addContact")
//    String addContactGet(@ModelAttribute Contact contact){
//        return "addContact";
//    }

//    @GetMapping("/login")
//    String loginIn(@ModelAttribute User user) {
//        return "login";
//    }

    @GetMapping("login")
    public ModelAndView loginIn(){
        return new ModelAndView("login", "user", new User());
    }

//    @PostMapping("login")
//    public ModelAndView loginSubmit(){
//        return new ModelAndView("youAreLoggedIn");
//    }

//    @PostMapping("/login")
//    public String loginSubmit(@ModelAttribute User user){
//        return "youAreLoggedIn";
//    }

//    @GetMapping("newUser")
//    public ModelAndView getNewUser() {
//        return new ModelAndView("newUser", "user", new User());
//    }
//
    @PostMapping("login")
    public String postRegister(@ModelAttribute User user) {
//        userRepository.findByNick(user.getNick());
        System.out.println(userService.readUserEmail(user));
//            userRepository.readUserByNickAndPassword(user.getNick(), user.getPassword());
//        userService.readUserEmail(user.getNick());
//        userService.saveNewUser(user.getNick(), user.getEmail(), user.getPassword());
        return "youAreLoggedIn";
    }
}
