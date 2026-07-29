package org.example.traffic_violation_system.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private Long id;
    private String model;
    private String color;
    private String plate;
    private List<PenaltyDto> penalties;

}
