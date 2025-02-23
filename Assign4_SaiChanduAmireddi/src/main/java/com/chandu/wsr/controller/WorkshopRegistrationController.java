package com.chandu.wsr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chandu.wsr.model.WorkshopRegistration;
import com.chandu.wsr.service.WorkshopRegistrationService;
import jakarta.validation.Valid;

@Controller
public class WorkshopRegistrationController {

    @Autowired
    private WorkshopRegistrationService service;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("workshopRegistration", new WorkshopRegistration());
        model.addAttribute("successMessage", null);
        return "workshopRegistrationForm";
    }

    @PostMapping("/register")
    public String submitRegistrationForm(@Valid WorkshopRegistration workshopRegistration, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "workshopRegistrationForm";
        }

        String result = service.saveDetails(workshopRegistration);
        if (!"Success".equals(result)) {
            model.addAttribute("errorMessage", result);
            return "workshopRegistrationForm";
        }

        model.addAttribute("successMessage", "Successfully Registered For WorkShop");
        model.addAttribute("workshopRegistration", new WorkshopRegistration());
        return "workshopRegistrationForm";
    }

    @GetMapping("/reset")
    public String resetForm(Model model) {
        model.addAttribute("workshopRegistration", new WorkshopRegistration());
        model.addAttribute("successMessage", null);
        model.addAttribute("errorMessage", null);
        return "workshopRegistrationForm";
    }
}
