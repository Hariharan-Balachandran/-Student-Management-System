package com.example.sms.service;

import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() { return repo.findAll(); }
    public Page<Student> getPaginated(Pageable pageable) {
        return repo.findAll(pageable);
    }
    public Student save(Student s) { return repo.save(s); }
    public void delete(Long id) { repo.deleteById(id); }
    public Student getById(Long id) { return repo.findById(id).orElse(null); }
}
