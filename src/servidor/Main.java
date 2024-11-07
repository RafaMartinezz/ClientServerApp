package servidor;

/**
 * Main entry point for the chat server.
 * This class initializes the server process, listening for incoming client
 * connections on the specified port.
 */
public class Main {
    public static void main(String[] args) {
        // Create the server that will listen on port 8080.
        Servidor servidor = new Servidor(8080);
        // Start the server session to accept client connections.
        servidor.iniciarSesion();
    }
}
