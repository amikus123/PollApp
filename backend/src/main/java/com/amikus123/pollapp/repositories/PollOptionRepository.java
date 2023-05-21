package com.amikus123.pollapp.repositories;

import com.amikus123.pollapp.entities.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PollOptionRepository extends JpaRepository<PollOption, Integer> { }