package TCP916_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

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

    String firstMessage = reader.readLine();
    System.out.println("First message: " + firstMessage);
    String secondMessage = reader.readLine();
    System.out.println("Second message: " + secondMessage);

    ArrayList<String> firstList = new ArrayList<>(Arrays.asList(firstMessage.split("")));
    ArrayList<String> secondList = new ArrayList<>(Arrays.asList(secondMessage.split("")));

    String result = "";

    for (String i : firstList) {
      if (firstList.contains(i) && !secondList.contains(i)) {
        result += i;
      }
    }

    sendMessage = result;
    System.out.println("Send message: " + sendMessage);

    writer.write(sendMessage);
    writer.newLine();
    writer.flush();
  }
}
