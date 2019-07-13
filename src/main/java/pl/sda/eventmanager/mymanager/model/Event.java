package pl.sda.eventmanager.mymanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "eventName")
    private String eventName;

    @NotNull
    @Column(name = "eventBegin")
    private LocalDate eventBegin;

    @NotNull
    @Column(name = "eventEnd")
    private LocalDate eventEnd;

    @NotNull
    @Column(name = "eventAddress")
    private String eventAddress;

    @NotNull
    @Column(name = "eventInfo")
    private String eventInfo;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventBegin() {
        return eventBegin;
    }

    public void setEventBegin(LocalDate eventBegin) {
        this.eventBegin = eventBegin;
    }

    public LocalDate getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(LocalDate eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(eventName, event.eventName) &&
                Objects.equals(eventBegin, event.eventBegin) &&
                Objects.equals(eventEnd, event.eventEnd) &&
                Objects.equals(eventAddress, event.eventAddress) &&
                Objects.equals(eventInfo, event.eventInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventBegin, eventEnd, eventAddress, eventInfo);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventBegin=" + eventBegin +
                ", eventEnd=" + eventEnd +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventInfo='" + eventInfo + '\'' +
                '}';
    }
}