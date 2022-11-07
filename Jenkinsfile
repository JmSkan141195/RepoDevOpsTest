pipeline {
    agent  any 
    tools
        {
            maven 'M2_HOME'
        }
    environment{
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.33.10:8081/"
        NEXUS_REPOSITORY = "maven_releases"
        NEXUS_CREDENTIAL_ID = "nexus_user_credentials"
        dockerhub = credentials('dockerhub')
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
                sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=. -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.projectKey=tn.esprit.spring -Dsonar.login=admin -Dsonar.password=NocturneOp32'
            }
    }
    stage('nexus') {
        steps {
                echo 'Nexus ...'
                sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgenerationPom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases -Dfile=target/SpringProject-1.0.jar'
            }
    }
    stage('Login to Docker Hub') {
                steps
                {
                sh "docker login -u $dockerhub_USR -p $dockerhub_PSW"
                }
                post
                {
                    success
                    {
                        echo 'Docker Hub Login Completed !'
                    }
                }
        }
    stage ('Build Image - Docker'){
            steps
            {
               echo 'Starting build Docker image'
                sh "docker build -t youssefgb/springdevopsapp:1.0.SNAPSHOT ."
            }
            post
            {
                success
                {
                    echo 'Image Build success !'
                }
            }
        }

        stage ('Pushing Image - Docker'){
            steps
            {
                sh "docker push youssefgb/springdevopsapp"
            }
            post
            {
                success
                {
                    echo 'Image Pushed to Docker hub succeeded !'
                }
            }
        }
    }
}