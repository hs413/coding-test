import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 공원 산책
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * */
public class Test2 {
    public static void main(String[] args) {
//  ["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
//  ["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
//  ["OSO","OOO","OXO","OOO"] ["E 2","S 3","W 1"] [0,0]
//        String[] park = {"SOO", "OOO", "OOO"};
        String[] park = {"SOO", "OXX", "OOO" };
//        String[] park = {"OSO", "OOO", "OXO", "OOO"};
//        String[] routes = {"E 2", "S 2", "W 1"};
        String[] routes = {"E 2", "S 2", "W 1"};
//        String[] routes = {"E 2", "S 3", "W 1"};

        Map<String, Boolean> map = new HashMap<>();
        int[] cur = new int[2];

        int parkLen = park.length;
        for (int i = 0; i < parkLen; i ++) {
            String[] chArr = park[i].split("");

            int chArrLen = chArr.length;
            for (int j = 0 ; j < chArrLen; j++) {
                int[] pointer = { i, j };
                boolean bool = true;
                String ch = chArr[j];

                if (ch.equals("S")) cur = pointer;

                if (ch.equals("X")) bool = false;

                map.put(Arrays.toString(pointer), bool);
            }
        }

        Map<String, Integer> xyMap = new HashMap<>();
        Map<String, Integer> goBackMap = new HashMap<>();
        xyMap.put("E", 1); goBackMap.put("E", 1);
        xyMap.put("W", 1); goBackMap.put("W", -1);
        xyMap.put("S", 0); goBackMap.put("S", 1);
        xyMap.put("N", 0); goBackMap.put("N", -1);

        for (String s : routes) {
            String[] arr = s.split(" ");
            int xy = xyMap.get(arr[0]);
            int goOrBack = goBackMap.get(arr[0]);

            int step = Integer.parseInt(arr[1]);
            int[] tmp = cur.clone();
            boolean go = true;

            for (int i = 0; i < step; i++) {
                tmp[xy] += goOrBack;
                String pointer = Arrays.toString(tmp);
                go = map.getOrDefault(pointer, false);

                if (!go) break;
            }

            if (go) cur = tmp;
        }

//        return answer;
    }
}
