import java.util.HashSet;
import java.util.Set;

/** Greedy 체육복
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

        int answer = n;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reservable = new HashSet<>();

        for (int l : lost) {
            lostSet.add(l);
        }

        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
                continue;
            }

            reservable.add(r);
        }

        for (int i = 1; i <= n; i++) {
            boolean isLost = lostSet.contains(i);

            if (!isLost) {
                continue;
            }

            if (reservable.contains(i - 1)) {
                reservable.remove(i - 1);
                continue;
            }

            if (reservable.contains(i + 1)) {
                reservable.remove(i + 1);
                continue;
            }

            answer--;
        }
    }
}
