import java.util.ArrayList;
import java.util.List;

/** 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * */
public class Test15 {
    public static void main(String[] args) {
//        int[] progresses = { 93, 30, 55 }; //[2, 1]
//        int[] speeds = { 1, 30, 5 };
        int[] progresses = { 95, 90, 99, 99, 80, 99 }; //[1, 3, 2]
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        List<Integer> list = new ArrayList<>();
        int COMPLETE = 100;
        int len = progresses.length;
        int cnt = 0;
        int prev = 0;

        for (int i = 0; i < len; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int remain = (int) Math.ceil((double)(COMPLETE - progress) / speed);

            if (prev > 0 && prev < remain) {
                list.add(cnt);
                cnt = 0;
            }
            cnt++;
            prev = Math.max(prev, remain);
        }

        if (cnt > 0) list.add(cnt);

        int listLen = list.size();
        int[] answer = new int[listLen];

        for(int i = 0; i < listLen; i++) {
            answer[i] = list.get(i);
        }

//        return answer;
        // return list.stream().mapToInt(i->i).toArray();
    }
}
