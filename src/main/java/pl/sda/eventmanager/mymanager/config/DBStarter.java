package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.eventmanager.mymanager.entity.Event;
import pl.sda.eventmanager.mymanager.entity.User;
import pl.sda.eventmanager.mymanager.repository.EventRepository;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import pl.sda.eventmanager.mymanager.service.EventService;
import pl.sda.eventmanager.mymanager.service.UserService;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class DBStarter implements ApplicationRunner {

    private UserRepository userRepository;
    private UserService userService;
    private EventRepository eventRepository;
    private EventService eventService;

//    @Autowired
//    protected DBStarter(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @Autowired
    public DBStarter(UserRepository userRepository
            , UserService userService
            , EventRepository eventRepository
            , EventService eventService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    public void run(ApplicationArguments args) throws Exception{

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

        userRepository.save(new User("admin", "admin@gmail.com", bCrypt.encode("1111")));
        userRepository.save(new User("andzia", "andzia@yahoo.com", bCrypt.encode("2222")));
        userRepository.save(new User("marcin", "marcin@yahoo.com", bCrypt.encode("3333")));
        userRepository.save(new User("monika", "monika@yahoo.com", bCrypt.encode("4444")));
        userRepository.save(new User("jakub", "jakub@yahoo.com", bCrypt.encode("5555")));
        userRepository.save(new User("agnieszka", "agnieszka@mail.com", bCrypt.encode("6666")));
        userRepository.save(new User("kamil", "kamil@mail.com", bCrypt.encode("7777")));
        userRepository.save(new User("iza", "iza@yahoo.com", bCrypt.encode("8888")));
        userRepository.save(new User("adrian", "adrian@gmail.com", bCrypt.encode("9999")));
        userRepository.save(new User("renata", "ranata@yahoo.com", bCrypt.encode("0000")));

        /**
         *
         *         1 adam@mail.com adam 1111
         *         2 kasia@yahoo.com kasia 2222
         *         3 marcin@yahoo.com marcin 3333
         *         4 monika@yahoo.com monika 4444
         *         5 jakub@yahoo.com jakub 5555
         *         6 agnieszka@mail.com agnieszka 6666
         *         7 kamil@mail.com kamil 7777
         *         8 iza@yahoo.com iza 8888
         *         9 adrian@gmail.com adrian 9999
         *         10 ranata@yahoo.com renata 0000
         *
         * */

        eventRepository.save(
                new Event("runmageddon",
                        LocalDate.of(2019, 12, 20),
                        "43-100 Tychy Niepodleglosci 50"));

        eventRepository.save(
                new Event("masakrator",
                        LocalDate.of(1999, 11, 03),
                "43-190 Laziska Gorne Orzeska 23"));

        eventRepository.save(
                new Event("bieg komandosa",
                        LocalDate.of(2003, 04, 27),
                        "45-230 Warszawa Marszalkowska 45"));

        eventRepository.save(
                new Event("masakrator",
                        LocalDate.of(2007, 05, 31),
                        "99-400 Krakow Wawelska 330"));

        Optional<Event> event = Optional.of(new Event());
        event = eventRepository.findByEventName("runmageddon");
        System.out.println(event);

//        EventRepository repo = context.getBean(EventRepository.class);

//        Event event = eventRepository.getOne(1);
//        event.setEventInfo("hello mono moja macocha jest kosmitka");

//        Event event1 = eventService.updateEvent(eventRepository.getOne(11));
//        event1.setEventInfo("ala ma kota a kot ma ale");

    }

}
