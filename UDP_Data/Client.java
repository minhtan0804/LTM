package UDP_Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 2207;

    DatagramSocket client = new DatagramSocket();

    String sendMessage = "B20DCCN757;111";
    System.out.println("Send message: " + sendMessage);
    DatagramPacket sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(),
        InetAddress.getByName(host), port);
    client.send(sendPacket);

    byte[] buf = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
    client.receive(receivePacket);

    String receiveMessage = new String(receivePacket.getData()).trim();
    System.out.println("Receive message: " + receiveMessage);

    String[] messages = receiveMessage.split(" ");
    StringBuilder req = new StringBuilder();

    for (String message : messages) {
      req.append(message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase() + " ");
    }

    sendMessage = req.toString();
    System.out.println("Send message: " + sendMessage);
    sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(), receivePacket.getAddress(), port);
    client.send(sendPacket);

  }
}
