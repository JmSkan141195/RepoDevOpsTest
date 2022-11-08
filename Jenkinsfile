pipeline {
	
    agent any
	
    tools
	{
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
	}
    
    environment
    {
        dockerhub = credentials('omar-dockerhub')
    }

    stages
    {

        stage('GIT Checkout') 
        {
            steps 
            {
                echo 'Pulling code from Git'
                git branch: 'OmarNaffeti', 
                url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
            }
        }

        stage ('Clean')
        {
            steps
            {
                echo 'Cleaning'
                sh "mvn clean"
            }
            post
            {
                success
                    {
                        echo 'Clean Completed with Success ...'
                }
            }
        }

        stage ('Compile')
        {
            steps
            {
                echo 'Compiling'
                sh "mvn compile"
            }
            post
            {
                success
                {
                    echo 'Compilation Completed with Success ...'
                }
            }
            
        }

        stage('SONARQUBE test')
        {
            steps{

                sh "mvn sonar:sonar -Dsonar.login=f47c00d574efbc98d8c75c1a1fefd3c289907dc0"

            }
        }
	    
	stage('Tests unitaires') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage ('Building ...')
        {
            steps
            {
                echo 'Build Start ...'
                sh "mvn package -Dmaven.main.skip -DskipTests"
            }

            post
            {
                success
                {
                    echo 'Build Completed with Success ...'
                }
            }
        }

        stage ('Build Image Docker')
        {
            steps
            {
		sh 'sudo su'
		sh 'docker login -u $dockerhub_USR -p $dockerhub_PSW'
                sh 'docker build -t dante7400/tpachatprojet:latest .'
            }
        }

        stage ('Push Image')
        {
            steps
            {
		sh 'docker tag a45a54d0585d dante7400/tpachatprojet:latest'
                sh 'docker push dante7400/tpachatprojet:latest'
            }
            post
            {
                always{
                    sh 'docker logout'
                }
            }
        }

    }
}
