import java.util.PriorityQueue;
import java.util.Queue;

/** 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * */
public class Test20 {
    public static void main(String[] args) {
//        int[] scoville = { 1, 2, 6, 9, 10, 12 }; // 2
//        int K = 7;
//        int[] scoville = { 1, 2, 2, 6, 9, 10, 12 }; // 2
//        int K = 7;
        int[] scoville = { 1, 2 }; // 2
        int K = 2;

        Queue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            if (s < K) queue.add(s);
        }

        boolean everyUnder = queue.size() == scoville.length;
        int answer = 0;
        int overScov = 0;

        while(queue.size() > 1) {
            int newScov = queue.poll() + queue.poll() * 2;
            answer++;

            if (newScov >= K) {
                overScov = newScov;
                continue;
            }

            queue.add(newScov);
        }

        answer += queue.size();

//        return everyUnder && overScov == 0 ? -1 : answer;
    }
}

