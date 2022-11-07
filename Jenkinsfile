pipeline {
    agent any
    stages {
        stage('GIT Checkout') {
            steps {
                echo 'Pulling code from Git'
                git branch: 'youssefgaaieb', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Cleaning project ...'
                sh 'mvn clean'
                echo 'Maven version'
                sh 'mvn -version'
            }
        }
    }
}