package com.example.election.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Voter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
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
          "Voter[id='%s', name='%s', postCode='%s']", id, name, postCode);
    }
}
