package com.example.election.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    public String name;

    public Party() {}

    public Party(final String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "party")
    private Set<Candidate> candidates;

    @Override
    public String toString() {
        return String.format(
                "Party[id='%s', name='%s']", id, name);
    }
}
