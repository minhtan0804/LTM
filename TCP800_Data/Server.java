package TCP800_Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 807;

    ServerSocket server = new ServerSocket(port);
    while (true) {
      Socket socket = server.accept();

      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      String receiveMessage = dis.readUTF();
      System.out.println("Receive message: " + receiveMessage);

      dos.writeInt(10);
      dos.writeInt(11);

      System.out.println("Total: " + dis.readInt());
      System.out.println("Multi: " + dis.readInt());

    }

  }
}
