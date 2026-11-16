
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final StudentService service;

    public TeacherController(StudentService service) {
        this.service = service;
    }

    private boolean isTeacher(HttpSession session) {
        User user = (User) session.getAttribute("user");

        return user != null &&
                "TEACHER".equalsIgnoreCase(user.getRole());
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size,
                            Model model,
                            HttpSession session) {

        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = service.getPaginated(pageable);

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());

        return "teacher-dashboard";
    }

    @GetMapping("/add")
    public String addForm(Model model, HttpSession session) {
        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes,
                       HttpSession session) {

        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        service.save(student);
        redirectAttributes.addFlashAttribute(
                "successMessage", "Student added successfully!");

        return "redirect:/teacher/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id,
                           Model model,
                           HttpSession session) {

        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        model.addAttribute("student", service.getById(id));
        return "edit-student";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Student student,
                         HttpSession session) {

        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        service.save(student);
        return "redirect:/teacher/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         HttpSession session) {

        if (!isTeacher(session)) {
            return "redirect:/?error=true";
        }

        service.delete(id);
        return "redirect:/teacher/dashboard";
    }
}
