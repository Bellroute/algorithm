package naverHackday;

public class WinterQuestion3 {

    public int solution(String command, String[] buttons, int[] scores) {
        char[] arr = new char[command.length()];

        for (int i = 0; i < command.length(); i++) {
            arr[i] = command.charAt(i);
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < command.length(); j++) {
                for (int k = 0; k <  buttons[i].length(); k++) {
                    if (arr[j] == buttons[i].charAt(k)) {

                    }
                }
            }


        }

        int answer = 0;
        return answer;
    }
}
