package com.example.sms.controller;

import com.example.sms.model.User;
import com.example.sms.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String loginPage() {
        return "login"; // login.html page
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);

            if ("TEACHER".equalsIgnoreCase(user.getRole())) {
                return "redirect:/teacher/dashboard";
            } else if ("STUDENT".equalsIgnoreCase(user.getRole())) {
                return "redirect:/student/dashboard";
            }
        }

        return "redirect:/?error=true"; // failed login
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
