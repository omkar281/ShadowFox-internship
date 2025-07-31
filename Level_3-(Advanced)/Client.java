import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        Socket socket = new Socket("localhost", 12345); // Connect to the server running on localhost at port 12345
        System.out.println("Connected to server.");

        // Setup input and output streams
        DataInputStream dis = new DataInputStream(socket.getInputStream()); // Input stream to receive data from server
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); // Output stream to send data to server

        // Read user input
        Scanner scanner = new Scanner(System.in); // Create scanner object to read user input

        // Read messages from server
        Thread readThread = new Thread(() -> { // Create a new thread to continuously read messages from the server
            while (true) {
                try {
                    // Read message from server
                    String message = dis.readUTF(); // Read message from input stream
                    System.out.println("Server: " + message); // Print message received from server
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        readThread.start(); // Start the thread to read messages from server

        // Send messages to server
        while (true) {
            String message = scanner.nextLine(); // Read user input
            dos.writeUTF(message); // Send the message to the server
        }
    }
}
