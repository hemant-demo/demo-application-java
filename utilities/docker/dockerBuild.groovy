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
return this