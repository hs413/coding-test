import java.util.Arrays;

/** N개의 최소공배수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 * */
public class Test10 {
    public static void main(String[] args) {
//        int[] arr = {2, 6, 8, 14}; //	168
//        int[] arr = {1,2,3}; //	6
        int[] arr = {1}; //	6
//        int[] arr = {1,2}; //	6

        int answer = 0;
        Arrays.sort(arr);

        int last = arr[arr.length - 1];
        int first = Math.max(arr[0], 2);

        boolean bool = false;
        while (!bool) {
            int cm = last * first++;

            bool = Arrays.stream(arr).allMatch((i -> cm % i == 0));

            if (bool) {
                answer = cm;
            }
        }

        System.out.println();

    }

    // 다른 사람 풀이
    public int solution(int[] num) {
        int answer = num[0], g;
        for (int i = 1; i < num.length; i++) {
            g = gcd(answer, num[i]);
            answer = g * (answer / g) * (num[i] / g);
        }
        return answer;
    }

    public int gcd(int a, int b) {
        if (a > b)
            return (a % b == 0) ? b : gcd(b, a % b);
        else
            return (b % a == 0) ? a : gcd(a, b % a);
    }
}
