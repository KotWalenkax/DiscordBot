package EventPack;

import Connection.Conn;
import Model.Game;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EventListener extends ListenerAdapter {

    private MessageChannel channel = null;
    private String status = "null";
    private Message msgLast = null;

    //Список всех раздач
    private Game[] gameList = null;

    //Список для вывода
    private List<Game> games = null;
    private int count = 0;
    private boolean reactMode = false;

    String url = "https://www.gamerpower.com/api/giveaways";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        Message msg = event.getMessage();
        channel = event.getChannel();

        if (reactMode) {
            showChosenGame(msg);
        }

        if (msg.getContentDisplay().equals("-help")) {
            help();

        } else if (msg.getContentDisplay().contains("-game")) {
            gameListOne(msg);
        } else if (msg.getContentDisplay().contains("-all")) {
            gameListAll();
        }
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);

        User user = event.getUser();
        assert user != null;
        if (!user.isBot()) {
            System.out.println("Here is bot");
            System.out.println(event.getReaction().toString());
            if (event.getReaction().toString().toUpperCase(Locale.ROOT).contains("U+2B05") && count != 0) {
                System.out.println("Here <-");
                count = count - 10;
                gameListAll();
            } else if (event.getReaction().toString().toUpperCase(Locale.ROOT).contains("U+27A1")) {
                System.out.println("Here ->");
                count = count + 10;
                gameListAll();
            }

        }
    }

    private void help() {

        channel.sendMessage("Hello!").queue();

    }

    private void gameListOne(Message msg) {
        String gameName = msg.getContentDisplay().substring(6);
        channel.sendMessage(gameName.toLowerCase(Locale.ROOT)).queue();

        Game[] gameList = Conn.getInstance().findGame(url);
        List<Game> games = findGame(gameList, gameName);

        msgLast = channel.sendMessage(games.get(0).getTitle()).complete();
        channel.addReactionById(msgLast.getId(), "U+2B05").complete();
        channel.addReactionById(msgLast.getId(), "U+27A1").complete();

    }

    private void gameListAll() {
        reactMode = true;
        if (gameList == null) {
            gameList = Conn.getInstance().findGame(url);
        }
        allGames();
        String content = "Total: " + (gameList.length-1) + "\n\n" +
                "1. " + games.get(0).getTitle() + "\n" +
                "2. " + games.get(1).getTitle() + "\n" +
                "3. " + games.get(2).getTitle() + "\n" +
                "4. " + games.get(3).getTitle() + "\n" +
                "5. " + games.get(4).getTitle() + "\n" +
                "6. " + games.get(5).getTitle() + "\n" +
                "7. " + games.get(6).getTitle() + "\n" +
                "8. " + games.get(7).getTitle() + "\n" +
                "9. " + games.get(8).getTitle() + "\n" +
                "10. " + games.get(9).getTitle() + "\n";
        showGameList(content);
    }

    private List<Game> findGame(Game[] gameList, String gameName) {
        List<Game> games = new ArrayList<>();
        for (Game game : gameList) {
            if (game.getTitle().toLowerCase(Locale.ROOT).contains(gameName.toLowerCase(Locale.ROOT))) {
                games.add(game);
            }
        }
        return games;
    }

    //Создаем список для вывода в количестве 10-ти
    private void allGames() {
        games = new ArrayList<>(9);
        games.addAll(Arrays.asList(gameList).subList(count, 10 + count));
    }

    //Вывод сообщения
    private void showGameList(String content) {

        if (!status.equals("update")) {
            msgLast = channel.sendMessage(content).complete();
            status = "update";
        } else {
            msgLast = channel.editMessageById(msgLast.getId(), content).complete();
        }

        channel.addReactionById(msgLast.getId(), "U+2B05").complete();
        channel.addReactionById(msgLast.getId(), "U+27A1").complete();

    }

    private void showChosenGame(Message message) {
        Game game = games.get(Integer.parseInt(message.getContentDisplay())-1);
        channel.sendMessage("Status: " + game.getStatus()  + "\n" +
                            "Publish Date: " + game.getPublishedDate()  + "\n" +
                            "End Date: " + game.getEndDate() + "\n\n" +
                            game.getTitle() + "\n" +
                            game.getDescription() + "\n\n" +
                            game.getInstructions() + "\n\n" +
                            "Giveaway: " + game.getOpenGiveawayUrl()
                            ).complete();
        reactMode = false;
        status = "null";
    }

}
