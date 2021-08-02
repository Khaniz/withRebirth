package org.zerock.ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    //bad code close 철저하게 해야한다. 이번엔 그냥 던짐
    public static void main(String[] args)throws Exception{

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready.....");

        while(true){
            Socket client = serverSocket.accept();
            System.out.println(client);
            //클라이언트와 연결된 종이컵 전화기

            OutputStream out = client.getOutputStream();
            //out.write(97);
            File file = new File("/Users/khan/test/forhanseul.jpeg");
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg; charset=UTF-8\r\n\r\n").getBytes());

            InputStream fin = new FileInputStream("/Users/khan/test/forhanseul.jpeg");

            byte[] buffer = new byte[1024*8];

            while(true){
               int count = fin.read(buffer);
               if(count== -1){break;}
               out.write(buffer,0,count);

            }//end while

            fin.close();

            out.close();
            client.close();;

        }// end while
    }
}
