import java.util.ArrayList;
import java.util.List;

/** 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * */
public class Test8 {
    public static void main(String[] args) {
//        int brown = 10; //[4, 3]
//        int brown = 8; //[3, 3]
//        int brown = 16; //[8, 6]
        int brown = 18; //[8, 6]
//        int yellow = 2;
//        int yellow = 1;
//        int yellow = 5;
        int yellow = 6;

        List<Integer> list = new ArrayList<>();
        int all = brown + yellow;
        int limit = brown / 2;

        for (int i = 3 ; i < limit; i++) {
            if (all % i == 0) list.add(i);
        }

        int[] answer = new int[2];

        for (Integer row : list) {
            int col = all / row;

            if (yellow == (row - 2) * (col - 2)) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }

        System.out.println("");

//        return answer;
    }
    // 다른 사람 풀이
    public int[] solution(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
}
