#!groovy
pipeline {

    agent any
    tools {
        maven 'MVN3'
    }
    stages {
        stage('Descargando código de SCM'){
            steps{
                sh 'rm -rf *'
                checkout scm
            }
        }


        stage('Building') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Analysis'){
            parallel{
                stage('Junit'){

                    steps{
                        sh 'mvn test'
                    }

                }

                stage('SonarQu'){
                    steps {
                        withSonarQubeEnv('SonarLocal') {
                            sh 'mvn clean package sonar:sonar'
                        }
\
                    }

                }
            }

        }

        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }


        stage('Deploy') {
            steps {
                sh 'mvn jboss-as:deploy'
            }
        }

        stage('Archivar') {
            steps {
                step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
            }
        }
    }
}