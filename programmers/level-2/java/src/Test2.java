import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/** JadenCase 문자열 만들기
 * JadenCase란 모든 단어의 첫 문자가 대문자이고,
 * 그 외의 알파벳은 소문자인 문자열입니다.
 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
* */
public class Test2 {
    public static void main(String[] args) {
        String s = " 32f unFollowed me    ";//	"3people Unfollowed Me"
//        String s = "for the last week"; //	"For The Last Week"

        StringBuilder sb = new StringBuilder();
        Arrays
            .stream(s.toLowerCase().split(""))
            .reduce("", (acc, cur) -> {
                if (acc.isBlank()) {
                    sb.append(cur.toUpperCase());
                } else {
                    sb.append(cur);
                }

                return cur;
            });


        String answer = sb.toString();
//        return answer ;
    }
}
