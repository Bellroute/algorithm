package programmers.dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WordChange {

    private String[] map;
    private boolean[] visited;
    private int targetIndex;
    private int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {


        map = words.clone();

        if (!isContain(words, target)) {
            return 0;
        }

        for (int i = 0; i < map.length; i++) {
            if (words[i].equals(target)) {
                targetIndex = i;
                break;
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (isOnlyOneDifferentCharacter(begin, map[i])) {
                visited = new boolean[map.length];
                visited[i] = true;
                bfs(i);
            }
        }

        return answer;
    }

    private void bfs(int index) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(index, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (map[point.index].equals(map[targetIndex])) {
                answer = Math.min(answer, point.depth);
                return;
            }

            for (int i = 0; i < map.length; i++) {
                if (!visited[i] && isOnlyOneDifferentCharacter(map[point.index], map[i])) {
                    visited[i] = true;
                    queue.add(new Point(i, point.depth + 1));
                }
            }
        }
    }

    private boolean isOnlyOneDifferentCharacter(String now, String word) {
        int count = 0;

        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != word.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    private boolean isContain(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }

        return false;
    }

    private class Point {
        private int index;
        private int depth;

        public Point(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
