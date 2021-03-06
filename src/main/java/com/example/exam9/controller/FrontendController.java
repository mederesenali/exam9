package com.example.exam9.controller;


import com.example.exam9.model.*;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }


    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new Customer());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid Customer customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        return "home";
    }



}
