package org.example.traffic_violation_system.model.repository;

import org.example.traffic_violation_system.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByPlate(String plate);
}
