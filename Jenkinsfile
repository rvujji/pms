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
                sh "cd pmp"
				sh "mvn clean install -DskipTests"
			}
		}
 }
}