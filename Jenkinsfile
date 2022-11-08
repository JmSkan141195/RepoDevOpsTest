pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
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
        stage('Download') {
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
        stage('SonarQube')
        {
            steps{
                echo 'Sonar check'
                sh "mvn sonar:sonar -Dsonar.login=aeacb699c1f339cd5ebcf85085653179788baab5"

            }
        }
        stage('Nexus') {
        steps {
                echo 'Nexus ...'
                sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgenerationPom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases -Dfile=target/tpAchatProject-1.0.jar'
            }
                        }
    stage('Docker Login') {
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
        stage ('Docker Build'){
            steps
            {
               echo 'Starting build Docker image'
                sh "docker build -t mouhebsliti36/devopsapp:1.0.SNAPSHOT ."
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
                sh "docker push mouhebsliti36/devopsapp"
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