package com.jakubduchon.webapidemo;

import com.jakubduchon.webapidemo.employee.Employee;
import com.jakubduchon.webapidemo.employee.EmployeeRepository;
import com.jakubduchon.webapidemo.projects.Project;
import com.jakubduchon.webapidemo.projects.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepo, ProjectRepository projectrRepo) {
        return args -> {
            Employee bob = new Employee("Bob Buffalo", "Software Engineer");
            Employee alice = new Employee("Alice Anaconda", "Product Owner");
            Project cryptoPuppies = new Project("Crypto puppies", "Unicorn NFT project");
            log.info("Preloading " + employeeRepo.save(bob));
            log.info("Preloading " + employeeRepo.save(alice));
            log.info("Preloading " + projectrRepo.save(cryptoPuppies));
        };
    }
}
