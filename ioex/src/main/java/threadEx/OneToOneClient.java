package threadEx;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception{

        Scanner keyScanner = new Scanner(System.in);

        Socket socket = new Socket("127.0.0.1",9999);

        System.out.println("connected.....");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);

        for(int i = 0; i<100; i++) {
            //문자열은 byte[]로 바꿔서 out.write(바이트배열로)
            String msg = keyScanner.nextLine() + "\n";

            out.write(msg.getBytes());
            System.out.println("------------------------------------------");
            String line = inScanner.nextLine();
            System.out.println(line);
        }

        out.close();
        socket.close();
    }

}
