pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t todo-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker stop todo-app || true'
                sh 'docker rm todo-app || true'
                sh 'docker run -d -p 8081:8080 --name todo-app todo-app'
            }
        }
    }
}

