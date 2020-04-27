package line;

import java.util.*;

public class P4 {
    private static Map<String, String> accounts = new HashMap<>();
    private static Map<String, Transaction> logs = new HashMap<>();

    public static void main(String[] args) {
        String[][] snapshots = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
        String[][] transactions = {
                {"1", "SAVE", "ACCOUNT2", "100"},
                {"2", "WITHDRAW", "ACCOUNT1", "50"},
                {"1", "SAVE", "ACCOUNT2", "100"},
                {"4", "SAVE", "ACCOUNT3", "500"},
                {"3", "WITHDRAW", "ACCOUNT2", "30"}};

        String[][] result = solution(snapshots, transactions);

        for (String[] account : result) {
            System.out.println("[" + account[0] + ", " + account[1] + "]");
        }
    }

    public static String[][] solution(String[][] snapshots, String[][] transactions) {
        for (String[] snapshot : snapshots) {
            accounts.put(snapshot[0], snapshot[1]);
        }

        for (String[] transaction : transactions) {
            if (!logs.keySet().contains(transaction[0])) {
                logs.put(transaction[0], new Transaction(transaction[1], transaction[2], transaction[3]));
            }
        }

        for (Transaction transaction : logs.values()) {
            accounts.putIfAbsent(transaction.name, "0");

            if (transaction.isSaveType()) {
                save(transaction.name, Integer.parseInt(transaction.money));
                continue;
            }

            if (transaction.isWithdrawType()) {
                withdraw(transaction.name, Integer.parseInt(transaction.money));
            }

        }

        String[][] answer = new String[accounts.size()][2];

        int i = 0;
        for (String name : accounts.keySet()) {
            answer[i][0] = name;
            answer[i][1] = accounts.get(name);
            i++;
        }

        Collections.sort(Arrays.asList(answer), Comparator.comparing(o -> o[0]));

        return answer;
    }

    private static void withdraw(String name, int money) {
        int balance = Integer.parseInt(accounts.get(name));

        accounts.put(name, String.valueOf(balance - money));
    }

    private static void save(String name, int money) {
        int balance = Integer.parseInt(accounts.get(name));

        accounts.put(name, String.valueOf(balance + money));
    }

}

class Transaction {
    String type;
    String name;
    String money;

    public Transaction(String type, String name, String money) {
        this.type = type;
        this.name = name;
        this.money = money;
    }

    public boolean isSaveType() {
        return type.equals("SAVE");
    }

    public boolean isWithdrawType() {
        return type.equals("WITHDRAW");
    }
}
