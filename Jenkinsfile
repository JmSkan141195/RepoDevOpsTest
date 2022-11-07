pipeline {
	
    agent any
	
    tools
	{
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
	}

    stages
    {
    stage('GIT Checkout') {
            steps {
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
	 
	
	    
	    
    }
}