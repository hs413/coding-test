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

        // 첫 번째 - map 활용
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

        out: for (String s : routes) {
            String[] arr = s.split(" ");
            int xy = xyMap.get(arr[0]);
            int goOrBack = goBackMap.get(arr[0]);

            int step = Integer.parseInt(arr[1]);
            int[] tmp = cur.clone();

            for (int i = 0; i < step; i++) {
                tmp[xy] += goOrBack;
                String pointer = Arrays.toString(tmp);
                boolean go = map.getOrDefault(pointer, false);

                if (!go) continue out;
            }

            cur = tmp;
        }

        // 두 번째 - 배열 활용
        int[] cur = new int[2];
        int parkLen = park.length;
        int range = park[0].length();
        String[][] parks = new String[parkLen][];

        boolean findS = false;
        for (int i = 0; i < parkLen; i ++) {
            String s = park[i];
            parks[i] = s.split("");

            if (!findS) {
                int idx = s.indexOf("S");

                if (idx >= 0) {
                    cur = new int[] { i, idx };
                    findS = true;
                }
            }
        }

        Map<String, Integer> xyMap = new HashMap<>();
        Map<String, Integer> goBackMap = new HashMap<>();
        xyMap.put("E", 1); goBackMap.put("E", 1);
        xyMap.put("W", 1); goBackMap.put("W", -1);
        xyMap.put("S", 0); goBackMap.put("S", 1);
        xyMap.put("N", 0); goBackMap.put("N", -1);

        out: for (String s : routes) {
            String[] arr = s.split(" ");
            int xy = xyMap.get(arr[0]);
            int goOrBack = goBackMap.get(arr[0]);
            int step = Integer.parseInt(arr[1]);

            int outRange = xy == 0 ? parkLen : range;
            int totalStep = goOrBack * step + cur[xy];

            if (totalStep < 0 || outRange <= totalStep) continue;

            int[] tmp = cur.clone();

            for (int i = 0; i < step; i++) {
                tmp[xy] += goOrBack;
                boolean stop = parks[tmp[0]][tmp[1]].equals("X");

                if (stop) continue out;
            }

            cur = tmp;
        }

//        return answer;
    }
}
