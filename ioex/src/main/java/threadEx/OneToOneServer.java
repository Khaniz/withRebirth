package threadEx;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OneToOneServer {

    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(9999);

        System.out.println("Ready...........");

        Socket client = server.accept();

        DataInputStream din = new DataInputStream(client.getInputStream());

        while(true) {
            String clientMsg = din.readUTF();
            System.out.println(clientMsg);
        }


    }//main
}
