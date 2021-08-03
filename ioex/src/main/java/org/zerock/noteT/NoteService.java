package org.zerock.noteT;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

    public class NoteService {

        private Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>();
        private Integer idx = 0;


        public Integer add(NoteDTO noteDTO) {

            noteDTO.setNo(++idx);
            String owner = noteDTO.getWhom();

            ArrayList<NoteDTO> noteDTOS = noteMap.get(owner);

            if (noteDTOS == null) {
                ArrayList<NoteDTO> noteList = new ArrayList<>();
                noteList.add(noteDTO);
                noteMap.put(owner, noteList);
            } else {
                noteDTOS.add(noteDTO);
            }

            return idx;
        }

        public ArrayList<NoteDTO> getList(String owner) {
            return noteMap.get(owner);
        }

}
