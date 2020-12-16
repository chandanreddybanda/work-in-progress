pipeline {
	agent any
	tools {
     		 // Install the Maven version configured as "M3" and add it to the path.
      		maven 'M3'
  	 }
	    stages {
		stage('cd ing') {
		    steps {
			bat 'cd learning-works'
		    }
		}
		stage('Build') {
		    steps {
			bat 'mvn spring-boot:run'
		    }
		}
	    }
}
