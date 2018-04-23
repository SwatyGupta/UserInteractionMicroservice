pipeline {
    agent any
	

    stages {

        stage ('Workspace refresh for') {
            steps {
                git 'https://github.com/SwatyGupta/UserInteractionMicroservice'
            }
        }

        stage ('Compile') {
          steps {
            sh 'mvn clean compile'
          }
        }

        stage ('Test') {
          steps{
            sh 'mvn test'
          }
        }

        stage ('Package') {
          steps{
            sh 'mvn package -Dmaven.test.skip=true'
          }
        }

    }
}