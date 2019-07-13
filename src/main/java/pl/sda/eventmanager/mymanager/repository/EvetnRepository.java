package pl.sda.eventmanager.mymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.eventmanager.mymanager.model.Event;

public interface EvetnRepository extends JpaRepository <Event, Integer>  {
}
