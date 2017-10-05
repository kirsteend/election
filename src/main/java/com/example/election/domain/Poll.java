package com.example.election.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Poll implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String address;

    @Column(nullable = false)
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
          "Poll[id='%s', name='%s', address='%s', postcode='%s']", id, name, address, postcode);
    }
}
