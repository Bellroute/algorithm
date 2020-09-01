package programmers.kakao.winterInternship2019;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class AbusingUser {

    private String[] userId;
    private String[] bannedId;
    private Set<List<String>> result;

    @Test
    public void test() {
        assertEquals(2, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println();
        assertEquals(2, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println();
        assertEquals(3, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        userId = user_id;
        bannedId = banned_id;
        result = new HashSet<>();

        boolean[] visited = new boolean[user_id.length];

        dfs(0, 0, visited);
        answer = result.size();

        Iterator<List<String>> iterator = result.iterator();

        while (iterator.hasNext()) {
            List<String> list = iterator.next();
            System.out.println(list);
        }

        return answer;
    }

    private void dfs(int index, int n, boolean[] visited) {
        if (n == bannedId.length) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    list.add(userId[i]);
                }
            }

            result.add(list);

            return;
        }

        for (int i = 0; i < userId.length; i++) {
            String s = bannedId[index].replace("*", ".");
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(userId[i]);

            if (matcher.find() && userId[i].length() == bannedId[index].length()) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(index + 1, n + 1, visited);
                    visited[i] = false;
                }
            }


        }
    }
}
