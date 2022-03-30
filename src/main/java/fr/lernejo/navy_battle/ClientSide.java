package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class ClientSide {
    public void begin(int p, String connectionURL) throws IOException {
        HttpClient client = HttpClient.newBuilder()
            .build();
        if(connectionURL != null) {
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create(connectionURL + "/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + p + "\", \"msg\":\"Comment ça va ce sooooiiiir ?\"}"))
                .build();
        }
    }
}
