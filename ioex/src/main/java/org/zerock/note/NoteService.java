package org.zerock.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteService {
    private Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>();
    private Integer idx = 0;


    public Integer add(NoteDTO noteDTO){

        noteDTO.setNo(++idx);
        String owner = noteDTO.getWhom();

        ArrayList<NoteDTO> noteDTOS = noteMap.get(owner);

        if(noteDTOS == null){
            ArrayList<NoteDTO> noteList = new ArrayList<>();
            noteList.add(noteDTO);
            noteMap.put(owner, noteList);
        } else {
            noteDTOS.add(noteDTO);
        }

        return idx;
    }

    public ArrayList<NoteDTO> getList(String owner){
        return noteMap.get(owner);
    }

//    public static void main(String[] args) {
//        NoteService service = new NoteService();
//        NoteDTO noteDTO = NoteDTO.builder().who("user2").whom("user1").content("이해가안가").build();
//        service.add(noteDTO);
//
//        NoteDTO noteDTO2 = NoteDTO.builder().who("user3").whom("user1").content("나도 이해가안가").build();
//        service.add(noteDTO2);
//
//        NoteDTO noteDTO3 = NoteDTO.builder().who("user1").whom("user2").content("난 쉬운데 ㅋ").build();
//        service.add(noteDTO3);
//
//        System.out.println(service.noteMap);
//
//
//
//    }

}
