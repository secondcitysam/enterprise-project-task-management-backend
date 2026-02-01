pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3'
    }

    options {
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat '''
                mvn clean package ^
                -DskipTests ^
                -Dmaven.repo.local=%WORKSPACE%\\.m2 ^
                -Dmaven.artifact.threads=1 ^
                --no-transfer-progress
                '''
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
