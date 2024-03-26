/** 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * */
public class Test19 {
    public static void main(String[] args) {
//        int[] numbers = { 1, 1, 1, 1, 1 }; // 5
//        int target = 3;
        int[] numbers = { 4, 1, 2, 1 }; // 2
        int target = 4;

        int answer = func(numbers, 0, 0, target);
    }

    public static int func(int[] numbers, int i, int sum, int target) {
        if (numbers.length == i) return sum == target ? 1 : 0;

        int number = numbers[i];
        return func(numbers, i + 1,number + sum, target) + func(numbers, i + 1, -1 * number + sum, target);
    }
}

