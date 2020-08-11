package sorting;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 7, 3, 6, 5, 4, 9, 8};
        print(numbers);
        System.out.println();
        int[] selectionSortNumbers = selectionSort(numbers);

        numbers = new int[]{1, 2, 7, 3, 6, 5, 4, 9, 8};
        int[] insertionSortNumbers = insertionSort(numbers);

        numbers = new int[]{1, 2, 7, 3, 6, 5, 4, 9, 8};
        int[] bubbleSortNumbers = bubbleSort(numbers);

        numbers = new int[]{1, 2, 7, 3, 6, 5, 4, 9, 8};
        int[] mergeSortNumbers = mergeSort(numbers);

        numbers = new int[]{1, 2, 7, 3, 6, 5, 4, 9, 8};
        int[] quickSortNumbers = quickSort(numbers, 0, numbers.length - 1);

        numbers = new int[]{1, 2, 7, 3, 6, 5, 4, 9, 8};
        int[] heapSortNumbers = heapSort(numbers);

        print(selectionSortNumbers);
        print(insertionSortNumbers);
        print(bubbleSortNumbers);
        print(mergeSortNumbers);
        print(quickSortNumbers);
        print(heapSortNumbers);
    }

    private static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private static int[] selectionSort(int[] numbers) {
        // 시간복잡도 O(n^2)
        // 공간복잡도 O(1)

        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;

            for (int j = i; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }

            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }

        return numbers;
    }

    private static int[] insertionSort(int[] numbers) {
        // 시간복잡도 O(n^2) 이미 정렬되어 있는 경우는 O(n)
        // 공간복잡도 O(1)

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 1; j < i; j++) {
                if (numbers[j - 1] < numbers[i] && numbers[i] <= numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    break;
                }
            }
        }

        return numbers;
    }

    private static int[] bubbleSort(int[] numbers) {
        // 시간복잡도 O(n^2)
        // 공간복잡도 O(1)

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        return numbers;
    }

    private static int[] mergeSort(int[] numbers) {
        // 시간복잡도 O(NlogN)
        // 공간복잡도 O(N)

        if (numbers.length < 2) {
            return numbers;
        }

        int mid = numbers.length / 2;
        int[] low = mergeSort(Arrays.copyOfRange(numbers, 0, mid));
        int[] high = mergeSort(Arrays.copyOfRange(numbers, mid, numbers.length));

        return sort(low, high);
    }

    private static int[] sort(int[] low, int[] high) {
        int[] result = new int[low.length + high.length];

        int lowPoint = 0;
        int highPoint = 0;

        for (int i = 0; i < result.length; i++) {
            if (lowPoint == low.length) {
                result[i] = high[highPoint];
                highPoint++;
                continue;
            }

            if (highPoint == high.length) {
                result[i] = low[lowPoint];
                lowPoint++;
                continue;
            }

            if (low[lowPoint] < high[highPoint]) {
                result[i] = low[lowPoint];
                lowPoint++;
            } else {
                result[i] = high[highPoint];
                highPoint++;
            }
        }

        return result;
    }

    private static int[] quickSort(int[] numbers, int left, int right) {
        // 시간복잡도 O(NlogN) 최악의 경우(pivot값이 편향적일 경우) O(N^2)
        // 공간복잡도 O(logN)

        int i, j, pivot, tmp;

        if (left < right) {
            i = left;
            j = right;
            pivot = numbers[(left + right) / 2];

            while (i < j) {
                while (numbers[j] > pivot) j--;
                while (numbers[i] < pivot) i++;

                tmp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tmp;
            }


            quickSort(numbers, left, i - 1);
            quickSort(numbers, i + 1, right);
        }

        return numbers;
    }

    private static int[] heapSort(int[] numbers) {
        // 시간 복잡도 O(NlogN)
        // 공간 복잡도 O(1)

        for (int i = numbers.length / 2 - 1; i >= 0; i--) {
            heapify(numbers, numbers.length, i);
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;

            heapify(numbers, i,0);
        }

        return numbers;
    }

    private static void heapify(int[] numbers, int size, int node) {
        int parent = node;
        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        if (leftChild < size && numbers[leftChild] > numbers[parent]) {
            parent = leftChild;
        }

        if (rightChild < size && numbers[rightChild] > numbers[parent]) {
            parent = rightChild;
        }

        if (parent != node) {
            int temp = numbers[node];
            numbers[node] = numbers[parent];
            numbers[parent] = temp;

            heapify(numbers, size, parent);
        }
    }
}
