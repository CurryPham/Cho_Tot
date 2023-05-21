pipeline {
  agent any
  stages {
    stage('Build Source') {
      steps {
        sh '''mvn clean
'''
      }
    }

    stage('Run Chrome') {
      parallel {
        stage('Run Chrome') {
          steps {
            bat 'mvn test -DBROWSER=chrome verify'
          }
        }

        stage('Run Fixfox') {
          steps {
            bat 'mvn test -DBROWSER=firefox verify'
          }
        }

        stage('Run Edge') {
          steps {
            bat 'mvn test -DBROWSER=edge verify'
          }
        }

        stage('Run Headless Chrome') {
          steps {
            bat 'mvn test -DBROWSER=hchrome verify'
          }
        }

        stage('Run Healess Firefox') {
          steps {
            bat 'mvn test -DBROWSER=hfirefox verify'
          }
        }

      }
    }

  }
}