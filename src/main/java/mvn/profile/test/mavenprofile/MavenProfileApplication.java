package mvn.profile.test.mavenprofile;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class MavenProfileApplication implements CommandLineRunner {

    Logger logger;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MavenProfileApplication.class, args);
        context.getBean(SetupService.class).setupWelcomeMessage();
        context.getBean(WelcomeMessage.class).printMe();
    }

    @Override
    public void run(String... args) throws Exception {
        MavenProfileApplication app = new MavenProfileApplication();
        Properties prop = app.loadPropertiesFile("application.properties");
        prop.forEach((k, v) -> logger.info(k + ":" + v));
    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}