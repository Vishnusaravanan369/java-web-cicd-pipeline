# Java Web CI/CD Pipeline Using Jenkins, Maven & Tomcat

## Project Overview

This project demonstrates an end-to-end Continuous Integration and Continuous Deployment (CI/CD) pipeline for a Java web application using Jenkins, Maven, and Apache Tomcat.

The pipeline automatically builds the application, generates a WAR artifact, deploys it to Tomcat, and checks whether the application is responding successfully.

## Architecture

Developer → GitHub → Jenkins → Maven Build → WAR Artifact → Tomcat Deployment → Health Check

## Technologies Used

- **Java 21** – Application development
- **Maven** – Build automation and dependency management
- **Git & GitHub** – Source code management
- **Jenkins** – CI/CD pipeline automation
- **Apache Tomcat** – Java web application server
- **Linux (CentOS)** – Deployment environment
- **Bash** – Shell commands used in pipeline stages

## Pipeline Stages

1. **Source Code Management:** Application source code and the Jenkinsfile are maintained in GitHub.
2. **Build:** Jenkins executes Maven to compile the application and package it as a WAR file.
3. **Archive Artifact:** Jenkins archives the generated WAR file and fingerprints it for tracking.
4. **Deployment:** Jenkins copies the WAR file to Tomcat's `webapps` directory.
5. **Health Check:** Jenkins uses `curl -f` to verify that the deployed application returns a successful HTTP response.

## Application Details

- Application: Student Feedback Portal
- Packaging: WAR
- Artifact: `student-feedback-portal-1.0-SNAPSHOT.war`
- Application endpoint: `/student-feedback-portal-1.0-SNAPSHOT/feedback`

## Running the Project

1. Clone the repository.
2. Configure Java, Maven, Jenkins, and Tomcat in the environment.
3. Configure the Jenkins job to use the repository and its `Jenkinsfile`.
4. Build the pipeline in Jenkins.
5. Verify the application using the configured Tomcat URL.

## Current Status

- [x] Maven build
- [x] WAR artifact generation
- [x] Jenkins artifact archiving
- [x] WAR deployment to Tomcat
- [x] Application health check
- [ ] Automatic GitHub change detection and pipeline triggering
- [ ] Final end-to-end testing and documentation screenshots

## Learning Outcomes

This project provides practical experience with CI/CD pipeline design, Maven build automation, Jenkins Pipeline as Code, WAR deployment, Linux permissions, and application health checks.

## Future Improvements

- Configure automated builds on GitHub changes.
- Add unit tests and test reports.
- Containerize the application using Docker.
- Add deployment rollback and improved failure handling.
- Extend the pipeline to a cloud or Kubernetes environment.

