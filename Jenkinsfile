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
	   stage('junit test') {
		steps {
		   sh 'mvn test'
		      }
	}
	   stage ('public test report') {
		steps {
		   junit 'target/surefire-reports/*.xml'
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
	     set -e
             cp target/student-feedback-portal-1.0-SNAPSHORT.war /opt/tomcat/webapps/
            echo 'WAR deployed successfully'
        '''
 		      }
	}
	   stage('Application Health Check') {
       		steps {
		    sh '''
			 set -e
			 echo "checking application health..."
			 sleep 5
			 curl -f http://192.168.198.131:8083/student-feedback-portal-1.0-SNAPSHORT/feedback
			 echo "Application health check passed!"
			'''
		      }
	} 

}
}


