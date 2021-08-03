package org.zerock.random;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GatewayServer {
    public static void main(String[] args) throws Exception {

        Map<String, String> ipMap = new HashMap<>();

        ipMap.put("A", "127.0.0.1");

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready.........");

        while(true) {

            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF();

            System.out.println("Client MSG: " + str);

            Socket subSocket = new Socket(ipMap.get(str),9998);

            DataOutputStream subDos = new DataOutputStream(subSocket.getOutputStream());
            DataInputStream subDin = new DataInputStream(subSocket.getInputStream());

            subDos.writeUTF(str);

            String msg = subDin.readUTF();
            dos.writeUTF(msg);
            dos.flush();

        }
    }
}
