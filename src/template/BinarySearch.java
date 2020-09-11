package template;

public class BinarySearch {

    private static int answer = 0;
    private static int total;

    private static void binarySearch(int[] arr, int min, int max) {
        int start = min;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int element : arr) {
                if (element > mid) {
                    sum += mid;
                } else {
                    sum += element;
                }
            }

            if (sum < total) {
                start = mid + 1;
            } else if (sum > total){
                end = mid - 1;
            } else {
                answer = mid;
                return;
            }
        }

        answer = end;
    }
}
