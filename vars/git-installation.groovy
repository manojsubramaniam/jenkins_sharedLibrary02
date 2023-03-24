def call() {
    sh 'apt-get update'
    sh 'apt-get install -y git'
    sh 'git --version'
}
