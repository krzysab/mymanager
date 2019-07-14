package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventmanager.mymanager.model.Event;
import pl.sda.eventmanager.mymanager.model.User;

import java.util.Optional;

@Repository
public interface EvetnRepository extends JpaRepository <Event, Integer>  {

    Optional<Event> findByEventName(String name);
}
