package TCP700_Byte;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 806;

    Socket client = new Socket(host, port);

    InputStream inputStream = client.getInputStream();
    OutputStream outputStream = client.getOutputStream();

    String sendMessage = "B20DCCN757;700";
    System.out.println("Send message: " + sendMessage);
    outputStream.write(sendMessage.getBytes());
    // outputStream.flush();

    byte[] buf = new byte[1024];
    int byteReceive = inputStream.read(buf);
    String receiveMessage = new String(buf, 0, byteReceive);
    System.out.println("Receive message: " + receiveMessage);

    String[] messages = receiveMessage.split("\\|");
    int firstValue = Integer.parseInt(messages[0]);
    int secondValue = Integer.parseInt(messages[1]);

    sendMessage = String.valueOf(firstValue + secondValue);
    System.out.println("Send message: " + sendMessage);
    outputStream.write(sendMessage.getBytes());
    // outputStream.flush();

    client.close();
  }
}
