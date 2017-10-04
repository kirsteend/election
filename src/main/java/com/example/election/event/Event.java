package com.example.election.event;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public class Event {
    @Id
    public String id;

    public String name;
    public Instant startDate;
    public Instant endDate;

    public Event(final String name, final Instant startDate, final Instant endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format(
          "Event[id=%s, name='%s', address='%s', startDate='%s', endDate='%s']", id, name, startDate.toString(), endDate.toString());
    }
}
