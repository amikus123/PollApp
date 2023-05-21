package com.amikus123.pollapp.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PollOption  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    @JoinColumn(name="poll_id")
    @JsonBackReference
    private Poll poll;

    @OneToMany(mappedBy = "pollOption")
    private List<PollOptionChoice> pollOptionChoices;


}
