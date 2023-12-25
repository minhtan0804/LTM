package TCP912_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 808;
    ServerSocket server = new ServerSocket(port);
    Socket socket = server.accept();

    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    String receiveMessage = reader.readLine();
    System.out.println("Receive message: " + receiveMessage);

    String sendMessage = "hsdvhfj3wygqr9w799sy493w488568&%E%E^E&E&^Rj%^&v$Dytc$^$%";
    System.out.println("Send message: " + sendMessage);
    writer.write(sendMessage);
    writer.newLine();
    writer.flush();

    String firstMessage = reader.readLine();
    System.out.println("First message: " + firstMessage);

    String secondMessage = reader.readLine();
    System.out.println("Second message: " + secondMessage);

    server.close();
  }
}
