pipeline 
{
    agent  any 
    tools  { 
        maven 'MAVEN_HOME'  
        
    } 
    
    environment{
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.24:8081/"
        NEXUS_REPOSITORY = "maven_releases"
        NEXUS_CREDENTIAL_ID = "nexus_user_credentials"
    }
 
    stages {
        stage('Getting project from git') {
            steps {
                echo 'Project is downloading ...'
                git branch:'youssefgaaieb',url:'https://github.com/JmSkan141195/RepoDevOpsTest.git'

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
                sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=. -Dsonar.host.url=http://192.168.1.23:9000 -Dsonar.projectKey=tn.esprit.spring -Dsonar.login=admin -Dsonar.password=NocturneOp32'
            }
    }
    
            stage('Unit Tests') {
        steps {
                echo 'Launching Unit Tests ...'
                sh 'mvn test'
            }
    }

    
    //nexus  
    
       stage('Publish to nexus') {
        steps {
                echo 'Nexus ...'
                sh 'mvn deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgenerationPom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases -Dfile=target/SpringProject-1.0.jar'
            }
    }
    
    
    
        
    }
}