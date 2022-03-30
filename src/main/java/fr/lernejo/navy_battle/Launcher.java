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
            if (args.length == 2) {
                new Server().beginServ(p, args[1]);
            }
            else {
                new Server().beginServ(p, null);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
