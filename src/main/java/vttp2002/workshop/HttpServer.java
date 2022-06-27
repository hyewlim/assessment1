package vttp2002.workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  
    // initialize socket and input output stream
    static Socket socket = null;
    InputStreamReader isr = null;
    OutputStreamWriter osw = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    static ServerSocket serverSocket = null;

    //start server(port)
    public static Runnable start(int port) {

        while (true) {
            try {
                serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();
                System.out.println("client connected at:" + port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    

}
