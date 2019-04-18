#!groovy
pipeline {
    agent any
    stages {
         stage('Checkout') {
            checkout scm
        }
        stage('Compile') {
            echo "Starting compiling the current source code from ${env.WORKSPACE}"
            
        }
        stage('Test') {
            echo "Running test into ${env.WORKSPACE}"
        }
        stage('Package'){
            echo "Packaging source code into ${env.WORKSPACE}/target"
        }
    }
}
