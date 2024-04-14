pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    echo 'Installing dependencies...'
                    // Maven ve Java'yı yükle
                    sh 'brew update'
                    sh 'brew install maven'
                    sh 'brew install openjdk@8'
                    sh 'npm install -g appium' // Appium'un kurulumu (Node.js gerektirir)
                }
            }
        }
        stage('Repo Cloning') {
            steps {
                script {
                    echo 'Cloning repository...'
                    git branch: 'main', credentialsId: 'e4c9fc0d-345b-4e30-922c-6adfe86b6541', url: 'https://github.com/hakantetik44/e2e_BedrockCucumber.git'
                }
            }
        }

        stage('Start Appium Server') {
            steps {
                script {
                    echo 'Starting Appium server...'
                    sh 'appium &' // Appium sunucusunu arka planda başlat
                    sleep 10 // Appium sunucusunun başlaması için biraz bekleyin
                }
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                script {
                    echo 'Running Cucumber tests...'
                    sh 'mvn test' // Cucumber senaryolarını çalıştır
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...' // Deploy işlemleri buraya eklenebilir
                }
            }
        }
    }

    post {
        always {
            script {
                echo 'Cleaning up...'
                // Temizlik işlemleri buraya eklenebilir
            }
        }
    }
}
