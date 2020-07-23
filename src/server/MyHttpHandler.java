package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import netscape.javascript.JSObject;
import suncertify.db.Data;
import suncertify.db.DatabaseException;

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
        try {
            handleResponse(httpExchange,requestParamValue);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
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
    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException, DatabaseException {
        OutputStream outputStream = httpExchange.getResponseBody();
        Data data = new Data("src/data/flights.txt");
        System.out.println(data.find("SFO"));
        String htmlResponse = "This is the response";
        System.out.println("Here");
        // this line is a must
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }


}

