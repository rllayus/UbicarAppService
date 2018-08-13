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
                    agent{
                        label "JUnit"
                    }
                    steps{
                        sh 'mvn clean compile'
                    }
                    post {
                        always {
                            junit 'reports/**/*.xml'
                        }
                    }
                }

                stage('SonarQu'){
                    agent{
                        label "SonarQu"
                    }
                    steps {
                        withSonarQubeEnv('SonarLocal') {
                            sh 'mvn clean package sonar:sonar'
                        }
\
                    }
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
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