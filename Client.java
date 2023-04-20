import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Enter message: ");
                String message = consoleIn.readLine();
                out.println(message);
                String response = in.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
