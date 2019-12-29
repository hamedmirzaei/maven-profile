package mvn.profile.test.mavenprofile;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    Logger logger;

    private String message;
    private String author;

    public WelcomeMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "WelcomeMessage{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void printMe() {
        logger.info(this.toString());
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
