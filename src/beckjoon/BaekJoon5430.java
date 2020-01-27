package beckjoon;

import java.util.*;

public class BaekJoon5430 {
    private static final String FORMAT_ERROR = "error";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        String[] results = new String[T];
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String p = scanner.nextLine();
            String[] formatted_p = p.split("");

            int n = scanner.nextInt();
            scanner.nextLine();

            String input = scanner.nextLine();

            if (isError(formatted_p, n)) {
                results[i] = FORMAT_ERROR;
                continue;
            }

            String[] formattedInput = input.replace("[", "").replace("]", "").split(",");
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(formattedInput));

            boolean isReverse = false;
            for (String order : formatted_p) {

                switch (order) {
                    case "R":
                        isReverse = !isReverse;
                        break;
                    case "D":
                        if (isReverse) {
                            list.remove(list.size() - 1);
                        } else {
                            list.remove(0);
                        }
                        break;
                }
            }

            if (isReverse) {
                Collections.reverse(list);
            }

            results[i] = formatResult(list);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(results[i]);
        }
    }

    private static String formatResult(List<String> list) {
        StringBuilder format = new StringBuilder();

        format.append("[");
        list.forEach(element -> format.append(element + ","));
        format.append("]");

        return format.toString().replace(",]", "]");
    }


    private static boolean isError(String[] p, int n) {
        int count = 0;

        for (String s : p) {
            if (s.equals("D")) {
                count++;
            }
        }

        return n < count;
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int T = scanner.nextInt();
//        String[] results = new String[T];
//        scanner.nextLine();
//
//        for (int i = 0; i < T; i++) {
//            String p = scanner.nextLine();
//            String[] formatted_p = p.split("");
//
//            int n = scanner.nextInt();
//            scanner.nextLine();
//
//            String input = scanner.nextLine();
//
//            if (isError(formatted_p, n)) {
//                results[i] = FORMAT_ERROR;
//                continue;
//            }
//
//            String[] formattedInput = input.replace("[", "").replace("]", "").split(",");
//            List<String> list = new ArrayList<>();
//            list.addAll(Arrays.asList(formattedInput));
//
//            for (String order : formatted_p) {
//
//                switch (order) {
//                    case "R":
//                        Collections.reverse(list);
//                        break;
//                    case "D":
//                        list.remove(0);
//                        break;
//                }
//            }
//
//            results[i] = formatResult(list);
//        }
//
//        for (int i = 0; i < T; i++) {
//            System.out.println(results[i]);
//        }
//    }
//
//    private static String formatResult(List<String> list) {
//        StringBuilder format = new StringBuilder();
//
//        format.append("[");
//        list.forEach(element -> format.append(element + ","));
//        format.append("]");
//
//        return format.toString().replace(",]", "]");
//    }
//
//
//    private static boolean isError(String[] p, int n) {
//        int count = 0;
//
//        for (String s : p) {
//            if (s.equals("D")) {
//                count++;
//            }
//        }
//
//        return n < count;
//    }
}
