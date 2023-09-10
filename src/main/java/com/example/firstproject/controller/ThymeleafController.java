package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/thymeleaf")
public class ThymeleafController {

    ThymeleafController() {
    }

    @GetMapping("/hello")
    public String getHtmlPage(Model model) {
        model.addAttribute("todayDate", new java.util.Date());
        return "helloworld";
    }

}
