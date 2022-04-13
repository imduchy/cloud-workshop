# Cloud Workshop

This repository contains a bootstrapped Java Spring Boot application for the Cloud Workshop. The application was generated with [Spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=com.jakubduchon&artifactId=webapi-demo&name=webapi-demo&description=Demo%20project%20for%20the%20Cloud%20Workshop&packageName=com.jakubduchon.webapi-demo&dependencies=web,data-jpa,postgresql) and contains Spring Web, Spring Data JPA and PostgreSQL driver dependencies. To use a different database, simply replace the PostgreSQL Driver with the one of your choice (e.g., MS SQL Server Driver).

The workshop is hosted for the 4th-semester Software Engineering students at VIA University Horsens. Throughout the workshop, students will learn how to deploy applications to AWS and utilize the cloud for hosting their Semester projects online.

## Architecture

To host the Spring Boot application we will use AWS Elastic Beanstalk, and AWS RDS to host the database. Both of the services are fully managed, require minimal setup and are part of the AWS Free Tier. The Spring Boot application will connect to the RDS database and will be exposed to the internet via a Web API.

![architecture diagram](https://github.com/Duchynko/cloud-workshop/blob/main/docs/architecture.png?raw=true "Architecture diagram")

## Prerequisites

- Git installed
- Java installed and set up
- PostgreSQL installed
- AWS Account (a credit card required)

## How to set up the project locally

1. Clone the project locally (e.g., using SSH with `git clone git@github.com:Duchynko/cloud-workshop.git`)
2. Replace the `username`, `password` and `url` fields in the `src/resources/application.properties` and provide your own database credentials
3. Make sure your database is up and running
4. Start the application

## How to deploy application to AWS Elastic Beanstalk

- [Deployment steps](docs/DEPLOY_ELASTIC_BEANSTALK.md)

## Useful links

- [Introduction to AWS Elastic Beanstalk](https://www.youtube.com/watch?v=uiM1xzOX8Qg)
- [Deploying a Spring Boot Application on AWS Using AWS Elastic Beanstalk](https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/)
