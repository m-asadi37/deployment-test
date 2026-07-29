package org.example.traffic_violation_system.controller;

import org.example.traffic_violation_system.model.dto.CarDto;
import org.example.traffic_violation_system.model.entity.Car;
import org.example.traffic_violation_system.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarContImpl implements CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/list")
    @Override
    public String showList(Model model,@RequestParam(required = false) String plate) {
        if(plate != null)
            model.addAttribute("list", List.of(carService.findByPlate(plate)));
        else
            model.addAttribute("list", carService.findAll());
        return "car-list";
    }

    @GetMapping("/new")
    @Override
    public String showNewForm(Model model) {
        model.addAttribute("obj", new CarDto());
        return "car-new";
    }

    @GetMapping("/detail")
    @Override
    public String showDetailForm(Model model,@RequestParam Long id) {
        model.addAttribute("obj", carService.findById(id));
        return "car-detail";
    }

    @PostMapping("/doSave")
    @Override
    public String doSave(@ModelAttribute CarDto car) {
        carService.save(car);
        return "redirect:/car/list";
    }

    @GetMapping("/doRemove")
    @Override
    public String doRemove(@RequestParam Long id) {
        carService.delete(id);
        return "redirect:/car/list";
    }
}
