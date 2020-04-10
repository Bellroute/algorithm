package programmers.dfs_and_bfs;

public class Network {

    private static boolean[] visited;
    private static int length;
    private static int answer = 0;
    private static int[][] networks;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println("answer: " + solution(n, computers1));
        answer = 0;
        System.out.println("answer: " + solution(n, computers2));
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        length = n;
        networks = computers;

        for (int i = 0; i < length; i++) {
            networks[i][i] = 0;
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                System.out.println(i);

                answer++;
                visited[i] = true;

                dfs(i);
            }
        }

        return answer;
    }

    private static void dfs(int computer) {

        for (int i = 0; i < length; i++) {
            if (networks[computer][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
