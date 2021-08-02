package org.zerock.random;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class FoodVendingServer {


    public static void main(String[] args) throws Exception {
        HashMap<String, String[]> foodMap = new HashMap<String, String[]>();

        foodMap.put("korean", new String[]{"불고기", "신선로", "궁중떡볶이"});
        foodMap.put("japan", new String[]{"초밥", "돈카츠", "오롯이라멘", "후토마키"});

        String[] arr= foodMap.get("korean");
        String[] arr1=foodMap.get("japan");

        System.out.println(Arrays.toString(arr));


        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready............");

        // 루프 시작
        while (true){
            //연결 accept() Socket
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());

            //클라이언트가 보낸 메시지 읽기
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String msg = inScanner.nextLine();
            System.out.println(msg);

            //읽은 메시지를 다시 전송
            if(msg.equals("korean")) {
                int i = ((int)(Math.random()*10))%arr.length;
//                Thread.sleep(500);
                String sendMsg = "SERVER: " + arr[i] + "\n";
                OutputStream out = socket.getOutputStream();

                out.write(sendMsg.getBytes());
                out.flush();

                out.close();
            } else if (msg.equalsIgnoreCase("japan")) {
                int i = ((int)(Math.random()*10))%arr1.length;
//                Thread.sleep(500);
                String sendMsg = "SERVER: " + arr1[i] + "\n";
                OutputStream out = socket.getOutputStream();

                out.write(sendMsg.getBytes());
                out.flush();

                out.close();

            }

            inScanner.close();
            in.close();
            socket.close();

            //소켈 연결 종료

        }

    }

}
