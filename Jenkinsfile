node{
   environment {
            def workspace = "${env.WORKSPACE}"
    }
   @Library('github.com/hemant-demo/jenkins-demo-lib') _
    stage('Standard Build'){
    standardBuild ([
    workspace:  '${env.workspace}',
    environment : 'golang:1.5.0',
    compile : '''
   mvn compile
''',
   test: '''
   mvn test
   ''',
   package: '''
   mvn package
   ''',
    postScript : '''
ls -l
'''
])	
}
stage('BuildCommitSha') {            
sh=buildCommitSha()
  }
}
