#!groovy
// Function for building the Docker Image
// Executer function for any shell script
def Build(tag) {
    def shellscript="""
    docker build -t ${tag} .
    """
   return sh(script: '#!/bin/sh -e\n' + shellscript, returnStdout: true)
}
return this