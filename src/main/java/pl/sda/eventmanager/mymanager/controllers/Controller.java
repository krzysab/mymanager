package pl.sda.eventmanager.mymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.UserService;

@org.springframework.stereotype.Controller
//@ComponentScan("pl.sda.eventmanager.mymanager")
public class Controller implements ApplicationRunner {

    private final UserRepository userRepository;
    private  final UserService userService;

    @Autowired
    public Controller(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

//    @Autowired
//    public Controller(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
