package pl.sda.eventmanager.mymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

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
}
