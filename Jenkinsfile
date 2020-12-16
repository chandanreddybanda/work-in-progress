pipeline {
	agent any
	tools {
     		 maven 'M3'
  	 }
	    stages {
		stage('Build') {
		    steps {
			bat 'cd learning-works && mvn spring-boot:run'
		    }
		}
	    }
}
