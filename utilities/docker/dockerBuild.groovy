#!groovy
// Function for building the Docker Image
// Executer function for any shell script

// Build base image
def Imagebuild(){
    echo "Starting image building process from ${env.WORKSPACE}"
    branchName =  BuildBranchName()
    echo "Building branch: ${branchName}"
    docker.build("base_image:${env.BUILD_ID}")
}

def BuildBranchName() {
    return env.BRANCH_NAME
}


return this