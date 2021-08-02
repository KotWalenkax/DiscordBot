package EventPack;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    String url = "https://api.rawg.io/api/stores?key=9c6a31b0167444af98d50243c01ef21a";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equals("-hello")) {
            System.out.println(event.getMessage().getContentDisplay());
            MessageChannel channel = event.getChannel();
            channel.sendMessage("I`am alive").queue();
        }
    }
}
