/** 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * */
public class Test16 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = { {80, 20}, {50, 40}, {30, 10} }; // 3
//        int k = 4;
//        int[][] dungeons = { {4, 3}, {2, 2}, {2, 2}, }; // 2
//        int k = 40;
//        int[][] dungeons = {{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}}; // 4

        boolean[] visited = new boolean[dungeons.length];
        int answer = dfs(k, dungeons, 0, visited);
//        return answer;
    }

    // 질문 참고 dfs 알고리즘 사용
    private static int dfs(int k, int[][] dungeons, int route, boolean[] visited) {
        int max = route;
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (dungeon[0] > k || visited[i]) continue;

            visited[i] = true;
            max = Math.max(max, dfs(k - dungeon[1], dungeons, route + 1, visited));
            visited[i] = false;
        }
        return max;
    }
}
