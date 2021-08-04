package Connection;

import Model.Game;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class Conn {

    //private String url = "https://www.gamerpower.com/api/giveaway?id=417";

    private HttpClient client = HttpClient.newHttpClient();

    private static Conn conn;

    public static Conn getInstance() {
        if (conn == null) {
            conn = new Conn();
        }

        return conn;
    }

    private Conn(){}

    public Game getMethod(String url) {
        Game game = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
            assert response != null;
            game = new Gson().fromJson(response.body(), Game.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    public Game[] findGame(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
            assert response != null;
            Game[] gameList = new Gson().fromJson(response.body(), Game[].class);
            return gameList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
