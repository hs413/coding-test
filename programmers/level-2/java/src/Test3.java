import java.util.Arrays;

/** 최솟값 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * 길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
 * 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다.
 * 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
 * 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
 *
 * 예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면
 * A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
 * A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
 * A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
 * 즉, 이 경우가 최소가 되므로 29를 return 합니다.
* */
public class Test3 {
    public static void main(String[] args) {
//        int[] A = { 1, 4, 2 }; //29
        int[] A = {1,2};
//        int[] B = { 5, 4, 4 }; //10
        int[] B = {3,4};

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            answer += A[i] * B[j];
        }

//      return answer ;
        System.out.println();
    }

    // 다른 사람 풀이 퀵정렬
    public static void quickSort(int[] arr, int left, int right)
    {
        int i, j, pivot, tmp;

        if (left < right) {
            i = left;
            j = right;
            pivot = arr[left];
            //분할 과정
            while (i < j) {
                while (arr[j] > pivot) j--;
                while (i < j && arr[i] <= pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            arr[left] = arr[i];
            arr[i] = pivot;
            //정렬 과정
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
