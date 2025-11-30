import java.io.IOException; //for handling exception
import java.io.InputStream; //Input stream to read input from req.
import java.io.OutputStream; //Output stream to attach to response to give output
import java.net.InetSocketAddress; //To make address from host,port

import com.sun.net.httpserver.HttpExchange; //handles req.-resp. (take-give) in one exchange
import com.sun.net.httpserver.HttpHandler; //handles request for a route specific
import com.sun.net.httpserver.HttpServer; //server


public class WebDeskBackend{
    public String host;
    public int port;
    public HttpServer server;
    public WebDeskBackend(String host, int port){
        this.host=host;
        this.port=port;
    }

    static class VamSatvagunJyoti implements HttpHandler {
        
        @Override
        public void handle(HttpExchange exchangeObj) throws IOException{
            InputStream reqBody = exchangeObj.getRequestBody();
            //read(reqBody);
            String responseBody = "Satvaguni";
            exchangeObj.sendResponseHeaders(200,responseBody.length());
            OutputStream outputStream = exchangeObj.getResponseBody();
            outputStream.write(responseBody.getBytes());
            outputStream.close();
        }
    }

    
    public void prakatitam() throws IOException{
        this.server = HttpServer.create(new InetSocketAddress(this.host,this.port),0);
        // http://127.0.0.1:8001/vamshakha/satvaguni
        this.server.createContext("/vamshakha/satvaguni", new VamSatvagunJyoti());
        this.server.setExecutor(null);
        this.server.start();

    }

}

// Some Learnings
/*
1. Inheritence using implements Keyword.
2. Overriding default method of superclass.
3. Reading and Writing request and response.
4. Server expecting context of route handlers, and handlers working with HttpExchange
5. Each of req is executed by an Executor in terms of threads possibly - setting to null uses main possibly.
6. Not using new Keyword over abstract type HttpServer as we're using method directly, not creating obj.
7. Seems "package x.y.z;" requires that dir hierarchy to exist.

*/