package UDP934_Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client
 */
public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 1107;

    DatagramSocket client = new DatagramSocket();

    String sendMessage = ";B20DCCN757;934";
    System.out.println("Send message: " + sendMessage);
    DatagramPacket sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(),
        InetAddress.getByName(host), port);
    client.send(sendPacket);

    byte[] buf = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
    client.receive(receivePacket);

    String receiveMessage = new String(receivePacket.getData()).trim();
    System.out.println("Receive message: " + receiveMessage);

    String[] messages = receiveMessage.split(";");
    String requestID = messages[0];
    String strEndcode = messages[1];
    int s = Integer.parseInt(messages[2]);

  }

  public static String decrypt(String text, int shift) {

    StringBuilder result = new StringBuilder();

    for (Character c : text.toCharArray()) {
      if (Character.isLetter(c)) {
        char base = Character.isUpperCase(c) ? 'A' : 'a';

      }
    }
    return text;
  }

}