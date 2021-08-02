package org.zerock.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {

    //bad code
    public static void main(String[] args)throws Exception {

        Socket socket = new Socket("192.168.0.6",9999);

        System.out.println(socket);

        InputStream in = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream("/Users/khan/test/gogogo2.jpeg");
        byte[] buffer = new byte[1024*8];

        while(true){
            int count = in.read(buffer);
            if(count== -1){break;}
            fos.write(buffer,0,count);

        }//end while

//        System.out.println(data);

        socket.close();

    }
}
