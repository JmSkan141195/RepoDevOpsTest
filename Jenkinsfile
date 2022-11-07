pipeline 
{
    agent  any 
    tools  { 
        maven 'M2_HOME'  
        
    } 
    
 
    stages {
        stage('Getting project from git') {
            steps {
                echo 'Project is downloading ...'
                git branch:'youssefgaaieb',url:'https://github.com/JmSkan141195/RepoDevOpsTest.git'

            }

        stage('test')  {
            steps{
                 echo 'hello '   
            }
        }  
    }

    }
        
}
