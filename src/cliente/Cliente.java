package cliente;

import java.io.IOException;
import java.net.Socket;
import lectura_escritura.Escritura;
import lectura_escritura.Lectura;

/**
 * Represents a chat client in the application.
 * This class connects to the server and manages input and output message
 * interactions.
 */
public class Cliente {
    private int puerto;
    private Socket socket;

    /**
     * Constructs a Cliente instance with the specified server port.
     *
     * @param puerto The server port number to connect to.
     */
    public Cliente(int puerto) {
        this.puerto = puerto;
    }

    /**
     * Starts the client chat session by connecting to the server
     * and initializing separate threads for reading and writing messages.
     */
    public void iniciarSesion() {
        try {
            // Establishes a connection to the server at localhost on the specified port.
            socket = new Socket("localhost", puerto);

            // Creates a thread for reading incoming messages from the server.
            Lectura lectura = new Lectura(socket);

            // Creates a thread for sending outgoing messages to the server.
            Escritura escritura = new Escritura(socket);

            // Starts both reading and writing threads.
            lectura.start();
            escritura.start();
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor.");
            e.printStackTrace();
        }
    }
}
