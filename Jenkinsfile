pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Docker Build & Run') {
            steps {
                bat 'docker compose down -v'
                bat 'docker compose up --build -d'
            }
        }
    }
}
