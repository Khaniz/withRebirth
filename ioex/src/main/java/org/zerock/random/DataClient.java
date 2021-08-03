package org.zerock.random;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DataClient {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Your message");

        String msg = scanner.nextLine();

        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);

        dos.writeUTF(msg);
        System.out.println("--------------------------------------");
        String servermsg = din.readUTF();
        System.out.println(servermsg);

    }
}
