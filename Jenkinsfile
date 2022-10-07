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
        stage('Git Push')
		{
		/*
		Nothing to do here as we already configured this in Jenkins
		Poll SCM --> Ticked
		*/
            steps {
                echo 'Running the Jenkinsfile...'
            }
		}

        stage ('Building ...')
		{
			steps
			{
			    echo 'Build Start ...'
			    sh "mvn clean package"
			}

			post
			{
                success
                {
                    echo 'Build Completed with Success ...'
                }
		    }
		}

		/*stage('Running an Sh command')
		{
            steps
			{
                sh '''
                date
                '''
            }
        }*/

		stage ('Git Checkout ...')
		{
			steps
			{
			    echo 'Checkout Start ...'
			    git branch: 'Spring_AOP', credentialsId: '0112be30-3fe0-41ee-b428-59aac588feaa', url: 'https://github.com/JmSkan141195/RepoDevOpsTest'
			    echo 'Checkout Complete ...'
			}
		}

		stage ('Unit Tests ...')
		{
		    steps
		    {
		        echo 'Unit Tests Start ...'
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
        			    echo 'Build Start ...'
        			    sh "mvn clean package install"
        			}

        			post
        			{
                        success
                        {
                            echo 'Build Completed with Success ...'
                        }
        		    }
        		}
    }
}
