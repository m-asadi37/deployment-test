package org.example.traffic_violation_system.model.service;

import org.example.traffic_violation_system.model.dto.CarDto;
import org.example.traffic_violation_system.model.entity.Car;
import org.example.traffic_violation_system.model.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
CarSerImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(CarDto car) {
        Car car1 = Car.builder()
                .id(car.getId())
                .model(car.getModel())
                .plate(car.getPlate())
                .color(car.getColor()).build();
        carRepository.save(car1);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Car findByPlate(String plate) {
        return carRepository.findByPlate(plate).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
