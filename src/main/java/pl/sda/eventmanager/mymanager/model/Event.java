package pl.sda.eventmanager.mymanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "idEvents")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "eventName")
    private String eventName;

    @NotNull
    @Column(name = "eventBegin")
    private Date eventBegin;

    @Column(name = "eventEnd")
    private Date eventEnd;

    @NotNull
    @Column(name = "eventAddress")
    private String eventAddress;

    @Column(name = "eventInfo")
    private String eventInfo;

    public Event() {
    }

    public Event(@NotNull String eventName, @NotNull Date eventBegin, @NotNull String eventAddress) {
        this.eventName = eventName;
        this.eventBegin = eventBegin;
        this.eventAddress = eventAddress;
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

    public Date getEventBegin() {
        return eventBegin;
    }

    public void setEventBegin(Date eventBegin) {
        this.eventBegin = eventBegin;
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Date eventEnd) {
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
