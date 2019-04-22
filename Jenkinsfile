#!groovy
pipeline {
    agent any
    options {
            skipDefaultCheckout()
    }
    tools{
    maven 'maven-3'
    git 'Default'
    }
    stages {        
        stage('Cleaning Up Workspace'){
        steps{    
            echo "Cleaning up ${WORKSPACE}"
            // clean up our workspace 
           deleteDir()
            // clean up tmp directory 
            dir("${workspace}@tmp") {
                deleteDir()            
                }   
            }    
        }
       stage('Checkout') {
             steps{
            checkout scm
            }
        }        
        stage('Maven Build') {
            steps{
                script{
                    docker= load "${env.WORKSPACE}/utilities/docker/dockerBuild.groovy"
                    jenkinsHelper= load "${env.WORKSPACE}/utilities/jenkins/jenkinsHelper.groovy"
                    def shellScript= "git rev-parse --short HEAD" // For fetching the commitID of the current branch
                    commitID=jenkinsHelper.commitID(shellScript) // Taking the commitID of the current git branch
                    echo "Info: Current build commit id is: ${commitID}"
                    String CommitID = commitID.trim(); // trimming the \n at the end of string
                    def shellscript= """
                    echo Building commitID $CommitID
                    echo env.BRANCH_NAME
                    mvn clean package
                    """
                    jenkinsHelper.mysh(shellScript)
                }
            }
        }
        stage('Test') {
            steps{
             script{
            echo "Starting testing the current source code from ${env.WORKSPACE}"
            def jenkinsHelper = load "${env.WORKSPACE}/utilities/jenkins/jenkinsHelper.groovy"
            def shellScript =  """
            cd ${env.WORKSPACE}
            mvn test
            """    
            jenkinsHelper.mysh(shellScript)
                }
            }
        }
        stage('Package'){
          steps{
             script{
            echo "Starting packaging the current source code from ${env.WORKSPACE}"
            def jenkinsHelper = load "${env.WORKSPACE}/utilities/jenkins/jenkinsHelper.groovy"
            def shellScript =  """
            cd ${env.WORKSPACE}
            mvn package
            """    
            jenkinsHelper.mysh(shellScript)
            }
        }
        }
    }
    post{
        always{
            echo "I will say Hello everytime"
        }
    }
}
