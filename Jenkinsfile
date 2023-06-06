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
				sh "mvn clean install -DskipTests"
			}
		}
 }
}