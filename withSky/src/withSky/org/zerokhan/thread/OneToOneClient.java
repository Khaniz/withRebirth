package withSky.org.zerokhan.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {
  
  public static void main(String[] args) throws Exception{

    Scanner keyScanner = new Scanner(System.in);
    Socket socket = new Socket("192.168.0.12",9999);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream din = new DataInputStream(socket.getInputStream());
    
    new Thread(()-> {
      
      while(true) {
        String serverMsg;
        try {
          serverMsg = din.readUTF();
          System.out.println("SERVER: " + serverMsg);
          
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }).start();
    
    

    while(true) {
        System.out.println("Insert Your Message");
        String msg = keyScanner.nextLine();
        dos.writeUTF(msg);
    }
}

 

}
