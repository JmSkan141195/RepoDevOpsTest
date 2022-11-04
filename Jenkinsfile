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
	dockerhub = credentials('dockerhub')
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
			sh "docker login -u $dockerhub_USR -p $dockerhub_PSW"               		      
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
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhub_pwd', usernameVariable: 'dockerhub_usr')]) 
			    {
				    sh "docker login -u $dockerhub_USR -p $dockerhub_PSW"
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
