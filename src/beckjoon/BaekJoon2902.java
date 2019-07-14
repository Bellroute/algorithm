package beckjoon;

        import java.util.Scanner;

public class BaekJoon2902 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();

        output.append(input.split("")[0]);

        for (int i = 1; i < input.length(); i++) {
            if (input.split("")[i].equals("-")) {
                output.append(input.split("")[i + 1]);
            }
        }

        System.out.println(output.toString());
    }
}
