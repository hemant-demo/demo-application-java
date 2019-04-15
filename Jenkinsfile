@Library('github.com/hemant-demo/jenkins-demo-lib') _
standardBuild ([
    environment : 'golang:1.5.0',
    mainScript : '''
echo Test
''',
    postScript : '''
ls -l
'''
])	
buildCommitSha.call()
