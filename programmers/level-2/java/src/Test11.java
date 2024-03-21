import java.util.HashSet;
import java.util.Set;

/** 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * */
public class Test11 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4}; //18
        int len = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            int element = elements[i];
            set.add(element);

            int j = i % len + 1;
            int limit = i + len;

            while (j < limit) {
                element += elements[j % len];
                set.add(element);
                j++;
            }
        }

        int answer = set.size();
    }
}
