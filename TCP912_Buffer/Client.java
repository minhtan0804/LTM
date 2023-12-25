package TCP912_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 808;
    Socket client = new Socket(host, port);

    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

    String sendMessage = "B20DCCN757;912";
    System.out.println("Send message: " + sendMessage);
    writer.write(sendMessage);
    writer.newLine();
    writer.flush();

    String receiveMessage = reader.readLine();
    System.out.println("Receive message: " + receiveMessage);

    String firstMessage = "";
    String secondMessage = "";

    for (char c : receiveMessage.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        firstMessage += String.valueOf(c);
      } else {
        secondMessage += String.valueOf(c);
      }
    }

    System.out.println("First message: " + firstMessage);
    System.out.println("Second message: " + secondMessage);

    writer.write(firstMessage);
    writer.newLine();
    writer.write(secondMessage);
    writer.newLine();
    writer.flush();

    client.close();

  }
}
