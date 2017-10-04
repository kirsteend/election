package com.example.election.poll;

import org.springframework.data.annotation.Id;


public class Poll {

    @Id
    public String id;

    public String name;
    public String address;
    public String postalCode;

    public Poll() {}

    public Poll(final String name, final String address, final String postalCode) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return String.format(
          "Poll[id=%s, name='%s', address='%s', postCode='%s']", id, name, address, postalCode);
    }
}
