package threadEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyServer {

    // close 문제
    // 중간에 누군가 나가버리면
    // 익명의 고라니 문제

   public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(9999);
        System.out.println("Ready......");
        List<DataOutputStream> dosList = new ArrayList<>();


        while(true){

            Socket socket = server.accept();
            System.out.println(socket);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dosList.add(dos);

            new Thread(()->{
                while(true){

                    try {
                        String str = din.readUTF();
                        System.out.println(str);

                        for(int i = 0; i <dosList.size(); i++){
                            dosList.get(i).writeUTF(str);

                        }

                    } catch (Exception e) {
                        dosList.remove(dos);
                    }
                }
            }).start();
        }//end while
    }
}
