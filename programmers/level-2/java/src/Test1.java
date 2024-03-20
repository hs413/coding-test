import java.util.Arrays;

/** 최댓값과 최솟값
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
* */
public class Test1 {
    public static void main(String[] args) {
//        "1 2 3 4"	"1 4"
//        "-1 -2 -3 -4"	"-4 -1"
//        "-1 -1"	"-1 -1"

//        String s = "1 2 3 4";
        String s = "-1 -2 -3 -4";
//        String s = "-1 -1";

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        String[] arr = s.split(" ");

        for (String str : arr) {
            int cur = Integer.parseInt(str);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        String answer = min + " " + max;
//        return min + " " + max;

        System.out.println();
    }

    // 다른 유저 풀이
    // Arrays.stream().min() .max 메서드 사용 풀이
    public String getMinMaxString(String str) {
        String[] arrStr = str.split(" ");
        int[] arrInt = new int[arrStr.length];
        int i=0;
        for(String part : arrStr){
            arrInt[i] = Integer.parseInt(part);
            i++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());

        return sb.toString();
    }
}
