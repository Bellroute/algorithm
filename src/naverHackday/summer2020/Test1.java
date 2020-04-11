package naverHackday.summer2020;

public class Test1 {

    private static char[] stocks;

    public static void main(String[] args) {
        int[][] delivery = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};

        System.out.println(solution(6, delivery));
    }

    public static String solution(int n, int[][] delivery) {
        stocks = new char[n];

        for (int i = 0; i < n; i++) {
            stocks[i] = '?';
        }

        for (int i = 0; i < delivery.length; i++) {
            setFinishedDelivery(delivery[i]);
        }

        for (int i = 0; i < delivery.length; i++) {
            setLeftDelivery(delivery[i]);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < stocks.length; i++) {
            answer.append(stocks[i]);
        }

        return answer.toString();
    }

    private static void setLeftDelivery(int[] order) {
        if (order[2] == 0) {
            if (stocks[order[0] - 1] == 'O') {
                stocks[order[1] - 1] = 'X';
            } else if (stocks[order[1] - 1] == 'O') {
                stocks[order[0] - 1] = 'X';
            }
        }
    }

    private static void setFinishedDelivery(int[] order) {
        if (order[2] == 1) {
            stocks[order[1] - 1] = 'O';
            stocks[order[2] - 1] = 'O';
        }
    }

}
