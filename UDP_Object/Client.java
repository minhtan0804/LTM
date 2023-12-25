package UDP_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "127.0.0.1";
    int port = 2207;
    DatagramSocket client = new DatagramSocket();

    Student sendStudent = new Student("B20DCCN757");
    System.out.println("Send message: " + sendStudent.toString());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(sendStudent);

    byte[] buf = baos.toByteArray();
    DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(host), port);
    client.send(sendPacket);

    buf = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
    client.receive(receivePacket);

    ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
    ObjectInputStream ois = new ObjectInputStream(bais);

    Student receiveStudent = (Student) ois.readObject();

    System.out.println("Receive message: " + receiveStudent.toString());

    String name = receiveStudent.getName().toLowerCase().toString();
    String[] items = name.split(" ");
    String email = items[items.length - 1];
    for (String item : items) {
      email += item.substring(0, 1);
    }

    receiveStudent.setEmail(email.substring(0, email.length() - 2) + "@ptit.edu.vn");

    baos = new ByteArrayOutputStream();
    oos = new ObjectOutputStream(baos);
    oos.writeObject(receiveStudent);

    buf = baos.toByteArray();
    sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(host), port);
    client.send(sendPacket);

    System.out.println("Send message: " + receiveStudent.toString());

  }
}
