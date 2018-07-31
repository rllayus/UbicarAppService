#!groovy

node {
   // ------------------------------------
   // -- ETAPA: Compilar
   // ------------------------------------
   stage 'Compilar'

   // -- Configura variables
   echo 'Configurando variables'
   def mvnHome = tool 'MVN3'
   env.PATH = "${mvnHome}/bin:${env.PATH}"
   echo "var mvnHome='${mvnHome}'"
   echo "var env.PATH='${env.PATH}'"

   // -- Descarga código desde SCM
   echo 'Descargando código de SCM'
   sh 'rm -rf *'
   checkout scm

   // -- Compilando
   echo 'Compilando aplicación'
   sh 'mvn clean compile'


//
   // ------------------------------------
   // -- ETAPA: Test
   // ------------------------------------

stage("SonarQube") {
        steps {
            script {
                try {
                    echo "Analizing the project with SonarQube."
                    withSonarQubeEnv("Sonar Server") {
                        sh "mvn sonar:sonar"
                    }
                } catch (err) {
                    echo "The SonarQube analysis failed"
                }
            }
        }
    }

   // ----------------------------------------------------------------------------------------
   // -- ETAPA: Instalar
   // -------------------------------------------------------------------------------------------
   stage 'Instalar'
   echo 'Instala el paquete generado en el repositorio maven'
   sh 'mvn install -Dmaven.test.skip=true'

   // ------------------------------------
   // -- ETAPA: Archivar
   // ------------------------------------
   stage 'Archivar'
   echo 'Archiva el paquete el paquete generado en Jenkins'
   step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
}