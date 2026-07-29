package org.example.traffic_violation_system.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PenaltyDto {

    private Long id;
    private String subject;
    private Double amount;
    private String occurTime;
    private Long carId;

}
