package com.example.election.service;

import com.example.election.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, String> {

    Party findByName(String name);
}
