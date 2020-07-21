package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.net.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server
{


    // constructor with port


    public static void main(String args[]) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(new MyHttpHandler());
        server.start();
    }
} 