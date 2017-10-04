package com.example.election.voter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
