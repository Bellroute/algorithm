package line;

public class P2 {
    private static int max = 0;

    public static void main(String[] args) {
        String answerSheet1 = "4132315142";
        String[] sheets1 = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
        String answerSheet2 =  "53241";
        String[] sheets2 = {"53241", "42133", "53241", "14354"};
        String answerSheet3 = "24551";
        String[] sheets3 = {"24553", "24553", "24553", "24553"};

        System.out.println(solution(answerSheet1, sheets1));
        max = 0;
        System.out.println(solution(answerSheet2, sheets2));
        max = 0;
        System.out.println(solution(answerSheet3, sheets3));

    }

    public static int solution(String answerSheet, String[] sheets) {
        for (int i = 0; i < sheets.length - 1; i++) {
            String tester1 = sheets[i];

            for (int j = i + 1; j < sheets.length; j++) {
                int total = 0;
                int combo = 0;
                int continuous = 0;

                String tester2 = sheets[j];

                for (int k = 0; k < tester1.length(); k++) {
                    if (tester1.charAt(k) == tester2.charAt(k)) {
                        if (tester1.charAt(k) == answerSheet.charAt(k)) {
                            combo = 0;
                        } else {
                            total++;
                            combo++;
                            continuous = Math.max(continuous, combo);
                        }
                    } else {
                        combo = 0;
                    }
                }

                int level = total + continuous * continuous;
                max = Math.max(max, level);
            }

        }

        return max;
    }
}
