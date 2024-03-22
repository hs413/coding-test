import java.util.HashMap;
import java.util.Map;

/** 할인 행사
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * */
public class Test12 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"}; // 3
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();

        int wantLen = want.length;
        int wantCnt = 0;
        for (int i = 0; i < wantLen; i++) {
            wantMap.put(want[i], number[i]);
            wantCnt += number[i];
        }

        int discountLen = discount.length;
        outer: for (int i = 0; i + wantCnt <= discountLen; i++) {
            Map<String, Integer> remainMap = new HashMap<>();

            for (int j = i; j < i + wantCnt; j++) {
                String item = discount[j];

                if (!wantMap.containsKey(item)) {
                    i = j;
                    continue outer;
                }

                if (!remainMap.containsKey(item)) {
                    remainMap.put(item, wantMap.get(item));
                }

                int remain = remainMap.get(item);

                if (remain < 1) {
                    continue outer;
                }

                remainMap.put(item, remain - 1);
            }

            answer++;
        }

    }
}
