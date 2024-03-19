import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 신고 결과 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * 이용자의 ID가 담긴 문자열 배열 id_list
 * 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report
 * 정지 기준이 되는 신고 횟수 k
 * 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
* */
public class Test3 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // [2,1,1,0]
//        String[] id_list = {"con", "ryan"}; //[0,0]
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
//        int k = 3;

        int[] answer = new int[id_list.length];

        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String r : report) {
            String[] tmp = r.split(" ");
            String reporter = tmp[0];
            String target = tmp[1];

            Set<String> set = reportMap.getOrDefault(reporter, new HashSet<>());
            if (set.contains(target)) continue;;

            set.add(target);
            reportMap.put(reporter, set);
            countMap.put(target, countMap.getOrDefault(target, 0) + 1);
        }

        int i = 0;
        for (String id : id_list) {
            Set<String> set = reportMap.getOrDefault(id, new HashSet<>());
            int count = 0;

            for (String target : set) {
                int a = countMap.getOrDefault(target, 0);
                if (a >= k) count++;
            }

            answer[i++] = count;
        }

        System.out.println("a");
//        return answer;
    }
}
