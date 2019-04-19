#!groovy
// Function for building the Docker Image
// Executer function for any shell script
def Build(cmd) {
   return sh(script: '#!/bin/sh -e\n' + cmd, returnStdout: true)
}
return this