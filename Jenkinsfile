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
        stage('Maven Standard Build') {
            steps{
                script{
                    docker= load "${env.WORKSPACE}/utilities/docker/dockerBuild.groovy"
                    jenkinsHelper= load "${env.WORKSPACE}/utilities/jenkins/jenkinsHelper.groovy"
                    def shellScript= "git rev-parse --short HEAD" // For fetching the commitID of the current branch
                    commitID=jenkinsHelper.commitID(shellScript) // Taking the commitID of the current git branch
                    echo "Debug: Current build commit id is: ${commitID}"
                    String CommitID = commitID.trim(); // trimming the \n at the end of string
                    jenkinsHelper.standardBuild(CommitID,env.BRANCH_NAME)
                    
                }
            }
        }
        stage("Creating Docker Image"){
            steps{
                script{
                    dockerbuild= load "${env.WORKSPACE}/utilities/docker/dockerBuild.groovy"
                    print "heeeeeelloooooooo"
                    print "${env.WORKSPACE}"
                    sh """
                    cd ${env.WORKSPACE}/utilities/docker
                    ls -ltrh
                    """
                    dockerbuild.Imagebuild()
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
