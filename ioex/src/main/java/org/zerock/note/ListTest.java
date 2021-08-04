package org.zerock.note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {

        ArrayList<NoteDTO> list
                = new ArrayList<>();

//        NoteDTO obj = NoteDTO.builder().build();
//
//        list.add(obj);
        //요거 줄여서
        list.add(NoteDTO.builder().no(1).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(2).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(3).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(4).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(5).who("A").whom("B").build());

        System.out.println(list.size()); //몇개가 차있는지

        System.out.println(list);

        List<NoteDTO> blist = list.stream().filter(noteDTO -> noteDTO.getWhom().equals("B")).collect(Collectors.toList());

        System.out.println(blist);

//        list.remove(2);
        //이 로직이 트루인 애는 리무브 시켱
        //무조건 리턴 해줘야함. 트루 폴스 괄호가 있으면 실행 결과 리턴 해줘야하고 괄호 없으면 없는 그것이 리턴값.
        //list.removeIf(noteDTO -> true)

//        list.removeIf(noteDTO -> {
//        return true;
//        });

        list.removeIf(noteDTO -> noteDTO.getNo()==5);

        System.out.println(list);

        System.out.println(list.size());

    }
}
