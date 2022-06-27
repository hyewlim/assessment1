package vttp2002.workshop;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
    
    public final static int DEFAULT_PORT = 3000;
    public static void main( String[] args )

    {
        int port;
        Path p1 = Paths.get("/target");

        if (args.length == 0) {
            port = DEFAULT_PORT;  
        }

        if (args.length == 2 && args[0].contains("port")) {
            port = Integer.parseInt(args[1]);
        }

        if (args.length == 2 && args[0].contains("docRoot")) {
            Path inputPath = Paths.get(args[1]);
        }

        if (args.length == 4 && args[0].contains("port") && args[2].contains("docRoot")) {
            port = Integer.parseInt(args[1]);
            Path inputPath = Paths.get(args[3]);
        }

        
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ServerSocket server = new ServerSocket(port);

        while(true){
            System.out.println("Waiting for client connection");
            Socket sock = server.accept();
            System.out.println("Connected ...");
            CookieClientHandler thr = new CookieClientHandler(sock, cookieFile);
            threadPool.submit(thr);
            System.out.println("Submitted to threadpool");
        }
        

    }

 
}
