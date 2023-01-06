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
					
		stage("build docker image"){
		     	steps {	
				sh '''
					docker system prune -a --volumes -f
					docker build -t nginx/nodeapp_test:latest .
					docker run -d --name nginx123 -p 8000:80 nginx/nodeapp_test:latest
				'''
			}
		}

		stage("docker container"){
			steps {
				echo'running docker image into container..'
			}
		}
	}
}

					
