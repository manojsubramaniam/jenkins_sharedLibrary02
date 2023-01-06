@Library('DevOps_Library@main') _
node
{

	stage('Source CheckOut')
    {
		SourceCheckout("https://github.com/mahendran-indiabees/Demo_DevOps.git","master","GitToken")
	}
	stage('Maven Build')
	{
		BuildMaven("clean install")
	}
	stage('Upload Artifact')
	{
		UploadArtifacts("war","target/Demo.war","demo","com.mydemo","nexus_cred","Build-Snapshots","${BUILD_NUMBER}-SNAPSHOT")
	}
	stage('Dev Deployment')
	{
		ConfirmMessage()
		TomcatDeploy("target\\Demo.war",'"C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps"')
	}	
}
