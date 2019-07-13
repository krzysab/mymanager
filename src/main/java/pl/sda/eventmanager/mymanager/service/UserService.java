package pl.sda.eventmanager.mymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//        UserDetails userDetails = userRepository.findByNick(s);

        Optional<User> userDetails = userRepository.findByNick(s);
        return userDetails.orElseThrow(()->new UsernameNotFoundException("nick not found"));


//        if(userDetails!=null){
//            return userDetails;
//        } else {
//            throw new UsernameNotFoundException("nick not found");
//        }
    }
}
