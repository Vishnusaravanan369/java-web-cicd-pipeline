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
	   stage('copi the WAR file') {
		steps {
		   sh '''
		        cp target/student-feedback-portal-1.0-SNAPSHOT.war /opt/tomcat/webapps/
			echo 'copied WAR file'
		      '''
		      }
	}
     }
}


