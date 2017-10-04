package com.example.election.voter;

import org.springframework.data.annotation.Id;


public class Voter {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String postCode;

    public Voter() {}

    public Voter(final String firstName, final String lastName, final String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    public void setFirstName(final String firstName){
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return String.format(
          "Voter[id=%s, firstName='%s', lastName='%s', postCode='%s']", id, firstName, lastName, postCode);
    }
}
