package UDP_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

      ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
      ObjectInputStream ois = new ObjectInputStream(bais);

      Student receiveStudent = (Student) ois.readObject();

      System.out.println("Receive message: " + receiveStudent.toString());

      Student sendStudent = new Student("B20DCCN111", "B20DCCN111", "Tran Minh Tan", "");
      System.out.println("Send message: " + sendStudent.toString());

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(sendStudent);

      buf = baos.toByteArray();
      DatagramPacket senPacket = new DatagramPacket(buf, buf.length, receivePacket.getAddress(),
          receivePacket.getPort());
      server.send(senPacket);

      buf = new byte[1024];
      receivePacket = new DatagramPacket(buf, buf.length);
      server.receive(receivePacket);

      bais = new ByteArrayInputStream(receivePacket.getData());
      ois = new ObjectInputStream(bais);
      receiveStudent = (Student) ois.readObject();

      System.out.println("Receive message: " + receiveStudent.toString());

    }
  }
}
