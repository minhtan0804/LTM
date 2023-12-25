package TCP700_Byte;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(806);
    Socket socket = server.accept();

    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();

    byte[] buf = new byte[1024];
    int byteReceive = inputStream.read(buf);
    String receiveMessage = new String(buf, 0, byteReceive);
    System.out.println("Receive message: " + receiveMessage);

    int firstValue = 5;
    int secondValue = 7;
    String sendMessage = String.format("%d|%d", firstValue, secondValue);
    System.out.println("Send message: " + sendMessage);

    outputStream.write(sendMessage.getBytes());

    byteReceive = inputStream.read(buf);
    receiveMessage = new String(buf, 0, byteReceive);
    System.out.println("Receive message: " + receiveMessage);

    server.close();
  }
}
