package com.example.election.poll;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Poll {

    @Id
    public String id;

    public String name;
    public String address;
    public List<String> postalCodes;

    public Poll(final String name, final String address, final List<String> postalCodes) {
        this.name = name;
        this.address = address;
        this.postalCodes = postalCodes;
    }

    @Override
    public String toString() {
        return String.format(
          "Poll[id=%s, name='%s', address='%s', postCodes='%s']", id, name, address, postalCodes.toString());
    }
}
