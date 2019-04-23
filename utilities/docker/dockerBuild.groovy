#!groovy
// Function for building the Docker Image
// Executer function for any shell script
def build(tag) {
    def shellScript="""
    echo Current tag to be build is: ${tag}
    sudo su - jenkins
    sudo docker build .
    """
    sh(script: '#!/bin/sh -e\n' + shellScript, returnStdout: true)
}
 // Build base image for running maven life cycle on the source code
def Imagebuild(){
    echo "Starting image building process from ${env.WORKSPACE}"
    branchName =  BuildBranchName()
    echo "Building branch: ${branchName}"
    def customImage = docker.build("base_image:${env.BUILD_ID}")
    return customImage
}

def BuildBranchName() {
    return env.BRANCH_NAME
}


return this