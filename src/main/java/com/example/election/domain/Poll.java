package com.example.election.domain;


import javax.persistence.*;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String name;
    public String address;
    public String postcode;

    public Poll() {}

    public Poll(final String name, final String address, final String postcode) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return String.format(
          "Poll[id=%s, name='%s', address='%s', postcode='%s']", id, name, address, postcode);
    }
}
