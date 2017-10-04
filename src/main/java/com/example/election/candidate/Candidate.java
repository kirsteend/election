package com.example.election.candidate;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Candidate {

    @Id
    private String id;

    public String name;
    public String riding;
    public String party;

    public Candidate() {}

    public Candidate(final String name, final String riding, final String party) {
        this.name = name;
        this.riding = riding;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
          "Candidate[id=%s, name='%s', riding='%s', party='%s']", id, name, riding, party);
    }

}
