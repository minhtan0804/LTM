package TCP600_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    Socket client = new Socket("localhost", 808);

    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

    String sendMessage = "B20DCCN757;600";
    writer.write(sendMessage);
    writer.newLine();
    writer.flush();

    String receiveMessage = reader.readLine().trim();

    String[] domains = receiveMessage.split(",");
    String eduDomains = "";

    for (String domain : domains) {
      if (domain.endsWith(".edu")) {
        eduDomains += domain.trim() + ", ";
      }
    }

    receiveMessage = eduDomains.substring(0, eduDomains.length() - 3);

    writer.write(receiveMessage);
    writer.newLine();
    writer.flush();

    client.close();
  }

}
