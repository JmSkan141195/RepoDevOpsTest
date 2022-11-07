pipeline {
    agent 
    
    environment{
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.24:8081/"
        NEXUS_REPOSITORY = "maven_releases"
        NEXUS_CREDENTIAL_ID = "nexus_user_credentials"
    }
    stages {
        stage('Download project') {
            steps {
                echo 'Pulling code from Git'
                git branch: 'youssefgaaieb', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }
        
        stage('Artifact construction') {
        steps {
                echo 'Artifact construction ...'
                sh 'mvn clean install -DskipTests'
            }
    }
    stage('sonarqube') {
        steps {
                echo 'Sonar check ...'
                sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=. -Dsonar.host.url=http://192.168.1.24:9000 -Dsonar.projectKey=tn.esprit.spring -Dsonar.login=admin -Dsonar.password=NocturneOp32'
            }
    }
    }
}