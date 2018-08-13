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
                        sh 'mvn clean compile'
                    }

                }

                stage('SonarQu'){

                    steps {
                        withSonarQubeEnv('SonarLocal') {
                            sh 'mvn clean package sonar:sonar'
                        }
\
                    }
                    post {
                        always {
                            timeout(time: 1, unit: 'MINUTES') {
                                qg = waitForQualityGate()
                                if (qg.status != 'OK') {
                                    error "Pipeline abortada debido a una falla en la calidad de codigo: ${qg.status}"
                                }
                            }
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