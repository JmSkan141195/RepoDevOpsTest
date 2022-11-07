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

        stage('MVN SONARQUBE')
        {
            steps{

                sh "mvn sonar:sonar -Dsonar.login=da678e3bd5b193d0ef6c1b255a04816dd3b452a3"

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
                sh 'docker build -t dante7400/tpachatprojet:latest .'
            }
        }

        stage ('Push Image')
        {
            steps
            {
                sh 'docker login -u $dockerhub_USR -p $dockerhub_PSW'
		sh 'docker tag tpachatprojet dante7400/tpachatprojet:latest'
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
