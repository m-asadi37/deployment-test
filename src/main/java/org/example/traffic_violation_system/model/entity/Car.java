package org.example.traffic_violation_system.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
@Entity@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String color;
    private String plate;
    @OneToMany(mappedBy = "car")
    private List<Penalty> penalties;

}
