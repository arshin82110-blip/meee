package spareparts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    // Login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Register page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        if(email.equals("admin@gmail.com") && password.equals("admin")){
            return "redirect:/admin/dashboard";
        }

        return "redirect:/customer/dashboard";
    }

    // Handle register
    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password){

        // For now just redirect to login
        return "redirect:/login";
    }
}