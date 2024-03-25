import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * */
public class Test17 {
    public static void main(String[] args) {
//        int[] priorities = { 2, 1, 3, 2 }; // 1
//        int location = 2;
//        int[] priorities = { 1, 1, 9, 1, 1, 1 }; // 5
//        int location = 0;
//        int[] priorities = { 1, 2, 2, 2, 3, 2 }; // 5
//        int location = 3;
        int[] priorities = { 2, 3, 2, 1, 2 }; // 2
        int location = 2;
//        int[] priorities = { 2,3,3,2,9,3,3 }; // 6
//        int location = 3;

        int len = priorities.length;
        int ordinal = 1;

        Queue<int[]> queue = new LinkedList<>();
        int[] ordinals = new int[len];
        int[] sorted = priorities.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < len; i++) {
            queue.add(new int[] { priorities[i], i });
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int process = tmp[0];
            int idx = tmp[1];

            if (process == sorted[sorted.length - ordinal]) {
                ordinals[idx] = ordinal;
                ordinal++;
                if (idx == location) break;
                continue;
            }

            queue.add(tmp);
        }
//        return ordinals[location];
    }
}

