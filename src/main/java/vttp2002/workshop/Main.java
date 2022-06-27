package vttp2002.workshop;

import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
    static int port;
    static String path;
    
    public final static int DEFAULT_PORT = 3000;
    public static void main( String[] args )

    {

        if (args[0].contains("port")) {
            port = Integer.parseInt(args[1]);
        } else {
            port = DEFAULT_PORT;
        }

        if (args[0].contains("docRoot")) {
            path = args[1];
        } else {
            path = "./target";
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(HttpServer.start(port));
        

    }

 
}
