#!groovy
pipeline {
    agent any
    options {
            skipDefaultCheckout()
    }
<<<<<<< HEAD
=======
    tools{
    maven 'maven-3'
    }
>>>>>>> ddfcc6e9684a399d2d4fc9da7496565f8e76a02b
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
        
<<<<<<< HEAD
   stage('Maven Installation'){
            steps{
                script{
            def toolsInstall = load "${env.WORKSPACE}/utilities/jenkins/toolsInstall.groovy"
            toolsInstall.toolsInstallation()
                }
            }
        }
=======
>>>>>>> ddfcc6e9684a399d2d4fc9da7496565f8e76a02b
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
            echo "Running test into ${env.WORKSPACE}"
            }
        }
        stage('Package'){
          steps{
            echo "Packaging source code into ${env.WORKSPACE}/target"
            }
        }
    }
    post{
        always{
            echo "I will say Hello everytime"
        }
    }
}