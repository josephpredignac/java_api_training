package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public void handle(HttpExchange exchange) throws IOException {
        String b = String.format("OK");
        exchange.sendResponseHeaders(200, b.length());
        try (OutputStream os = exchange.getResponseBody()) {os.write(b.getBytes());}
    }

    public void beginServ(int p, String connection) throws IOException, InterruptedException {
        InetSocketAddress address = new InetSocketAddress(p);
        HttpServer serv = HttpServer.create(address, 0);
        serv.createContext("/ping", this::handle);
        ExecutorService exec = Executors.newFixedThreadPool(1);
        serv.setExecutor(exec);
        serv.start();
        ClientSide c = new ClientSide();
        c.begin(p, connection);
    }
}
