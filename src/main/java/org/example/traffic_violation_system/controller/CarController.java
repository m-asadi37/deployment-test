package org.example.traffic_violation_system.controller;

import org.example.traffic_violation_system.model.dto.CarDto;
import org.springframework.ui.Model;

public interface CarController {

    String showList(Model model, String plate);

    String showNewForm(Model model);

    String showDetailForm(Model model, Long id);

    String doSave(CarDto car);

    String doRemove(Long id);
}
