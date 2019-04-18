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
        stage('Compile') {
            steps{
                script{
            echo "Starting compiling the current source code from ${env.WORKSPACE}"
            def jenkinsHelper = load "${env.WORKSPACE}/utilities/jenkins/jenkinsHelper.groovy"
            def shellScript =  """
            cd ${env.WORKSPACE}
            mvn compile
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
