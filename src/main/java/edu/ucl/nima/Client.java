package edu.ucl.nima;

import java.io.*;
import java.net.*;
 
public class Client {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 3) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number> <query>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        String query = args[2];
 
        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        ) {
            String fromServer;
 
            while (!(fromServer = in.readLine()).equals(ConnectionHandler.HANGUP)) {
                if (fromServer.equals(ConnectionHandler.HANDSHAKE)) {
                    out.println(query);
                } else {
                    System.out.println("Response: " + fromServer);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.exit(1);
        }
    }
}