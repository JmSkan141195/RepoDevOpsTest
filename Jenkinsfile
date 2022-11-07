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
        stage('Cleaning the project') {
            steps {
                echo 'Cleaning project ...'
                sh 'mvn clean'
                echo 'Maven version'
                sh 'mvn -version'
            }
        }
        stage('Artifact construction') {
        steps {
                echo 'Artifact construction ...'
                sh 'mvn package'
            }
    }
    stage('Code quality check via sonarqube') {
        steps {
                echo 'Sonar check ...'
                sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=. -Dsonar.host.url=http://192.168.1.24:9000 -Dsonar.projectKey=tn.esprit.spring -Dsonar.login=admin -Dsonar.password=NocturneOp32'
            }
    }
    }
}