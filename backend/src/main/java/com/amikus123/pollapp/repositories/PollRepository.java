package com.amikus123.pollapp.repositories;

import com.amikus123.pollapp.entities.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> { }