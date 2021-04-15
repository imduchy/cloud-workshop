# Cloud Workshop

This repository contains a start Java Spring Boot application for the Cloud Workshop. The application was generated with [Spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=com.jakubduchon&artifactId=webapi-demo&name=webapi-demo&description=Demo%20project%20for%20the%20Cloud%20Workshop&packageName=com.jakubduchon.webapi-demo&dependencies=web,data-jpa,postgresql) and contains Spring Web, Spring Data JPA and PostgreSQL driver dependencies.

The workshop is hosted for the 4th-semester Software Engineering students at VIA University Horsens. Throughout the workshop, students will learn how to deploy an application to AWS to utilize the cloud for hosting their Semester projects online.

## Architecture

To host the Spring Boot application we will use AWS Elastic Beanstalk, and AWS RDS to host a database. Both of the services are fully managed, require minimal setup and are part of the AWS Free Tier (for the first 12 months). The Spring Boot application will connect to the RDS database and will be exposed to the internet via a Web API.

![architecture diagram](https://github.com/Duchynko/cloud-workshop/blob/main/docs/architecture.png?raw=true "Architecture diagram")

## Prerequisities

- Git installed on your machine
- Java installed and set up on your machine
- PostgreSQL installed on your machine (or using Docker)
- AWS Account created using the [AWS Educate link](https://aws.amazon.com/education/awseducate/students/) (this will give you a $40 credit)

## How to set up the project locally

- Pull the project locally (e.g., using SSH with `git pull git@github.com:Duchynko/cloud-workshop.git`)
- Replace the `username`, `password` and `url` fields in the `src/resources/application.properties` and supplement your own database credentials
