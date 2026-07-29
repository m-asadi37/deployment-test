package org.example.traffic_violation_system.model.service;

import org.example.traffic_violation_system.model.dto.PenaltyDto;
import org.example.traffic_violation_system.model.entity.Penalty;

import java.util.List;

public interface PenaltyService {

    void save(PenaltyDto penalty);

    void delete(Long id);

    Penalty findById(Long id);

    List<Penalty> findByCarPlate(String plate);

    List<Penalty> findAll();
}