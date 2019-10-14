import org.xml.sax.SAXException;
import taodoors.read.utility.Configuration;
import taodoors.tcp.provider.HTTPServer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

public class Main {
    static final boolean verbose = true;

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try {
            String p = Configuration.getInstance().getConfigurationByTagName(null, "port");
            int port = (p == null) ? HTTPServer.DefaultConfiguration.port : Integer.parseInt(p);

            Configuration configFile = Configuration.getInstance();
            //String webRoot = configFile.getConfigurationByTagName(null, JavaHTTPServer.TAGS.WEB_CONTENT_TAG);
            ServerSocket serverConnect = new ServerSocket(port);
            System.out.println("Server started.\nListening for connections on port : " + port + " ...\n");

            // we listen until user halts server execution
            while (true) {
                HTTPServer myServer = new HTTPServer(serverConnect.accept());

                if (verbose) {
                    System.out.println("Connecton opened. (" + new Date() + ")");
                }

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
