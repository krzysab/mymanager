package pl.sda.eventmanager.mymanager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.eventmanager.mymanager.entity.Event;
import pl.sda.eventmanager.mymanager.repository.EvetnRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements UserDetailsService {

    private EvetnRepository evetnRepository;

    public EventService(EvetnRepository evetnRepository) {
        this.evetnRepository = evetnRepository;
    }

    //TODO zaimplemetowac inne metody przeszukujace baze danych EVENTOW

    @Override
    public UserDetails loadUserByUsername(String eventName) throws UsernameNotFoundException {
        Optional<Event> eventDetails = evetnRepository.findByEventName(eventName);
        return (UserDetails) eventDetails.orElseThrow(()->new UsernameNotFoundException("event not found"));
    }

    public List<Event> getEvents(){
        return evetnRepository.findAll();
    }

}
