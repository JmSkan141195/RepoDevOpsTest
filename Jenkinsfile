pipeline {
    agent any
	
    tools
	{
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
	}
	
    environment
    {
        PATH = "/usr/share/maven:$PATH"
	DOCKER_CREDS = credentials('dockerhub')
    }
	
    

    stages
    {
        stage ('Building ...')
		{
			steps
			{
			    echo 'Build Start ...'
			    sh "mvn clean install -DskipTests"
			}

			post
			{
				success
                		{
                    			echo 'Build Completed with Success ...'
				}
		    	}
		}

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
	    
	    
	    stage('Login to Docker Hub') 
	    {      	
    		steps
		    {                       	
			sh "docker login -u DOCKER_CREDS_USR -p DOCKER_CREDS_PSW"               		      
		    }
		    post
		    {
			    success
			    {
				    echo 'Docker Hub Login Completed !'
			    }
		    }
				    
	    }   
	    
	    
	    
	    stage ('Build Image - Docker')
	    {
		    steps
		    {
			   echo 'Starting build Docker image'
			   sh "docker build -t jouinimskander/springdevopsapp:1.0.SNAPSHOT ."
		    }
		    post
		    {
			    success
			    {
				    echo 'Image Build success !'
			    }
		    }
		    
		    
	    }
	    
	    stage ('Pushing Image - Docker')
	    {
		    steps
		    {
			   echo 'Starting push Docker image'
			    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub_credentials')]) 
			    {
				    sh "docker login -u jouinimskander -p ${dockerhub_credentials}"
			    }
			    sh "docker push jouinimskander/springappdevops" 
		    }
		    post
		    {
			    success
			    {
				    echo 'Image Pushed to Docker hub succeeded !'
			    }
		    }
		    
		    
		    
	    }
    }
}
