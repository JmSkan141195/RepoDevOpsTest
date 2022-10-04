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
				echo "-=- packaging project -=-"
                sh "./mvnw package"
            }
		}
    }
}
