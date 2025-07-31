import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    // Maintain a list of connected clients
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Server socket setup
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running...");

        // Keep accepting new clients
        while (true) {
            Socket socket = serverSocket.accept(); // Accept incoming client connection
            System.out.println("New client connected: " + socket);

            // Create a new thread for each client
            ClientHandler clientHandler = new ClientHandler(socket);

            // Add the client to the list
            clients.add(clientHandler);

            // Start the thread
            clientHandler.start(); // Start handling client in a separate thread
        }
    }

    // Broadcast messages to all clients
    public static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message); // Send message to each connected client
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        dis = new DataInputStream(socket.getInputStream()); // Input stream for receiving data from client
        dos = new DataOutputStream(socket.getOutputStream()); // Output stream for sending data to client
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Read message from client
                String message = dis.readUTF(); // Read message from client
                System.out.println("Received: " + message); // Print received message

                // Broadcast message to all clients
                Server.broadcast(message); // Send message to all clients connected to the server
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            // Close resources
            socket.close(); // Close socket connection with client
            dis.close(); // Close input stream
            dos.close(); // Close output stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Send a message to this client
    public void sendMessage(String message) throws IOException {
        dos.writeUTF(message); // Write message to output stream and send to client
    }
}
