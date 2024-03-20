import java.util.stream.IntStream;

/** 피보나치 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 * */
public class Test7 {
    public static void main(String[] args) {
        int n = 99;

        int a = 0;
        int b = 1;
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }

//        return answer;
    }
}
