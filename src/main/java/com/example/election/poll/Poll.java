package com.example.election.poll;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String id;

    public String name;
    public String address;
    public String postCode;

    public Poll() {}

    public Poll(final String name, final String address, final String postCode) {
        this.name = name;
        this.address = address;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return String.format(
          "Poll[id=%s, name='%s', address='%s', postCode='%s']", id, name, address, postCode);
    }
}
