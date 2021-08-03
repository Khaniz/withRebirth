package org.zerock.noteT;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.net.Socket;

public class NoteClient {
    //bad code
    public static void main(String[] args) throws Exception{

        NoteDTO data = NoteDTO.builder().who("A").whom("B").content("커피한잔?").build();
        Command command = Command.builder().oper("ADD").noteDTO(data).build();

        Gson gson = new Gson();

        String str = gson.toJson(command);

        Socket socket = new Socket("127.0.0.1",9999);
        DataOutputStream dataOutputStream
                = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(str);



    }
}
