package TCP800_Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 807;
    Socket client = new Socket(host, port);

    DataInputStream dis = new DataInputStream(client.getInputStream());
    DataOutputStream dos = new DataOutputStream(client.getOutputStream());

    String sendMessage = "B20DCCN757;800";
    dos.writeUTF(sendMessage);

    int a = dis.readInt();
    int b = dis.readInt();

    dos.writeInt(a + b);
    dos.writeInt(a * b);

    client.close();
  }
}
