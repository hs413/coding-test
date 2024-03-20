import java.util.HashMap;
import java.util.Map;

/** 달리기 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
 * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
 * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
 * 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
 * 제한사항
 * 5 ≤ players의 길이 ≤ 50,000
 *      players[i]는 i번째 선수의 이름을 의미합니다.
 *      players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
 *      players에는 중복된 값이 들어가 있지 않습니다.
 *      3 ≤ players[i]의 길이 ≤ 10
 * 2 ≤ callings의 길이 ≤ 1,000,000
 *      callings는 players의 원소들로만 이루어져 있습니다.
 *      경주 진행중 1등인 선수의 이름은 불리지 않습니다.
* */
public class Test5 {
    public static void main(String[] args) {
        // 5 ≤ players의 길이 ≤ 50,000
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        // 2 ≤ callings의 길이 ≤ 1,000,000
        String[] callings = {"kai", "kai", "mine", "mine"};

        Map<String, Integer> map = new HashMap<>();

        int i = 0;
        for (String s: players) {
            map.put(s, i++);
        }

        for (String s: callings) {
            int idx = map.get(s);
            int fIdx = idx - 1;

            String f = players[fIdx];
            players[fIdx] = s;
            players[idx] = f;

            map.put(s, fIdx);
            map.put(f, idx);
        }
    }
}
