#!groovy
pipeline {

    agent any
    tools {
        maven 'MVN3'
    }
    stages {
        stage('Descargando código de SCM') {
            steps {
                sh 'rm -rf *'
                checkout scm
            }
        }


        stage("Building") {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Analysis') {
            parallel {
                stage('Junit') {

                    steps {
                        sh 'mvn test'
                    }

                }

                stage('SonarQu') {
                    steps {
                        withSonarQubeEnv('SonarLocal') {
                            sh 'mvn clean package sonar:sonar'
                        }
                    }

                }
            }

        }


        stage("Quality Gate") {
            when {
                branch 'master'  //only run these steps on the master branch
            }
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }

        }


        stage('Deploy') {
            steps {
                sh 'mvn wildfly:deploy'
            }
        }

        stage('Archivar') {
            steps {
                step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
            }
        }


    }
    post {
        failure {
            mail to: 'rllayus@gmail.com',cc:"rlaredo@mc4.com.bo,mquispe@mc4.com.bo",charset: "UTF-8",
                    subject: ": ${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}"
        }

        success{
            mail to: 'rllayus@gmail.com',cc:"rlaredo@mc4.com.bo,mquispe@mc4.com.bo",charset: "UTF-8",
                    subject: ": ${currentBuild.fullDisplayName}",
                    body: "La aplicación se ejecuto exitosamente ${env.BUILD_URL}"
        }

    }
}