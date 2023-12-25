package TCP911_Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class Server {

  public static void main(String[] args) throws Exception {
    int port = 807;
    ServerSocket server = new ServerSocket(port);
    Socket socket = server.accept();

    DataInputStream dis = new DataInputStream(socket.getInputStream());
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

    String receiveMessage = dis.readUTF();
    System.out.println("Receive message: " + receiveMessage);

    dos.writeInt(176);
    dos.writeInt(128);

    System.out.println("GCD: " +  dis.readInt());
    System.out.println("LCM: " +  dis.readInt());
    System.out.println("Total: " +  dis.readInt());
    System.out.println("Multi: " + dis.readInt());

    server.close();
  }
}