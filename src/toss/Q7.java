package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int startingNumber = Integer.parseInt(input.split(";")[0]);
        String[] memories = input.split(";")[1].split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0; ");

        int pointer = startingNumber;
        while (true) {

            if (Integer.parseInt(memories[pointer]) == 0) {
                stringBuilder.append(pointer + " ");
                pointer = Integer.parseInt(memories[startingNumber + 1]);
                stringBuilder.append(pointer + " ");
                continue;
            }


        }
    }
}
