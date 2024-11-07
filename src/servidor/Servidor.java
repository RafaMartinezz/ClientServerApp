package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lectura_escritura.Escritura;
import lectura_escritura.Lectura;

/**
 * Represents the server in the chat application.
 * Listens for incoming client connections and manages message input and output
 * interactions.
 */
public class Servidor {
    private int puerto;
    private ServerSocket serverSocket;

    /**
     * Constructor that initializes the server on the specified port.
     * Sets up the server to listen on the given port.
     * 
     * @param puerto The port number the server will listen on.
     */
    public Servidor(int puerto) {
        this.puerto = puerto;
        try {
            serverSocket = new ServerSocket(puerto); // Prepares the server to listen on the specified port.
        } catch (IOException e) {
            System.out.println("Error initializing the server.");
            e.printStackTrace();
        }
    }

    /**
     * Starts the server session by accepting client connections.
     * Creates a socket for each connected client and initiates threads for reading
     * and writing messages.
     */
    public void iniciarSesion() {
        try {
            // Accepts an incoming client connection.
            Socket clientSocket = serverSocket.accept();

            // Thread to read messages from the client.
            Lectura lectura = new Lectura(clientSocket);

            // Thread to send messages to the client.
            Escritura escritura = new Escritura(clientSocket);

            // Start both threads for handling client communication.
            lectura.start();
            escritura.start();
        } catch (IOException e) {
            System.out.println("Error accepting client connection.");
            e.printStackTrace();
        }
    }
}
