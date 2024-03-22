import java.util.Arrays;

/** H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * */
public class Test13 {
    public static void main(String[] args) {
//        int[] citations = { 3, 0, 6, 1, 5 }; // 3
//        int[] citations = { 10, 45, 22, 8,66,38,59, 7, 9 }; // 8
//        int[] citations = { 42, 22 }; // 2
//        int[] citations = { 3, 4 }; // 2
//        int[] citations = {1,10,11}; // return 2;
//      int[] citations = {10,11}; // return 2;
//      int[] citations = {0,0,0,0,0}; // return 0;
      int[] citations = {1,1,1,1,1}; // return 1;

        int answer = 0;
        Arrays.sort(citations);

        int cnt = 0;
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            int c = citations[i];
            if (c < 1) continue;

            int h = len - (i + 1);
            if (c <= h) answer = h;
            cnt++;
        }

        if (answer == 0) answer = cnt;

//        return answer;

        System.out.println();
    }

    // 다른 사람 풀이
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
