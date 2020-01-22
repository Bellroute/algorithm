package beckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon1966 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int trial = scanner.nextInt();
        int[] results = new int[trial];
        scanner.nextLine();

        for (int i = 0; i < trial; i++) { // 입력 받은 시도 횟수만큼 코드 실행
            String input = scanner.nextLine();
            int N = Integer.parseInt(input.split(" ")[0]); // N, 문서의 수
            int target = Integer.parseInt(input.split(" ")[1]); // M, 위치를 알고자 하는 문서의 현재 위치
            int count = 0; // 몇 번째 출력인지 카운팅

            input = scanner.nextLine();

            LinkedList<Integer> queue = new LinkedList<>(); // 문서의 중요도를 순서대로 담을 큐
            LinkedList<Integer> sortedQueue = new LinkedList<>(); // 문서를 중요도 순으로 정렬 후 담을 큐
            int[] sortedNumbers = new int[N];

            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(input.split(" ")[j]));
                sortedNumbers[j] = Integer.parseInt(input.split(" ")[j]);
            }

            Arrays.sort(sortedNumbers);

            for (int j = 0; j < N; j++) {
                sortedQueue.offer(sortedNumbers[N - j - 1]);
            }

            while (!sortedQueue.isEmpty()) { // 큐에서 값을 다 꺼낼 때까지 실행
                int importance = sortedQueue.poll(); // 큐에 남아있는 문서 중 중요도가 가장 높은 문서의 중요도

                while (queue.peekFirst() != importance) { // 큐에 남아있는 문서 중 가장 높은 중요도와 큐의 첫 번째 문서의 중요도가 갖지 않은 경우, 같을 때까지 큐의 뒤로 넘김
                    int document = queue.poll();
                    queue.offer(document);

                    if (--target < 0) { // 해당 문서의 큐 순서가 달라질 때마다 나타내는 위치를 같이 이동 시킴. 0보다 작은 경우는 뒤로 넘어간 상황이기 때문에 다음과 같이 처리
                        target = queue.size() - 1;
                    }
                }

                queue.poll(); // 중요도가 높은 값을 큐에서 꺼냄
                count++; // 출력 횟수 기록

                if (--target < 0) { // 0보다 작아졌다는 것은 지켜보던 문서가 출력되었다는 것. 이 때의 출력 횟수가 답.
                    results[i] = count;
                    break;
                }
            }
        }

        for (int i = 0; i < trial; i++) {
            System.out.println(results[i]);
        }
    }
}
