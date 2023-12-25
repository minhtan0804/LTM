package TCP915_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 2208;

    Socket client = new Socket(host, port);

    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

    String sendMessage = "B20DCCN757;915";
    System.out.println("Send message: " + sendMessage);

    writer.write(sendMessage);
    writer.newLine();
    writer.flush();

    String receiveMessage = reader.readLine();
    ArrayList<String> characters = new ArrayList<>();
    for (Character c : receiveMessage.toCharArray()) {
      String item = String.valueOf(c);

      if (Character.isLetter(c) && !characters.contains(item)) {
        characters.add(item);
      }
    }

    sendMessage = String.join("", characters);
    System.out.println("Send message: " + sendMessage);

    writer.write(sendMessage);
    writer.newLine();
    writer.flush();
  }
}
