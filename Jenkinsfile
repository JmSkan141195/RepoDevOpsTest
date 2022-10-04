pipeline {
    agent any

    stages {
        stage('Detecting Git push') 
		{
            steps {
                echo 'Testing a Jenkinsfile...'
            }
		}
		
		stage('Running an Sh command')
		{
            steps 
			{
                sh './date'
            } 
        }
		
		stage('Building project') 
		{
            steps {
                git 'https://github.com/JmSkan141195/RepoDevOpsTest.git'
				sh './mvnw clean compile'
            }
		}
    }
}
