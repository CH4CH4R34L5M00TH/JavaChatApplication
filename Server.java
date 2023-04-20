import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    out.println("Message received: " + message);
                }
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
