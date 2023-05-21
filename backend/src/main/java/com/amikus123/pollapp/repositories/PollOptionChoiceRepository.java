package com.amikus123.pollapp.repositories;

import com.amikus123.pollapp.entities.PollOption;
import com.amikus123.pollapp.entities.PollOptionChoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollOptionChoiceRepository extends JpaRepository<PollOptionChoice, Integer> { }