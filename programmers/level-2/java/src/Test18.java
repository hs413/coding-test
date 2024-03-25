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

        for (int i = 0; i < len - 1; i++) {
            String a = phoneBook[i];
            String b = phoneBook[i + 1];

            answer = b.startsWith(a);

            if (!answer) break;
        }
    }
}

