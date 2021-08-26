import EventPack.EventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.internal.JDAImpl;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createDefault("token")
                .addEventListeners(new EventListener())
                .build();

    }

}
