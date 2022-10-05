pipeline {
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
		/*Try to build project*/
		stage('Building project') 
		{
            steps {
            /*Get repo from github*/
                echo 'Getting repo from Github'
                git 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
				echo 'Run Maven Wrapper'
				sh "./mvnw -Dmaven.test.failure.ignore=true clean package"
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
