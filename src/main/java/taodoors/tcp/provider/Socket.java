package taodoors.tcp.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.Date;

public class Socket {

    //static ServerSocket variable
    private static ServerSocket server;

    private static int port = 4242;

    public static void main(String args[]) throws IOException {
        HTTP();
    }

    public static void HTTP() throws IOException {
        BufferedReader in = null;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port "+port);
        while (true) {
            try (java.net.Socket socket = server.accept()) {
               // in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }


   public void simpleSocket()   throws IOException, ClassNotFoundException{
       server = new ServerSocket(port);
       System.out.println(server.getInetAddress());
       System.out.println(server.getLocalPort());
       System.out.println(server.getLocalSocketAddress());
       //keep listens indefinitely until receives 'exit' call or program terminates
       while (true) {
           System.out.println("Waiting for the client request");
           //creating socket and waiting for client connection
           java.net.Socket socket = server.accept();
           //read from socket to ObjectInputStream object
           ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
           //convert ObjectInputStream object to String
           String message = (String) ois.readObject();
           System.out.println("Message Received: " + message);
           //create ObjectOutputStream object
           ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
           //write object to Socket
           oos.writeObject("Hi Client " + message);
           //close resources
           ois.close();
           oos.close();
           socket.close();
           //terminate the server if client sends exit request
           if (message.equalsIgnoreCase("exit")) break;
       }
       System.out.println("Shutting down Socket server!!");
       //close the ServerSocket object
       server.close();
   }



}
