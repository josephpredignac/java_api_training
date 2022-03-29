package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestForPing {
    @org.junit.jupiter.api.Test
    void PingCorect() throws IOException, InterruptedException {
        String[] arguments = {"9876"};
        Launcher.main(arguments);
        // TESTSUITE FOR PING
        URL u = new URL("http://localhost:9876/ping");
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");

        int s = c.getResponseCode();
        Assertions.assertEquals(s, 200, "HTTP IS NOT VALID");
        BufferedReader buff = new BufferedReader(
            new InputStreamReader(c.getInputStream()));

        StringBuilder content = new StringBuilder();
        String s1;
        while ((s1 = buff.readLine()) != null) {
            content.append(s1);
        }
        buff.close();
        // ASSERTION FINAL
        Assertions.assertEquals(content.toString(), "OK", "The message is not valid");
        // LET'S GO YOU DID IT
    }

    @org.junit.jupiter.api.Test
    void Pingwithoneargument() throws IOException, InterruptedException {
        String[] arguments = {};
        ;
        Assertions.assertThrows(NullPointerException.class, ()->Launcher.main(arguments), "Usage: Launcher [port]");
    }
}
