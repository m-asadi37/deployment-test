package org.example.traffic_violation_system.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private Double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime occurTime;
    @JoinColumn
    @ManyToOne
    private Car car;

}
