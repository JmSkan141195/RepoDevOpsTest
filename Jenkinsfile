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
	stage ('MVN Clean')
	    {
		    steps
		    {
			    echo 'Git project recovered with success !'
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
	    stage ('MVN Compile')
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
	    stage ('SonarQube Code Quality Check')
	    {
		    steps
		    {
			    script
			    {
				    withSonarQubeEnv('SonarQubeServer')
				    {
					    sh "mvn sonar:sonar"
					    jacoco()
				    }
			    }
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
	 
	stage ('Unit Tests ...')
		{
		    steps
		    {
		        echo 'Unit Tests Start ...'
		        sh "mvn test"
			    echo 'nothing to do yet'
		    }

		    post
		    {
		        success
		        {
		            echo 'Unit Tests Complete ...'
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
			   sh "docker push jouinimskander/springdevopsapp" 
		    }
		    post
		    {
			    success
			    {
				    echo 'Image Pushed to Docker hub succeeded !'
			    }
		    } 
	    }
	    stage ('Nexus Deploy')
	    {
		    steps
		    {
			   echo 'Starting deployment on Nexus Server'
			    sh "mvn deploy" 
		    }
		    post
		    {
			    success
			    {
				    echo 'Deployment succeeded !'
			    }
		    } 
	    }
	    
	    
    }
}
