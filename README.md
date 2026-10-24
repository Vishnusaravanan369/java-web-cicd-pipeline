# Java Web CI/CD Pipeline Using Jenkins, Maven & Tomcat

## Project Overview

This project demonstrates an end-to-end CI/CD pipeline for a Java web application using Jenkins, Maven, Git, and Apache Tomcat.

The pipeline checks out source code from GitHub, builds and tests the application, archives the WAR artifact, deploys it to Tomcat, and performs an application health check. If the health check fails, the pipeline attempts to restore a previous working WAR and restart Tomcat.

## Architecture

Developer → GitHub → Jenkins → Maven Build & Unit Tests → JUnit Test Report → WAR Artifact → Tomcat Deployment → Health Check

If the health check fails:

Health Check Failure → Restore Previous WAR → Restart Tomcat → Verify Application Recovery

## Technologies Used

- **Java 21** – Application development
- **Maven** – Build automation and WAR packaging
- **JUnit and Mockito** – Unit testing
- **Git and GitHub** – Source code management and version history
- **Jenkins** – CI/CD automation using a declarative Jenkinsfile
- **Apache Tomcat** – Java web application server
- **CentOS Linux** – Build and deployment environment
- **Bash** – Pipeline automation and health checks

## Application Details

- **Application:** Student Feedback Portal
- **Packaging:** WAR
- **Artifact:** `student-feedback-portal-1.0-SNAPSHORT.war`
- **Tomcat port:** `8083`
- **Application endpoint:** `/student-feedback-portal-1.0-SNAPSHORT/feedback`
- **Development branch:** `dev`
- **Version 1 tag:** `v1.0`

## CI/CD Pipeline Stages

1. **Source Checkout:** Jenkins retrieves the source code and Jenkinsfile from GitHub.
2. **Environment Check:** Jenkins checks the installed Java and Maven versions.
3. **Build and Test:** Maven compiles the application, executes unit tests, and packages the WAR.
4. **Test Report:** Jenkins publishes JUnit test results.
5. **Artifact Archiving:** Jenkins archives the generated WAR and records its fingerprint.
6. **Tomcat Deployment:** Jenkins copies the WAR into Tomcat's `webapps` directory.
7. **Application Health Check:** Jenkins uses `curl -f` to check whether the application endpoint responds successfully.
8. **Automatic Rollback:** If the health-check stage fails, the pipeline restores the previous WAR, restarts Tomcat, and checks the application again.

## Failure Testing and Recovery

### 1. Unit Test Failure

An assertion was intentionally changed to an incorrect expected value. Maven reported a test failure, and Jenkins stopped before artifact archiving and deployment. The assertion was restored, and the build passed again.

### 2. Deployment Health-Check Failure

The health-check URL was temporarily changed to an invalid path to simulate a failed health check.

- The health check returned HTTP 404.
- Jenkins executed the rollback block.
- The previous WAR was restored.
- Tomcat was restarted.
- The application returned the Version 1 HTML successfully.

The build was marked as failed because the original health check intentionally failed, even though the rollback and recovery check succeeded. A subsequent normal pipeline run deployed Version 2 successfully.

### 3. Git Recovery

The temporary invalid health-check URL was introduced in a dedicated commit and then corrected in a later commit. Git history preserves both changes for review.

## Running the Project

1. Clone the repository.
2. Configure Java, Maven, Jenkins, and Tomcat.
3. Configure the Jenkins job to use the repository and its `Jenkinsfile`.
4. Ensure Jenkins has the necessary permissions to deploy the WAR and restart Tomcat.
5. Run the Jenkins pipeline.
6. Review the build console, JUnit results, and archived WAR.
7. Verify the deployed application using the configured endpoint.

## Project Status

- [x] Java web application
- [x] GitHub repository and development branch
- [x] Maven build and WAR packaging
- [x] Unit tests
- [x] Jenkins JUnit test reporting
- [x] Jenkins artifact archiving and fingerprinting
- [x] Automated Tomcat deployment
- [x] Application health check
- [x] Unit-test failure demonstration
- [x] Automatic rollback demonstration
- [x] Git history showing failure introduction and correction
- [ ] Final screenshots and project evidence
- [ ] Final documentation review
- [ ] Demo video, if required by the assignment

## Learning Outcomes

This project provided practical experience with CI/CD pipeline design, Maven build automation, JUnit testing, Jenkins Pipeline as Code, WAR deployment, Linux permissions, application health checks, Git history, and rollback procedures.

## Future Improvements

- Improve automated triggering on GitHub changes if needed.
- Add Docker-based packaging and deployment.
- Add code-quality and security scanning.
- Explore cloud deployment or Kubernetes.

