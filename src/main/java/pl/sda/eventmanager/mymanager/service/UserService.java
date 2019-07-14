package pl.sda.eventmanager.mymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void saveNewUser(String nick, String email, String password) {
        final User newUser = new User();
        newUser.setNick(nick);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
    }

    //Todo przerobic pozostale metody czytajace z bazy dancyh

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public  void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getConcatById(int id) {
        return userRepository.findById(id);
    }

    //TODO pracuje nad odczytaniem emaila z bazy danych i wswietlenie go po zalogowaniu
    public String readUserEmail(User user) {
        //String string = userRepository.findByNick(user.getNick()).get().getEmail();
        //return user.getEmail();
        return userRepository.findByNick(user.getNick()).get().getEmail();
    }

//    public String readUserEmail(String nick, String password) {
//        return userRepository.readUserByNickAndPassword(nick, password);
//    }

//    public String readUserEmail (String nick) {
//        return readUserEmail(nick);
//    }

    @Override
    public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {

        Optional<User> userDetails = userRepository.findByNick(nick);
        return userDetails.orElseThrow(()->new UsernameNotFoundException("nick not found"));
    }

    //TODO sprawdzic czy ta metoda wogole dziala
    public Optional<User> loadUserByEmail(String email) throws UsernameNotFoundException {
        return Optional
                .ofNullable(userRepository
                .findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("email not found")));
    }


}
