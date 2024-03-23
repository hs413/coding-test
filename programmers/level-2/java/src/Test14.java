import java.util.HashMap;
import java.util.Map;

/** 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * */
public class Test14 {
    public static void main(String[] args) {
//        String[][] clothes = {
//            {"yellow_hat", "headgear"},
//            {"blue_sunglasses", "eyewear"},
//            {"green_turban", "headgear"}
//        }; //	5

        /*String[][] clothes = {
            {"crow_mask", "face"},
            {"blue_sunglasses", "face"},
            {"smoky_makeup", "face"}
        }; //	3*/

         String[][] clothes = {
            {"crow_mask", "face"},
            {"d", "face"},
            {"c", "face"},
            {"blue_sunglasses", "a"},
            {"smoky_makeup", "b"}
        }; //	16


        /* 질문 참고
         * 종류 별로 의상을 입지 않고 조합 하는 경우를 추가 해야 한다.
         * 아무 것도 입지 않는 경우는 없다
         * */
        //
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 1) + 1);
        }

        int answer = 1;
        for (int value : map.values()) {
            answer *= value;
        }

//        answer - 1;
    }
}
