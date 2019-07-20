package pl.sda.eventmanager.mymanager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.eventmanager.mymanager.entity.Event;
import pl.sda.eventmanager.mymanager.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements UserDetailsService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //TODO zaimplemetowac inne metody przeszukujace baze danych EVENTOW

    @Override
    public UserDetails loadUserByUsername(String eventName) throws UsernameNotFoundException {
        Optional<Event> eventDetails = eventRepository.findByEventName(eventName);
        return (UserDetails) eventDetails.orElseThrow(()->new UsernameNotFoundException("event not found"));
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }


}
