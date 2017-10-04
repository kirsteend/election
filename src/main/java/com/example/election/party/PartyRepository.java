package com.example.election.party;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, String> {

    public Party findByName(String name);
}
