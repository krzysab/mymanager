package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventmanager.mymanager.entity.Event;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer>  {

    Optional<Event> findByEventName(String name);

}
