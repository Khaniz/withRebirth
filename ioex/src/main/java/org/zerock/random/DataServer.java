package org.zerock.random;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("Ready.........");

        while(true) {

            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF();

            System.out.println("Client MSG: " + str);

            String msg = "KiHoon";

            dos.writeUTF(msg);
            dos.flush();

        }
    }
}
