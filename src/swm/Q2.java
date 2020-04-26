package swm;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPersons = scanner.nextInt();
        int numOfRelations = scanner.nextInt();

        List<Point> totals = new ArrayList<>();

        for (int i = 0; i < numOfPersons; i++) {
            totals.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        Map<Integer, Set<Integer>> relations = new HashMap<>();

        for (int i = 0; i < numOfRelations; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            if (relations.containsKey(a) || relations.containsKey(b)) {

                if (relations.containsKey(a)) {
                    Set<Integer> get = relations.get(a);

                    get.add(b);
                    relations.put(a, get);

                } else if (relations.containsKey(b)) {
                    Set<Integer> get = relations.get(b);

                    get.add(a);
                    relations.put(b, get);
                }

            } else {
                Set<Integer> tmp = new HashSet<>();

                tmp.add(b);
                tmp.add(a);
                relations.put(a, tmp);
            }
        }

        Set<Set<Integer>> please = new HashSet<>();

        for (int i = 0; i < numOfPersons; i++) {
            Set<Integer> set = new HashSet<>();

            for (java.util.Map.Entry<Integer, Set<Integer>> entry : relations.entrySet()) {
                if (entry.getValue().contains(i)) {
                    set.addAll(entry.getValue());
                }
            }

            if (set.isEmpty()) {
                set.add(i);
            }

            please.add(set);
        }

        int answer = 0;

        for (Set<Integer> entry : please) {
            if (entry.size() == 1) {
                continue;
            }

            int min_x = Integer.MAX_VALUE;
            int max_x = Integer.MIN_VALUE;
            int min_y = Integer.MAX_VALUE;
            int max_y = Integer.MIN_VALUE;

            for (int el : entry) {
                min_x = Math.min(min_x, totals.get(el).x);
                max_x = Math.max(max_x, totals.get(el).x);
                min_y = Math.min(min_y, totals.get(el).y);
                max_y = Math.max(max_y, totals.get(el).y);
            }

            answer = Math.max(answer, (max_y - min_y + max_x - min_x) * 2);
        }

        System.out.println(answer);
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
