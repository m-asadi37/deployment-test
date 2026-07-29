package org.example.traffic_violation_system.model.service;

import org.example.traffic_violation_system.model.dto.CarDto;
import org.example.traffic_violation_system.model.entity.Car;

import java.util.List;

public interface CarService {

    void save(CarDto car);

    void delete(Long id);

    Car findById(Long id);

    Car findByPlate(String plate);

    List<Car> findAll();
}
