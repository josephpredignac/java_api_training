package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.OutputStream;

public class Launcher {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Mauvaise utilisation du launcher");
                throw new NullPointerException("Usage: Launcher [port]");
            }
            int p = Integer.parseInt(args[0]);
            System.out.println("Listening on port "  + p);

            new Server().beginServ(p, args.length > 1 ? args[1] : null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
