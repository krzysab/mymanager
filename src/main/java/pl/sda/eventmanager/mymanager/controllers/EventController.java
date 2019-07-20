package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eventmanager.mymanager.entity.Event;
import pl.sda.eventmanager.mymanager.repository.EventRepository;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.EventService;
import pl.sda.eventmanager.mymanager.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
//@ComponentScan("pl.sda.eventmanager.mymanager")
public class EventController /*implements ApplicationRunner*/ {

    private UserRepository userRepository;
    private UserService userService;
    private EventService eventService;
    private EventRepository eventRepository;

    @Autowired
    public EventController(UserRepository userRepository
                        , UserService userService
                        , EventService eventService
                        , EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

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

    @GetMapping("/")
    public ModelAndView getEvents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
//        modelAndView.addObject("events", eventRepository.findAll());
//        modelAndView.addObject(eventRepository.findByEventName("runmageddon"));
//        Optional<Event> runmageddon = eventRepository.findByEventName("runmageddon");
        List<Event> runmageddon = eventRepository.findAll();
//        modelAndView.addObject("klucz" , runmageddon.orElseThrow(()->new RuntimeException("no such event")));
        modelAndView.addObject("eventKey" , runmageddon.toArray());
        System.out.println("model: " + modelAndView.getModel());

        return modelAndView;
    }

    @GetMapping("/youAreLoggedOut")
    ModelAndView getYouAreLoggedOut() {
        return new ModelAndView("youAreLoggedOut");
    }

}
