package kakaoEnterprise.summer2020;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTeams = scanner.nextInt();
        int inputCount = numberOfTeams * (numberOfTeams - 1);

        Map<String, Team> teams = new HashMap<>();

        scanner.nextLine();

        for (int i = 0; i < inputCount; i++) {
            String[] matchResult = scanner.nextLine().split(" ");

            String nameOfHomeTeam = matchResult[0];
            int scoreOfHomeTeam = Integer.parseInt(matchResult[1]);
            String nameOfAwayTeam = matchResult[2];
            int scoreOfAwayTeam = Integer.parseInt(matchResult[3]);

            Team homeTeam = teams.getOrDefault(nameOfHomeTeam, new Team(nameOfHomeTeam));
            Team awayTeam = teams.getOrDefault(nameOfAwayTeam, new Team(nameOfAwayTeam));

            if (scoreOfHomeTeam == 2) {
                homeTeam.setWinner();
                awayTeam.setLoser();
            } else if (scoreOfAwayTeam == 2) {
                awayTeam.setWinner();
                homeTeam.setLoser();
            }

            homeTeam.setDifference(scoreOfHomeTeam, scoreOfAwayTeam);
            awayTeam.setDifference(scoreOfAwayTeam, scoreOfHomeTeam);

            teams.put(nameOfHomeTeam, homeTeam);
            teams.put(nameOfAwayTeam, awayTeam);
        }

        List<Team> teamList = new ArrayList<>(teams.values());
        Collections.sort(teamList);

        for (Team team : teamList) {
            System.out.println(team.print());
        }
    }
}

class Team implements Comparable<Team> {
    private String name;
    private int win;
    private int lose;
    private int winLoseDifference;

    public Team(String name) {
        this.name = name;
    }

    public void setWinner() {
        this.win++;
    }

    public void setLoser() {
        this.lose++;
    }

    @Override
    public int compareTo(Team otherTeam) {
        if (this.win == otherTeam.win) {
            return otherTeam.winLoseDifference - this.winLoseDifference;
        }

        return otherTeam.win - this.win;
    }

    public String print() {
        return String.format("%s %d %d", name, win, winLoseDifference);
    }

    public void setDifference(int myScore, int otherScore) {
        winLoseDifference += (myScore - otherScore);
    }
}
