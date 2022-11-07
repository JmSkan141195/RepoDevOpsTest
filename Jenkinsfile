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
                git branch: 'OmarNaffeti', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }
        stage('Building JAR') {
            steps {
                echo 'Building with Maven'
                sh 'mvn dependency:purge-local-repository'
                sh 'mvn clean install -DskipTests'
            }
        }
    }
}
