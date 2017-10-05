package com.example.election.service;

import com.example.election.domain.Riding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidingRepository extends JpaRepository<Riding, String> {

    public Riding findByName(String name);
}
