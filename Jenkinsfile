@Library('DevOps_Library@main') _
pipeline{
	agent any 
	stages{
		stage("Run Tests") {
			steps {
			    sh "echo SUCCESS on Main Branch"
			}
		}
		stage('Checkout') {
			steps{
				git branch: 'main', credentialsId: '715dda14-0514-487a-a5d3-924005ac5161', url: 'https://github.com/manojsubramaniam/jenkins_sharedLibrary02.git'
			}
		}
	}
 	post {
		always {
		    echo 'One way or another, I have finished'
		    deleteDir() /* clean up our workspace */
		}
		success {
		    echo 'I succeeded!'
		}
		unstable {
		    echo 'I am unstable :/'
		}
		failure {
		    echo 'I failed :('
		}
		changed {
		    echo 'Things were different before...'
		}
	}
}

					
