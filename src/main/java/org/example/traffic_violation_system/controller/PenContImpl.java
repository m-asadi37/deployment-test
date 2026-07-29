package org.example.traffic_violation_system.controller;

import org.example.traffic_violation_system.model.dto.PenaltyDto;
import org.example.traffic_violation_system.model.entity.Penalty;
import org.example.traffic_violation_system.model.entity.PenaltyType;
import org.example.traffic_violation_system.model.service.CarService;
import org.example.traffic_violation_system.model.service.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/penalty")
public class PenContImpl implements PenaltyController {

    @Autowired
    private PenaltyService penaltyService;
    @Autowired
    private CarService carService;

    @GetMapping("/list")
    @Override
    public String showList(Model model,@RequestParam(required = false) String plate) {
        List<Penalty> list = null;
        if(plate != null)
            list = penaltyService.findByCarPlate(plate);
        else
            list = penaltyService.findAll();
        model.addAttribute("list", list);
        return "penalty-list";
    }

    @GetMapping("/new")
    @Override
    public String showNewForm(Model model) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("obj", new PenaltyDto());
        model.addAttribute("types", PenaltyType.values());
        return "penalty-new";
    }

    @GetMapping("/detail")
    @Override
    public String showDetailForm(Model model,@RequestParam Long id) {
        model.addAttribute("obj", penaltyService.findById(id));
        return "penalty-detail";
    }

    @PostMapping("/doSave")
    @Override
    public String doSave(@ModelAttribute PenaltyDto penalty) {
        penaltyService.save(penalty);
        return "redirect:/penalty/list";
    }

    @GetMapping("/doRemove")
    @Override
    public String doRemove(@RequestParam Long id) {
        penaltyService.delete(id);
        return "redirect:/penalty/list";
    }
}
