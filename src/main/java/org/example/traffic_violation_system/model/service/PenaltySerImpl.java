package org.example.traffic_violation_system.model.service;

import org.example.traffic_violation_system.model.dto.PenaltyDto;
import org.example.traffic_violation_system.model.entity.Car;
import org.example.traffic_violation_system.model.entity.Penalty;
import org.example.traffic_violation_system.model.repository.PenaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PenaltySerImpl implements PenaltyService {

    @Autowired
    private PenaltyRepository penaltyRepository;

    @Override
    public void save(PenaltyDto penalty) {
        Penalty penalty1 = Penalty.builder()
                .id(penalty.getId())
                .amount(penalty.getAmount())
                .subject(penalty.getSubject())
                .car(Car.builder().id(penalty.getCarId()).build())
                .occurTime(LocalDateTime.parse(penalty.getOccurTime()))
                .build();
        penaltyRepository.save(penalty1);
    }

    @Override
    public void delete(Long id) {
        penaltyRepository.deleteById(id);
    }

    @Override
    public Penalty findById(Long id) {
        return penaltyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Penalty> findByCarPlate(String plate) {
        return penaltyRepository.findByCarPlate(plate);
    }

    @Override
    public List<Penalty> findAll() {
        return penaltyRepository.findAll();
    }
}
