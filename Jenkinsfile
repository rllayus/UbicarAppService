#!groovy
pipeline {
    agent any
    stages {
        stage('Descargando código de SCM'){
            echo 'Descargando código de SCM'
            steps{
                sh 'rm -rf *'
                checkout scm
            }
        }


        stage('Building') {
            echo 'Compilando '
            steps {
                sh 'code/referred-client'
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
                    step {
                        withSonarQubeEnv('SonarLocal') {
                            sh 'mvn clean package sonar:sonar'
                        }
                    }

                    step{
                        timeout(time: 1, unit: 'MINUTES') {
                            def qg = waitForQualityGate()
                            if (qg.status != 'OK') {
                                error "Pipeline abortada debido a una falla en la calidad de codigo: ${qg.status}"
                            }
                        }
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