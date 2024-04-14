pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/local/opt/openjdk@17/bin/java'
        PATH = "/usr/local/opt/openjdk@17/bin:${env.PATH}"
    }

    stages {
        stage('Install Dependencies') {
            steps {
                echo 'Installing dependencies...'
                sh 'brew update'
                sh 'brew install maven'
                sh 'brew install openjdk@17'
                sh 'npm install -g appium'
            }
        }
        stage('Repo Cloning') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', credentialsId: '8578b7c2-17bc-4a05-bfdf-cefe81539245', url: 'https://gitlab.com/somfyconnected/qa/qa-somfy/e2e_overkiz.git'
            }
        }
        stage('Start Appium Server') {
            steps {
                echo 'Starting Appium server...'
                sh 'appium &'
                sleep 10
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                echo 'Running Cucumber tests...'
                sh 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deployment steps here if needed
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            // Add cleanup steps here if needed
        }
    }
}
