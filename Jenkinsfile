#!groovy
pipeline {
    agent any
    options {
            skipDefaultCheckout()
    }
    stages {
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
