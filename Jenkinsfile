node{
   @Library('github.com/hemant-demo/jenkins-demo-lib') _
    stage('Standard Build'){
    standardBuild ([
    environment : 'golang:1.5.0',
    mainScript : '''
echo Test
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
