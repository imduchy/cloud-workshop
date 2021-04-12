package com.jakubduchon.webapidemo.projects;

import com.fasterxml.jackson.annotation.*;
import com.jakubduchon.webapidemo.employee.Employee;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "project_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @JsonIgnoreProperties("projects")
    private Set<Employee> enrolledEmployees;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.enrolledEmployees = new HashSet<>();
    }

    public Project() {
    }

    public void enrollEmployee(Employee employee) {
        this.enrolledEmployees.add(employee);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Employee> getEnrolledEmployees() {
        return enrolledEmployees;
    }

    public void setEnrolledEmployees(Set<Employee> enrolledEmployees) {
        this.enrolledEmployees = enrolledEmployees;
    }
}
