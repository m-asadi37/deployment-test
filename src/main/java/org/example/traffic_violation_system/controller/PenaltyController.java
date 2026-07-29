package org.example.traffic_violation_system.controller;

import org.example.traffic_violation_system.model.dto.PenaltyDto;
import org.springframework.ui.Model;

public interface PenaltyController {

    String showList(Model model, String plate);

    String showNewForm(Model model);

    String showDetailForm(Model model, Long id);

    String doSave(PenaltyDto penalty);

    String doRemove(Long id);
}
