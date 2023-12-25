package TCP911_Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Client
 */
public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 807;
    Socket client = new Socket(host, port);

    DataInputStream dis = new DataInputStream(client.getInputStream());
    DataOutputStream dos = new DataOutputStream(client.getOutputStream());

    String senMessage = "B20DCCN757;911";
    System.out.println("Send message: " + senMessage);
    dos.writeUTF(senMessage);

    int firstNumber = dis.readInt();
    int secondNumber = dis.readInt();

    System.out.println("Number: " + firstNumber + " and " + secondNumber);

    int gcd = GCD(firstNumber, secondNumber);
    int lcd = firstNumber * secondNumber / gcd;
    int total = firstNumber + secondNumber;
    int multi = firstNumber * secondNumber;

    System.out.println(gcd + " | " + lcd + " | " + total + " | " + multi);
    dos.writeInt(gcd);
    dos.writeInt(lcd);
    dos.writeInt(total);
    dos.writeInt(multi);

    client.close();
  }

  public static int GCD(int a, int b) {
    if (b == 0)
      return a;
    return GCD(b, a % b);
  }

}