package pl.sda.eventmanager.mymanager.config;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;

@Component
public class DBStarter implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    protected DBStarter(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Fairy fairy = Fairy.create();

        for(int i = 0; i < 10; i++){
            Person person = fairy.person();
            User user = new User();
            user.setNick(person.getUsername());
            user.setEmail(person.getEmail());
            userRepository.save(user);
            System.out.println(user.toString());
        }

    }
}
