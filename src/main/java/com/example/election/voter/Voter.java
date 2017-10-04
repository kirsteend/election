package com.example.election.voter;

import org.springframework.data.annotation.Id;


public class Voter {

    @Id
    public String id;

    public String name;
    public String postCode;

    public Voter() {}

    public Voter(final String name, final String postCode) {
        this.name = name;
        this.postCode = postCode;
    }

    public void setName(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
          "Voter[id=%s, name='%s', postCode='%s']", id, name, postCode);
    }
}
