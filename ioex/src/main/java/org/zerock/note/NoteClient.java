package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class NoteClient {


    //bad code
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("보내는 사람은 누구입니까?");
        String A = scanner.nextLine();
        System.out.println("누구에게 보내시겠습니까?");
        String B = scanner.nextLine();
        System.out.println("내용은 엔터를 누르면 보내집니다");
        String C = scanner.nextLine();

        NoteDTO data = NoteDTO.builder().who(A).whom(B).content(C).build();

        Command command = Command.builder().oper("READ").noteDTO(data).build();

        Gson gson = new Gson();

        String str = gson.toJson(command);

        Socket socket = new Socket("127.0.0.1", 9999);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(str);
        //Socket
    }
}
