import EventPack.EventListener;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException {

        JDABuilder jda = (JDABuilder) JDABuilder.createDefault("ODE1NjQ2NDI4MDM4NTYxODcz.YDvb7g.fiJBam3Pl8AGPMEE0EboztMbmVs")
                .addEventListeners(new EventListener())
                .build();

    }

}
