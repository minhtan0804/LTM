package TCP600_Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 808;
    ServerSocket server = new ServerSocket(port);
    Socket socket = server.accept();

    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    String receiveMessage = reader.readLine();
    System.out.println("Receive message: " + receiveMessage);

    String sendMessage = "giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu";

    writer.write(sendMessage);
    writer.newLine();
    writer.flush();

    receiveMessage = reader.readLine();
    System.out.println("Receive message: " + receiveMessage);

    server.close();
  }

}
