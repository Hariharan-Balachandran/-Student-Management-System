
package com.example.sms.controller;

import com.example.sms.model.User;
import com.example.sms.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String role,
                        HttpSession session) {

        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user != null
                && passwordEncoder.matches(password, user.getPassword())
                && user.getRole().equalsIgnoreCase(role)) {

            session.setAttribute("user", user);

            if ("TEACHER".equalsIgnoreCase(user.getRole())) {
                return "redirect:/teacher/dashboard";
            } else if ("STUDENT".equalsIgnoreCase(user.getRole())) {
                return "redirect:/student/dashboard";
            }
        }

        return "redirect:/?error=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
