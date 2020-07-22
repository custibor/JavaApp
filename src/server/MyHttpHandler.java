package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class MyHttpHandler implements HttpHandler {

    private Object StringEscapeUtils;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParamValue=null;
        System.out.println(httpExchange.getRequestMethod());
        if("GET".equals(httpExchange.getRequestMethod())) {
            System.out.println("GET START");
            requestParamValue = handleGetRequest(httpExchange);
            System.out.println("GET DONE");
        }
        else if("POST".equals(httpExchange.getRequestMethod())) {
            requestParamValue = handlePostRequest(httpExchange);
        }
        handleResponse(httpExchange,requestParamValue);
    }

    private String handlePostRequest(HttpExchange httpExchange) {
        return "None";
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        return "fun";
        /*httpExchange.
        getRequestURI()
                .toString()
                .split("\\?")[1]
                .split("=")[1];*/
    }
    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><\\html>");
        // encode HTML content
        String htmlResponse = "This is the response";
        System.out.println("Here");
        // this line is a must
        httpExchange.sendResponseHeaders(500, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }


}

