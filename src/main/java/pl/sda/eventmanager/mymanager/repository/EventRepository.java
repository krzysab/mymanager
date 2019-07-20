package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventmanager.mymanager.entity.Event;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer>  {

    Optional<Event> findByEventName(String name);

    Optional<Event> findEventsByEventBeginIsAfter(LocalDate localDate);

//    public Event updateEvent(Event event);

}
