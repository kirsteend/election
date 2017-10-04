package com.example.election.voter;


import com.example.election.poll.Poll;

import javax.persistence.*;

@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String name;
    public String postCode;

    @OneToOne(cascade = CascadeType.ALL)
    public Poll poll;

    public Voter() {}

    public Voter(final String name, final String postCode) {
        this.name = name;
        this.postCode = postCode;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public void setName(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPostCode(){
        return this.postCode;
    }

    @Override
    public String toString() {
        return String.format(
          "Voter[id=%s, name='%s', postCode='%s']", id, name, postCode);
    }
}
