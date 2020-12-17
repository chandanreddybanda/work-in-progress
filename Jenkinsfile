pipeline {
	agent any
	tools {
		//hhoi
     		 maven 'M3'
  	 }
	triggers {
        pollSCM '* * * * *'
    }
	    stages {
		stage('Build') {
		    steps {
			bat 'cd learning-works && mvn spring-boot:run'
		    }
		}
	    }
}
