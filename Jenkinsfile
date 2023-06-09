pipeline {
 agent any
 environment {
  mavenHome = tool 'maven'
 }
 tools {
  jdk 'openjdk-11'
 }
 stages {
  stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}
  stage('Sonarqube') {
                environment {
                    scannerHome = tool 'SonarQubeScanner'
                }
                steps {
                    withSonarQubeEnv('sonarqube') {
                    bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-pms -Dsonar.host.url=http://35.244.27.133:9000/sonar -Dsonar.login=81bf54f137f4b2ae58fd62055a2285b343549900"
                }
		}			
 }
}