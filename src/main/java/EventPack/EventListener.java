package EventPack;

import Connection.Conn;
import Model.Example;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    String url = "https://www.gamerpower.com/api/giveaway?id=417";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equals("-hello")) {
            System.out.println(event.getMessage().getContentDisplay());
            MessageChannel channel = event.getChannel();

            Example example = Conn.getInstance().getMethod(url);

            channel.sendMessage(example.getDescription()).queue();
        }
    }
}
