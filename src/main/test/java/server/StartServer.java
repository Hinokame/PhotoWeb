package server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class StartServer{
    final static String webappDirLocation = "src/main/webapp/";
    static String user = "hino";
    static String role = "manager-gui";
    static String pass = "hino";
    public static void main(String... args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               /* File file = new File("C:\\ANDRIUS\\INTELJ\\Server\\apache-tomcat-8.0.24\\conf\\tomcat-users.xml");
                Path path = file.toPath();
                FileHelper fileHelper = new FileHelper();
                fileHelper.lookForFile(path.toFile());
                */
                MainScreen mainScreen = new MainScreen();
                MainScreen.run();
            }
        });

        Tomcat tomcat = new Tomcat();

        tomcat.addUser(user, pass);
        tomcat.addRole(user, role);


        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8090"; // port
        }

        tomcat.setPort(Integer.valueOf(webPort));

        try {
            tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        tomcat.getServer().await();
    }
}