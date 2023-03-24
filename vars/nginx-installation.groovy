import hudson.tools.*

def installer = ToolInstaller.all().find { it.descriptor instanceof NginxInstallation.DescriptorImpl }
if (!installer) {
    def nginxHome = "/opt/nginx"
    def nginxUrl = "http://nginx.org/download/nginx-1.20.1.tar.gz"
    def nginxName = "nginx-1.20.1"
    def nginxDir = new File(nginxHome)
    
    if (!nginxDir.exists()) {
        nginxDir.mkdirs()
    }

    sh "curl -L ${nginxUrl} | tar xz -C ${nginxHome}"
    sh "cd ${nginxHome}/${nginxName} && ./configure && make && make install"
    
    ToolInstallation.convertToToolInstallation({
        def installations = Jenkins.getInstance().getDescriptorByName("hudson.plugins.nginx.NginxInstallation").getInstallations()
        def name = "Default"
        def home = nginxDir.getAbsolutePath()
        new NginxInstallation(name, home, [])
    } as ToolDescriptor, "Nginx 1.20.1")
}
