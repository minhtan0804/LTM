package UDP934_Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Server
 */
public class Server {

  public static void main(String[] args) throws Exception {
    int port = 1107;
    DatagramSocket server = new DatagramSocket(port);

    while (true) {
      byte[] buf = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
      server.receive(receivePacket);
      String receiveMessage = new String(receivePacket.getData()).trim();
      System.out.println("Receive message: " + receiveMessage);

      String sendMessage = "544;ddvfhdsngbfh;3";
      System.out.println("Send message: " + sendMessage);
      DatagramPacket sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(),
          receivePacket.getAddress(), receivePacket.getPort());
      server.send(sendPacket);

    }

  }
}