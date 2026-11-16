
package com.example.sms.controller;

import com.example.sms.model.Student;
import com.example.sms.model.User;
import com.example.sms.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    private boolean isStudent(HttpSession session) {
        User user = (User) session.getAttribute("user");

        return user != null &&
                "STUDENT".equalsIgnoreCase(user.getRole());
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size,
                            Model model,
                            HttpSession session) {

        if (!isStudent(session)) {
            return "redirect:/?error=true";
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = service.getPaginated(pageable);

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());

        return "student-dashboard";
    }
}
