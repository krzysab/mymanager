package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventmanager.mymanager.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByNick(String nick);
    Optional<User> findByEmail(String email);
//    String readUserByNickAndPassword(String nick, String password);
}
