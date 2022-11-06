pipeline 
{
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
        stage ('Building project')
		{
			steps
			{
			    echo 'Git project recovered with success !'
			    echo 'Build Started'
			    sh "mvn clean package -DskipTests"
			}

			post
			{
				success
                		{
                    			echo 'Build Completed with Success'
				}
		    	}
		}
	 
	stage ('Unit Tests - JUnit')
		{
		    steps
		    {
		        echo 'Unit Tests Started'
		        sh "mvn test"
		    }

		    post
		    {
		        success
		        {
		            echo 'Unit Tests Completed with success'
		        }
		    }
		}
	    
	    
	    stage('Docker (Image Build + Push') 
	    {      	
    		steps
		    {
			    step('Docker Login')
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
			    step('Build Image - Docker')
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
			    step('Pushing Image - Docker')
			    {
				 echo 'Starting push Docker image'
				 withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhub_pwd', usernameVariable: 'dockerhub_usr')]) 
				    {
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
		    }   
	    }
    }
}
