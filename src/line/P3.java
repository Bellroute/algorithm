package line;

public class P3 {

    private static char[] arr;
    private static int answer = 0;

    public static void main(String[] args) {
        String road1 = "111011110011111011111100011111";
        int n1 = 3;
        String road2 = "001100";
        int n2 = 5;

        System.out.println(solution(road1, n1));
        answer = 0;
        System.out.println(solution(road2, n2));
    }

    public static int solution(String road, int n) {
        arr = road.toCharArray();
        dfs(0, n);

        return answer;
    }

    private static void dfs(int index, int n) {
        if (n == 0 || isFinished()) {
            int length = getLongestRoad();
            answer = Math.max(answer, length);
        } else {
            for (int i = index; i < arr.length; i++) {
                if (arr[i] == '0') {
                    arr[i] = '1';
                    dfs(i, n - 1);
                    arr[i] = '0';
                }
            }
        }
    }

    private static int getLongestRoad() {
        String arrToStr = String.valueOf(arr);
        String[] road = arrToStr.split("0");

        int max = road[0].length();
        for (int i = 1; i < road.length; i++) {
            max = Math.max(max, road[i].length());
        }

        return max;
    }

    private static boolean isFinished() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                return false;
            }
        }

        return true;
    }
}
