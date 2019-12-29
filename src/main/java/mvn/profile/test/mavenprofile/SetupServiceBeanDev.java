package mvn.profile.test.mavenprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
public class SetupServiceBeanDev implements SetupService {

    private WelcomeMessage welcomeMessage;

    @Autowired
    public SetupServiceBeanDev(WelcomeMessage welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @Override
    public void setupWelcomeMessage() {
        welcomeMessage.setMessage("Hello From Dev");
        welcomeMessage.setAuthor("Developer");
    }
}
