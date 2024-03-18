import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 프로그래머스 Greedy 체육복
 *
 * 전체 학생의 수는 2명 이상 30명 이하
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * */
public class Test1 {
    public static void main(String[] args) {
        int n = 5;
//        int n = 4;
//        int[] lost = {2, 4};
        int[] lost = {2, 3};
//        int[] reserve = {1, 3, 5};
        int[] reserve = {3};

//        5	[2, 4]	[3]	4
//        3	[3]	[1]	2

        Arrays.sort(lost);
        int answer = n - lost.length;
        Set<Integer> set = new HashSet<>();

        for (int r : reserve) {
            set.add(r);
        }

        List<Integer> rentable = new ArrayList<>();
        for (int l : lost) {
            if (set.contains(l)) {
                answer++;
                set.remove(l);
                continue;
            }
            rentable.add(l);
        }

        for (int r : rentable) {
            int f = r - 1;
            int b = r + 1;

            if (set.contains(f)) {
                answer++;
                set.remove(f);
                continue;
            }

            if (set.contains(b)) {
                answer++;
                set.remove(b);
            }
        }
    }
}
