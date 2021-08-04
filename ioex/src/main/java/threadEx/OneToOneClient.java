package threadEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {
    public static void main(String[] args) throws Exception{

        Scanner keyScanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",9999);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while(true) {
            System.out.println("Inser Your Message");
            String msg = keyScanner.nextLine();
            dos.writeUTF(msg);
        }
    }
}
