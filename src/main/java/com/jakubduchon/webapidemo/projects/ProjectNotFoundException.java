package com.jakubduchon.webapidemo.projects;

class ProjectNotFoundException extends RuntimeException {
    ProjectNotFoundException(Long id) {
        super("Could not find project with id " + id);
    }
}
