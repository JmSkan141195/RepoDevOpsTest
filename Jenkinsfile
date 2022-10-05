pipeline {
	tools 
	{						
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
	}
    agent any

    stages {
        stage('Detecting Git push') 
		{
		/*
		Nothing to do here as we already configured this in Jenkins
		Poll SCM --> Ticked
		*/
            steps {
                echo 'Testing a Jenkinsfile...'
            }
		}
		
		stage('Running an Sh command')
		{
            steps 
			{
                sh '''
                date
                '''
            } 
        }
		
		stage ('Git Checkout') 
		{
			steps 
			{
				git branch: 'Sring_AOP', url: 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
			}
		}
		
		/*Try to build project*/
		stage('Building project') 
		{
            steps {
				echo 'Run Maven Wrapper'
				sh '''
				mvn -Dmaven.test.failure.ignore=true clean package
				'''
            }

            post
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
		}
    }
}
