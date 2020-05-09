package programmers.kakao.summerinternship2020;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class P1 {

    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private int[] leftNumbers = {1, 4, 7};
    private int[] rightNumbers = {3, 6, 9};
    private int[][] keypad = new int[4][3];
    private boolean[][] visited = new boolean[4][3];
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    @Test
    public void test() {
        System.out.println("test1");
        assertEquals("LRLLLRLLRRL", solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println("test2");
        assertEquals("LRLLRRLLLRR", solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println("test3");
        assertEquals("LLRLLRLLRL", solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        keypad[3][0] = 1;
        keypad[3][2] = 2;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(keypad[j][k]);
                }
                System.out.println();
            }

            if (isLeft(numbers[i])) {
                answer.append(LEFT);
                changeFinger(numbers[i], 1);
                System.out.println("left");
            } else if (isRight(numbers[i])) {
                answer.append(RIGHT);
                changeFinger(numbers[i], 2);
                System.out.println("right");
            } else {
                int x = (numbers[i] - 1) / 3;
                int y = (numbers[i] - 1) % 3;

                int leftDistance = bfs(x, y, 1);
                int rightDistance = bfs(x, y, 2);

                System.out.println(numbers[i]);

                System.out.println(leftDistance);
                System.out.println(rightDistance);
                System.out.println();

                if (leftDistance < rightDistance) {
                    answer.append(LEFT);
                    changeFinger(numbers[i], 1);
                    System.out.println("left");
                } else if (leftDistance > rightDistance) {
                    answer.append(RIGHT);
                    changeFinger(numbers[i], 2);
                    System.out.println("right");
                } else {
                    if (hand.equals("left")) {
                        answer.append(LEFT);
                        changeFinger(numbers[i], 1);
                        System.out.println("left");
                    } else {
                        answer.append(RIGHT);
                        changeFinger(numbers[i], 2);
                        System.out.println("right");
                    }
                }
            }
        }

        return answer.toString();
    }

    private int bfs(int x, int y, int finger) {
        visited = new boolean[4][3];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        int depth = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = true;

            if (keypad[point.x][point.y] == finger) {
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                System.out.println("finger: " + finger);
                depth = point.depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (inArea(newX, newY) && !visited[newX][newY]) {
                    queue.add(new Point(newX, newY, point.depth + 1));
                }
            }
        }

        return depth;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < 4 && newY >= 0 && newY < 3;
    }

    private void changeFinger(int number, int finger) {
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 3; k++) {
                if (keypad[j][k] == finger) {
                    keypad[j][k] = 0;
                }
            }
        }


        System.out.println("x: " + number / 3);
        System.out.println("y: " + (number - 1) % 3);
        System.out.println("finger: " + finger);

        keypad[(number - 1) / 3][(number - 1) % 3] = finger;

    }

    private boolean isRight(int number) {
        for (int i = 0; i < rightNumbers.length; i++) {
            if (number == rightNumbers[i]) {
                return true;
            }
        }

        return false;
    }

    private boolean isLeft(int number) {
        for (int i = 0; i < leftNumbers.length; i++) {
            if (number == leftNumbers[i]) {
                return true;
            }
        }

        return false;
    }
}

class Point {
    int x;
    int y;
    int depth;

    public Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
