package com.example.firstproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.firstproject.service.EngineerService;
import com.example.firstproject.entity.Engineer;

@Controller
@RequestMapping("/api/thymeleaf")
public class ThymeleafController {

    private EngineerService engineerService;

    ThymeleafController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/hello")
    public String getHtmlPage(Model model) {
        model.addAttribute("todayDate", new java.util.Date());
        return "helloworld";
    }

    @GetMapping("/emp-list")
    public String getEmployeeList(Model model) {

        List<Engineer> engineers = engineerService.findAll();
        model.addAttribute("engineers", engineers);
        return "employee-list";
    }

    @GetMapping("/employee-form")
    public String getEmployeeForm(Model model) {
        Engineer engineer = new Engineer();
        model.addAttribute("engineer", engineer);
        return "employee-form";
    }

    @GetMapping("/existing-engineer")
    public String showExistingEngineer(@RequestParam("engineerId") Integer id, Model model) {
        Engineer engineer = engineerService.findOneById(id);
        System.out.println(engineer);
        model.addAttribute("engineer", engineer);
        return "employee-form";
    }

    @PostMapping("/save-engineer")
    public String saveEngineer(@ModelAttribute("engineer") Engineer engineer) {

        engineerService.create(engineer);
        return "redirect:/api/thymeleaf/emp-list";
    }
    @GetMapping("/delete-engineer")
    public String saveEngineer(@RequestParam("engineerId") Integer id) {
        engineerService.deleteById(id);
        return "redirect:/api/thymeleaf/emp-list";
    }

}


