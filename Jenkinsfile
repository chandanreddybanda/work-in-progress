pipeline {
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