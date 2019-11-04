package naverHackday;

import java.util.*;

public class WinterQuestion2 {
    private static int[] xMovement = {1, 0, -1, 0};
    private static int[] yMovement = {0, 1, 0, -1};

    private static char[][] map;
    private static boolean[][] visited;

    private static Map<Character, String> store = new HashMap<>();

    public static void main(String[] args) {
        String[] input = {"..........", "AAACC.....", ".AAA.....Z", "..AAAA..C.", "...BBBBB..", "....BBB...", "...ZBBB...", "ZZZZAAAC..", ".....CCCC.", "QQ......C.", ".........."};
//        solution(input);

        System.out.println(store);
    }

    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != '.') {
                    bfs(i, j);
                }
                visited[i][j] = true;
            }
        }

        int[] answer = new int[2];

        answer[0] = checkCase();
        answer[1] = checkLength();

        return answer;
    }

    private static int checkLength() {
        int max = 0;
        Set set = store.keySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){

            String key = (String) iterator.next();

            if (store.get(key).length() > max) {
                max = store.get(key).length();
            }
        }

        return 0;
    }

    private static int checkCase() {
        return 0;
    }

    private static void bfs(int x, int y) {
        Queue<Pointer> queue = new LinkedList<>();

        Pointer point = new Pointer(x, y);

        queue.add(point);

        while (!queue.isEmpty()) {
            Pointer p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + xMovement[i];
                int newY = p.y + yMovement[i];

                if (newX > 0 && newX < map.length && newY > 0 && newY < map[0].length && map[newX][newY] != '.') {
                    if (map[p.x][p.y] == map[newX][newY] && !visited[newX][newY]) {
                        queue.add(new Pointer(newX, newY));
                        visited[newX][newY] = true;

                        continue;
                    }

                    if (map[p.x][p.y] != map[newX][newY]) {
                        if (store.get(map[p.x][p.y]) == null) {
                            store.put(map[p.x][p.y], String.valueOf(map[newX][newY]));
                        } else {
                            if (!store.get(map[p.x][p.y]).contains(String.valueOf(map[newX][newY]))) {
                                store.put(map[p.x][p.y], store.get(map[p.x][p.y]) + map[newX][newY]);
                            }
                        }
                    }
                }
            }
        }
    }
}

class Pointer {
    int x;
    int y;

    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
