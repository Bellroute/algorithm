package programmers.kakao.internship2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Level4_CaveAdventure {

    private int n;
    private List<Integer> map[];
    private int[] before;
    private int[] next;
    private boolean[] visited;

    public boolean solution(int n, int[][] path, int[][] order) {
        this.n = n;
        map = new ArrayList[n];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < path.length; i++) {
            int room1 = path[i][0];
            int room2 = path[i][1];

            map[room1].add(room2);
            map[room2].add(room1);
        }

        before = new int[n];
        next = new int[n];

        for (int i = 0; i < order.length; i++) {
            int a = order[i][0];
            int b = order[i][1];

            before[b] = a;
        }

        if (before[0] != 0) {
            return false;
        }

        visited = new boolean[n];
        visited[0] = true;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < map[0].size(); i++) {
           stack.add(map[0].get(i));

           while (!stack.isEmpty()) {
               int now = stack.pop();

               if (visited[now]) {
                   continue;
               }

               if (!visited[before[now]]) {
                   next[before[now]] = now;
                   continue;
               }

               visited[now] = true;

               for (int j = 0; j < map[now].size(); j++) {
                   stack.add(map[now].get(j));
               }

               stack.add(next[now]);
           }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
