package com.amikus123.pollapp.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PollOptionChoice  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private String value;
    @ManyToOne
    @JoinColumn(name="pollOption_id")
    @JsonBackReference
    private PollOption pollOption;

}
