#!groovy
pipeline {
    agent any
    stages {
         stage('Checkout') {
             steps{
            checkout scm
            }
         }
        stage('Compile') {
            steps{
            echo "Starting compiling the current source code from ${env.WORKSPACE}"
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
}
