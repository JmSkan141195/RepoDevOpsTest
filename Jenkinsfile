pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }
    stages {
        stage('GIT') {
            steps {
                echo 'Pulling code from Git'
                git branch: 'MouhebSliti', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }
        stage('Building') {
            steps {
                echo 'Building with Maven'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('MVN SONARQUBE')
        {
            steps{
                echo 'Building with Maven'
                sh "mvn sonar:sonar -Dsonar.login=aeacb699c1f339cd5ebcf85085653179788baab5"

            }
        }
    }
}
