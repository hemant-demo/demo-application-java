node{
   @Library('github.com/hemant-demo/jenkins-demo-lib') _
    stage('Standard Build'){
    standardBuild ([
    environment : 'golang:1.5.0',
    compile : '''
   mvn compile
''',
   test: '''
   mvn test
   ''',
    postScript : '''
ls -l
'''
])	
stage('BuildCommitSha') {            
sh=buildCommitSha()
  }
}
}
