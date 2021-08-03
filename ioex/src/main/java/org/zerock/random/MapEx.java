package org.zerock.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {

        //key, value
        Map<String, String[]> map = new HashMap<>();

        map.put("kor", new String[]{"불고기", "비빔밥"});
        map.put("jap", new String[]{"초밥", "라멘"});
        map.put("wes", new String[]{"피자", "파스타"});

        String[] arr = map.get("wes");

        System.out.println(Arrays.toString(arr));

        int idx = (int)(Math.random() * arr.length);

        System.out.println(arr[idx]);
    }

}
