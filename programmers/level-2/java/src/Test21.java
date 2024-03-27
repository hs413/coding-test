/** 큰 수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * */
public class Test21 {
    public static void main(String[] args) {
//      String number =  "1924"; // "94"
//      int k = 2;
      String number = "1231234"; // "3234"
//      String number = "31234515311234"; // "3234"
      int k = 3;
//        String number = "4177252841"; // "775841"
//        int k = 4;
//        String number = "99999999999"; // "99999"
//        int k = 4;
//        String number = "1234567890123456789012345678901234567890"; // "99999"
//        int k = 1;
//        String number = "111191111"; // "91111"
//        int k = 5;

        solution(number, k);
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number.length());
        int kClone = k;

        sb.append(number.charAt(0));
        for (int i = 1 ; i < number.length() ; i++) {
            char current = number.charAt(i);
            int compared = current - number.charAt(i - 1);
            sb.append(current);

            while (compared > 0 && sb.length() > 1 && k > 0) {
                int j = sb.length() - 1;
                int sbCompared = sb.charAt(j) - sb.charAt(j - 1);

                if (sbCompared <= 0) break;

                sb.deleteCharAt(j - 1);
                k--;
            }
        }

        return sb.substring(0, number.length() - kClone);
    }
}

