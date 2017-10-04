package com.example.election.party;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public String name;

    public Party() {}

    public Party(final String name) {
        this.name = name;
    }
}
