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


        stage('Building') {
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
                        withSonarQubeEnv('SonarQube') {
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
                sh 'mvn jboss:deploy -Djboss-hostname=${env.SERVER_DEV_SFE_HOSTNAME} -Djboss-port=${env.SERVER_DEV_SFE_PORT_ADMIN} -Djboss-username=${env.SERVER_DEV_SFE_CREDENTIAL_USR} -Djboss-password=${env.SERVER_DEV_SFE_CREDENTIAL_PSW}'
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
                mail to: 'rlaredo@mc4.com.bo', cc: "rchipana@mc4.com.bo, fmontero@mc4.com.bo", charset: "UTF-8",
                        subject: ": ${currentBuild.fullDisplayName}  : ${env.PROJECT_NAME} - Build# ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}",
                        body: "Se genero un error al ejecutor de tareas de jenkins. ${env.BUILD_URL}"
            }
    
            success {
                mail to: 'rlaredo@mc4.com.bo', cc: "rchipana@mc4.com.bo, fmontero@mc4.com.bo", charset: "UTF-8",
                        subject: " ${currentBuild.fullDisplayName} :  ${env.PROJECT_NAME} - Build# ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}",
                        body: "La aplicación se ejecutó exitosamente" +
                                "" +
                                " ${env.BUILD_URL}"
            }

        }
}
