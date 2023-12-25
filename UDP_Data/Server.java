package UDP_Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 2207;
    DatagramSocket server = new DatagramSocket(port);

    while (true) {
      byte[] buf = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
      server.receive(receivePacket);
      String receiveMessage = new String(receivePacket.getData());
      System.out.println("Receive message: " + receiveMessage);

      String sendMessage = "hgbhjhvjhfvh UVYVn hTUHH fdhvfd fdf jsdvf sdnmfsd";
      System.out.println("Send message: " + sendMessage);
      DatagramPacket sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(),
          receivePacket.getAddress(), receivePacket.getPort());
      server.send(sendPacket);

      receivePacket = new DatagramPacket(buf, buf.length);
      server.receive(receivePacket);

      receiveMessage = new String(receivePacket.getData());
      System.out.println("Receive message: " + receiveMessage);
    }
  }
}
