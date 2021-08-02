package Connection;

import Model.Example;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public Example getMethod(String url) {
        Example example = null;
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
            example = new Gson().fromJson(response.body(), Example.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return example;
    }

}
