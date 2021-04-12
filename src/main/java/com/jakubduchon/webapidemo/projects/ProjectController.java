package com.jakubduchon.webapidemo.projects;

import com.jakubduchon.webapidemo.employee.Employee;
import com.jakubduchon.webapidemo.employee.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectRepository repository;
    private final EmployeeRepository employeeRepository;

    public ProjectController(ProjectRepository repository, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/projects")
    List<Project> all() {
        return repository.findAll();
    }

    @GetMapping("/projects/{id}")
    Project one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException(id)
        );
    }

    @PutMapping("/projects/{pid}/employee/{eid}")
    Project enrollEmployee(@PathVariable Long pid, @PathVariable Long eid) {
        Project project = repository.findById(pid).get();
        Employee employee = employeeRepository.findById(eid).get();
        project.enrollEmployee(employee);
        return repository.save(project);
    }

    @PutMapping("/projects/{id}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {
        return repository.findById(id)
                .map(project -> {
                    project.setName(newProject.getName());
                    project.setDescription(newProject.getDescription());
                    project.setEnrolledEmployees(newProject.getEnrolledEmployees());
                    return project;
                })
                .orElseGet(() -> {
                    newProject.setId(id);
                    return repository.save(newProject);
                });
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    @DeleteMapping("/projects/{id}")
    void deleteProject(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
