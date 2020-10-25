package nhn;

import java.util.*;

public class Q1 {

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        Map<Character, Integer> counts = new HashMap<>();
        char[] seats = new char[numOfAllPlayers - 1];

        for (int i = 1; i < numOfAllPlayers; i++) {
            seats[i - 1] = (char) (65 + i);
            counts.put((char) (65 + i), 0);
        }

        counts.put('A', 1);

        Set<Character> quickPlayers = new HashSet<>();

        for (int i = 0; i < numOfQuickPlayers; i++) {
            quickPlayers.add(namesOfQuickPlayers[i]);
        }

        char tagger = 'A';
        int now = 0;

        for (int i = 0; i < numOfGames; i++) {
            int move = numOfMovesPerGame[i];

            now += move;

            while (now < 0) {
                now += numOfAllPlayers - 1;
            }

            now %= numOfAllPlayers - 1;

            if (!quickPlayers.contains(seats[now])) {
                char temp = seats[now];
                seats[now] = tagger;
                tagger = temp;
            }

            counts.put(tagger, counts.get(tagger) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (char seat : seats) {
            sb.append(seat)
              .append(" ")
              .append(counts.get(seat))
              .append("\n");
        }

        sb.append(tagger)
          .append(" ")
          .append(counts.get(tagger));

        System.out.println(sb);
    }


    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < inputData.numOfGames; i++) {
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}
