import java.util.HashMap;
import java.util.Map;

/** 가장 많이 받은 선물
 * 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
 * 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
 * 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
 * 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
 * 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
 * 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
 * */
public class Test4 {
    public static void main(String[] args) {
//        String[] friends = {"muzi", "ryan", "frodo", "neo"}; // 2
//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"}; // 4
        String[] friends = {"a", "b", "c"}; // 0
//        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};

        Map<String, Map<String, Integer>> giftMap = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        for (String s : gifts) {
            String[] tmp = s.split(" ");
            String giver = tmp[0];
            String taker = tmp[1];

            scoreMap.put(giver, scoreMap.getOrDefault(giver, 0) + 1);
            scoreMap.put(taker, scoreMap.getOrDefault(taker, 0) - 1);

            Map<String, Integer> map = giftMap.getOrDefault(giver, new HashMap<>());
            map.put(taker, map.getOrDefault(taker, 0) + 1);
            giftMap.put(giver, map);
        }

        Map<String, Integer> mmap = new HashMap<>();
        int friendsLen = friends.length;
        int answer = 0;

        for (int i = 0; i < friendsLen - 1; i++) {
            String giver = friends[i];
            Map<String, Integer> giverMap = giftMap.getOrDefault(giver, new HashMap<>());

            for (int j = i + 1; j < friendsLen; j++) {
                String taker = friends[j];
                Map<String, Integer> takerMap = giftMap.getOrDefault(taker, new HashMap<>());

                int n = giverMap.getOrDefault(taker, 0) - takerMap.getOrDefault(giver, 0);

                if (n == 0) {
                    n = scoreMap.getOrDefault(giver, 0) - scoreMap.getOrDefault(taker, 0);
                }

                if (n > 0) {
                    int s = mmap.getOrDefault(giver, 0) + 1;
                    mmap.put(giver, s);
                    answer = Math.max(answer, s);
                }

                if (n < 0) {
                    int s = mmap.getOrDefault(taker, 0) + 1;
                    mmap.put(taker, s);
                    answer = Math.max(answer, s);
                }

                takerMap.remove(giver);
            }
        }

//        return answer;
    }
}
