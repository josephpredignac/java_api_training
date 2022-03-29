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
    final HttpHandler pRespond = new HttpHandler() {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String b = String.format("OK");
            exchange.sendResponseHeaders(200, b.length());
            try (OutputStream os = exchange.getResponseBody()) {os.write(b.getBytes());}
        }
    };

    public void beginServ(int p, String connectionURL) throws IOException {
        InetSocketAddress address = new InetSocketAddress(p);
        HttpServer serv = HttpServer.create(address, 0);
        ExecutorService exec = Executors.newFixedThreadPool(1);
        serv.setExecutor(exec);
        serv.createContext("/ping", this.pRespond);
        serv.start();
    }
}
