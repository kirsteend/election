package com.example.election.candidate;

import org.springframework.data.annotation.Id;

public class Candidate {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String riding;
    public String party;

    public Candidate() {}

    public Candidate(final String firstName, final String lastName, final String riding, final String party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.riding = riding;
        this.party = party;
    }

    @Override
    public String toString() {
        return String.format(
          "Candidate[id=%s, firstName='%s', lastName='%s', riding='%s', party='%s']", id, firstName, lastName, riding, party);
    }

}
