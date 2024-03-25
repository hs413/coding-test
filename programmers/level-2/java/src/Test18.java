import java.util.Arrays;

/** 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * */
public class Test18 {
    public static void main(String[] args) {
        String[] phoneBook = {"999", "119", "97674223", "1195524421"}; //	false
//        String[] phoneBook = {"123","456","789"}; //	true
//        String[] phoneBook = {"12","123","1235","567","88"}; //	false
//        String[] phoneBook = {"12","432","4324","567","88"}; //	false

        boolean answer = true;
        int len = phoneBook.length;

        Arrays.sort(phoneBook);

        out: for (int i = 0; i < len - 1; i++) {
            String a = phoneBook[i];

            for (int j = i + 1; j < len; j++) {
                String b = phoneBook[j];

                if (a.length() > b.length()) continue out;

                if (b.startsWith(a)) {
                    answer = false;
                    break out;
                }
            }
        }

        System.out.println();
    }
}

