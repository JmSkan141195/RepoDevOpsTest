pipeline {
    environment
    {
        PATH = "/usr/share/maven:$PATH"
    }
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

		stage ('Git Checkout ...')
		{
			steps
			{
			    git branch: 'Spring_AOP', credentialsId: '0112be30-3fe0-41ee-b428-59aac588feaa', url: 'https://github.com/JmSkan141195/RepoDevOpsTest'
			     echo 'Checkout Complete ...'
			}
		}

		stage ('Unit Tests ...')
		{
		    steps
		    {
		        sh "mvn test"
		    }

		    post
		    {
		        success
		        {
		            echo 'Test Complete ...'
		        }
		    }
		}

		stage ('Building ...')
		{
			steps
			{
			    sh "mvn clean package"
			}

			post
			{
                success
                {
                    echo 'Build Succeded ...'
                }
		    }
		}
    }
}
