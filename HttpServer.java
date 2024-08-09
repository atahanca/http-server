import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 * 
 * @author Atahan Caramanolis
 */

 public class HttpServer {  

    // The main method serves as the entry point of the application.
    public static void main(String args[]) throws IOException {

        // Create a new ServerSocket listening on port 8080.
        ServerSocket server = new ServerSocket(8080);

        // Output to the console that the server is listening for a connection.
        System.out.println("Listening for connection on port 8080 ....");

        // Infinite loop to keep the server running and accepting connections.
        while (true) {
            // Try-with-resources to automatically close the socket after use.
            try (Socket socket = server.accept()) {

                // Create a new Date object representing the current date and time
                Date today = new Date();

                // Prepare a simple HTTP response string with the current date.
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;

                // Write the HTTP response to the client's output stream.
                socket.getOutputStream()
                      .write(httpResponse.getBytes("UTF-8"));
            }
            // The socket is automatically closed here because of the try-with-resources block.
        }
    }
}
