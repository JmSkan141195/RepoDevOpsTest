pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }
    stages {
        stage('GIT Checkout') {
            steps {
                echo 'Pulling code from Git'
                git branch: 'medwassimhabibi', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }
        stage('Building JAR') {
            steps {
                echo 'Building with Maven'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('SonarQube') {
            steps {
                echo 'SonarQube'
                sh 'mvn sonar:sonar -Dsonar.login=8201febc1c220f337223156baef397799143a4fb'
            }
        }
    }
}