package lectura_escritura;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Manages reading incoming messages from the server or client.
 * Received messages are printed to the console.
 */
public class Lectura extends Thread {
    private DataInputStream input;
    private Socket socket;

    /**
     * Constructor that initializes the input stream for reading messages
     * from the socket connection.
     *
     * @param socket The socket through which messages are received.
     */
    public Lectura(Socket socket) {
        this.socket = socket;
        try {
            this.input = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the thread, continuously reading incoming messages from the socket.
     * Terminates if the "sair()" command is received, closing the connection.
     */
    @Override
    public void run() {
        try {
            while (true) {
                String mensajeEntrante = input.readUTF(); // Reads incoming messages.
                if (mensajeEntrante.endsWith("sair()")) { // Ends session if "sair()" is received
                    socket.close(); // Close the socket to end the session
                    break;
                } else {
                    System.out.println(mensajeEntrante); // Print the message to the console
                }
            }
        } catch (IOException e) {
            // Handle input/output exceptions
        } finally {
            // Close resources
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
