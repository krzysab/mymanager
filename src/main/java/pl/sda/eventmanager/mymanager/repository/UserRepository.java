package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.eventmanager.mymanager.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {

    public Optional<User> findByNick(String nick);

}
