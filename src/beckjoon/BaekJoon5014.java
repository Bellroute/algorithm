package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon5014 {

    private static final String IMPASSIBLE_MESSAGE = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;

        Queue<Button> queue = new LinkedList<>();
        queue.offer(new Button(x, y));

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Button button = queue.poll();

            if (U * button.upCount - D * button.downCount + S == G) {
                min = Math.min(min, button.downCount + button.upCount);
                continue;
            }

            if (U * (button.upCount + 1) - D * button.downCount + S <= F && !visited[U * (button.upCount + 1) - D * button.downCount + S]) {
                queue.offer(new Button(button.upCount + 1, button.downCount));
                visited[U * (button.upCount + 1) - D * button.downCount + S] = true;
            }

            if (U * button.upCount - D * (button.downCount + 1) + S >= 1 && !visited[U * button.upCount - D * (button.downCount + 1) + S]) {
                queue.offer(new Button(button.upCount, button.downCount + 1));
                visited[U * button.upCount - D * (button.downCount + 1) + S] = true;
            }

        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(IMPASSIBLE_MESSAGE);
        } else {
            System.out.println(min);
        }
    }

    static class Button {
        private int upCount;
        private int downCount;

        public Button(int upCount, int downCount) {
            this.upCount = upCount;
            this.downCount = downCount;
        }
    }
}
