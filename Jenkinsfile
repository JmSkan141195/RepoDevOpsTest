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
                sh '''
                date
                '''
            } 
        }
		/*Try to build project*/
		stage('Building project') 
		{
            steps {
                git 'https://github.com/JmSkan141195/RepoDevOpsTest/tree/Spring_AOP/tpAchatProject.git'
				echo "-=- packaging project -=-"
                sh "./mvnw package"
            }
		}
    }
}
