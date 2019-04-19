#!groovy
// Function for building the Docker Image
// Executer function for any shell script
def mysh(cmd) {
    sh('#!/bin/sh -e\n' + cmd)
}
return this