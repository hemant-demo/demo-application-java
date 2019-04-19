#!groovy
// Function for building the Docker Image
def dockerBuild(tag){
    def shellScript="""
    docker build -t ${tag} .
    """
   mysh(shellScript)
}

// Executer function for any shell script
def mysh(cmd) {
     sh('#!/bin/sh -e\n' + cmd)
}