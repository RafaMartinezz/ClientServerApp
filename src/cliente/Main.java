package cliente;

/**
 * Main entry point for the chat client.
 * This class initiates the client process by connecting it to the server on the
 * specified port.
 */
public class Main {
    public static void main(String[] args) {
        // Creates a client that will connect to the server on port 8080.
        Cliente cliente = new Cliente(8080);

        // Starts the chat session for the client.
        cliente.iniciarSesion();
    }
}
