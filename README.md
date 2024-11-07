# Chat application - server and client in java

This project is a basic chat application implemented in Java. It comprises client and server programs, where multiple clients can connect to the server and exchange messages. The project uses socket programming to facilitate communication, with distinct classes for managing the server, client, and message reading/writing.

## Features

- **Server-Client Architecture:** The server accepts connections from clients on a specified port and maintains individual communication channels for each client.
- **Multi-threaded Design:** Separate threads handle reading and writing, enabling simultaneous message exchange.
- **Chat Commands:** Supports commands like `sair()` for closing the connection gracefully.
- **Java Socket Programming:** Uses Java's `Socket` and `ServerSocket` classes to manage connections and message transmission.

## Project Structure

- **`cliente` Package:** Contains client-side classes:
  - `Cliente`: Manages connection setup and handles session initialization with the server.
  - `Main`: Entry point for the client; connects to the server and starts the chat session.

- **`lectura_escritura` Package:** Contains classes for handling message input and output:
  - `Lectura`: Manages reading messages from the server or other clients.
  - `Escritura`: Manages sending messages from the client to the server or other clients.

- **`servidor` Package:** Contains server-side classes:
  - `Servidor`: Sets up the server, listens for incoming client connections, and initiates communication.
  - `Main`: Entry point for the server; listens on a specified port and manages client connections.

## How to Run the Project

1. **Set Up the Server:**
   - Run `servidor.Main` to start the server. The server will listen for client connections on port 8080 (or the specified port in `Servidor` class).

2. **Set Up the Client:**
   - Run `cliente.Main` to start a client instance.
   - When prompted, enter your username. Start typing messages, which will be sent to the server and displayed to other connected clients.

3. **Commands:**
   - Enter `sair()` to close the client session and disconnect from the server.

## Requirements

- **Java 17 or higher** for running the project
- **Maven** for dependency management and project building

## Example Usage

- Start the server on a terminal or IDE.
- Connect multiple clients using separate terminals or IDE instances.
- Clients can exchange messages, and the server manages all connections.

## Classes Overview

### `cliente.Cliente`

Connects to the server and starts separate threads to read from and write to the server. Each client instance operates independently, managing its own session.

### `lectura_escritura.Escritura`

Handles sending messages from a client to the server. It continuously listens for user input and sends messages to the server. Supports the `sair()` command to close the session.

### `lectura_escritura.Lectura`

Handles receiving messages from the server or other clients. It continuously listens for incoming messages and displays them on the client’s console.

### `servidor.Servidor`

Sets up the server to listen for incoming client connections. Each client connection is assigned its own reading and writing threads for message handling.

## Dependencies

This project does not currently have any dependencies listed in a Maven `pom.xml` file since it relies on Java’s built-in networking libraries (`java.net.Socket`, `java.io`). Ensure you have Java 17 or higher installed.

## Future Improvements

- **Enhance Multi-Client Support:** Extend to handle multiple clients simultaneously.
- **Add GUI Support:** Implement a graphical user interface (GUI) for a better user experience.
- **Add Security:** Implement encryption for secure message transmission.