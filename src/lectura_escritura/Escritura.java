package lectura_escritura;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Manages writing messages from the console to the server or client.
 * Each message typed by the user is sent through the socket.
 */
public class Escritura extends Thread {
    private DataOutputStream output;
    private Socket socket;
    private String nombre;
    private Scanner sc;

    /**
     * Constructor that initializes the output stream for the socket
     * and sets up a scanner to read user input from the console.
     *
     * @param socket The socket through which messages are sent.
     */
    public Escritura(Socket socket) {
        this.socket = socket;
        try {
            this.output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sc = new Scanner(System.in);
    }

    /**
     * Runs the thread, handling the process of reading user input,
     * formatting it with the user's name, and sending it to the server.
     */
    @Override
    public void run() {
        System.out.println("Please choose your name:");
        this.nombre = sc.nextLine();
        try {
            while (true) {
                String mensaje = sc.nextLine(); // Read the user's message
                String mensajeSaliente = nombre + ": " + mensaje; // Format message with the user's name
                if (mensajeSaliente.equals(nombre + ": sair()")) { // Ends session if "sair()" is entered
                    socket.close(); // Close socket to end session
                    break;
                }
                output.writeUTF(mensajeSaliente); // Send the message to the other end of the socket
            }
        } catch (IOException e) {
            // Handle input/output exceptions.
        } finally {
            // Close resources.
            try {
                output.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
