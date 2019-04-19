#!groovy
// Function for building the Docker Image
// Executer function for any shell script
def mysh(cmd) {
   return sh(script: '#!/bin/sh -e\n' + cmd, returnStdout: true)
}
return this