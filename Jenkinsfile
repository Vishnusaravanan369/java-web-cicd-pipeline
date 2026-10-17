pipeline {
	agent any

	stages {
	   stage('checkout') {
		steps {
		   echo 'source code is available in the workspace'
		      }
	}
	   stage('check java and maven') {
		steps {
		   sh 'java -version'
		   sh 'mvn -version'
		      }
	}
	   stage('Built and Test') {
		steps {
		   sh 'mvn clean package'
		      }
	}
	   stage('Archive WAR') {
		steps {
		  archiveArtifacts artifacts: 'target/*.war',
			           fingerprint: true
		      }
	}
	   stage('Deploy to Tomcat') {
    steps {
        sh '''
            cp target/student-feedback-portal-1.0-SNAPSHORT.war /opt/tomcat/webapps/jenkins-test.war
            mv /opt/tomcat/webapps/jenkins-test.war /opt/tomcat/webapps/student-feedback-portal-1.0-SNAPSHORT.war
            echo 'WAR deployed successfully'
        '''
    }
}
     }
}


