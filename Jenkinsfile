   @Library('github.com/hemant-demo/jenkins-demo-lib') _
    standardBuild ([
       workspace:  '''
       echo ${WORKSPACE}''',
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
stage('Workspace') {            
sh=workspace()
  }
