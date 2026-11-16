
package com.example.sms.config;

import com.example.sms.model.User;
import com.example.sms.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DemoUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DemoUserInitializer(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        createDemoUser("teacher", "tea159", "TEACHER");

        createDemoUser("student", "stud357", "STUDENT");
    }

    private void createDemoUser(String username,
                                String password,
                                String role) {

        if (userRepository.findByUsername(username).isEmpty()) {

            User user = new User();

            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);

            userRepository.save(user);

            System.out.println("Demo account created: " + username);

        } else {
            System.out.println("Demo account already exists: " + username);
        }
    }
}
