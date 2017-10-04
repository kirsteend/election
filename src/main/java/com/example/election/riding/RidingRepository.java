package com.example.election.riding;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RidingRepository extends JpaRepository<Riding, String> {

    public Riding findByName(String name);
}
