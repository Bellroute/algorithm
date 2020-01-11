package beckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11650 {

    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x > p.x) {
                return 1;
            } else if (this.x < p.x) {
                return -1;
            } else {
                if (this.y > p.y) {
                    return 1;
                } else if (this.y < p.y) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Point[] list = new Point[N];

        for (int i = 0; i < N; i++) {
            list[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(list);

        for (int i = 0; i < N; i++) {
            System.out.println(list[i].x + " " + list[i].y);
        }
    }
}
