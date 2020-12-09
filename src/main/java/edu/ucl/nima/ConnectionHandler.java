package edu.ucl.nima;

import java.net.*;
import java.io.*;
import edu.ucl.nima.content.ContentGenerator;

public class ConnectionHandler implements Runnable {
    private final Socket clientSocket;

    public ConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        String outputLine;
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ){
            String fromClient;
            out.println("ready");
            if ((fromClient = in.readLine()) != null) {
                outputLine = new ContentGenerator().generate(fromClient);
                out.println(outputLine);
            }
            out.println("done");
        } catch (IOException e) {
            System.out.println("Exception caught when trying to read connection");
            System.out.println(e.getMessage());
        }
    }
}