package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.EventService;
import pl.sda.eventmanager.mymanager.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan("pl.sda.eventmanager.mymanager")
public class EventController /*implements ApplicationRunner*/ {

    private final UserRepository userRepository;
    private  final UserService userService;
    private EventService eventService;

    @Autowired
    public EventController(UserRepository userRepository, UserService userService, EventService eventService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.eventService = eventService;
    }

    /*@GetMapping("/index")
    ModelAndView getIndex() {
        return new ModelAndView("index");
    }*/

    @GetMapping("/eventDetails")
    ModelAndView getEventDetails() {
        return new ModelAndView("eventDetails");
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

    @GetMapping("/adminPage")
    ModelAndView getAdminPage() {
        return new ModelAndView("adminPage");
    }

    @GetMapping("index")
    public ModelAndView getEvents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("events", eventService.getEvents());
        return modelAndView;
    }

    @GetMapping("/youAreLoggedOut")
    ModelAndView getYouAreLoggedOut() {
        return new ModelAndView("youAreLoggedOut");
    }

}
