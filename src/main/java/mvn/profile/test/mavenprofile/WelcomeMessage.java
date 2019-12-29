package mvn.profile.test.mavenprofile;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
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
}
