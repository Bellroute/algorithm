package programmers.kakao.blindRecruitment2020;

import java.util.HashMap;
import java.util.Map;

public class Level4_LyricSearch {

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] tries = new Trie[10001];
        Trie[] reversedTries = new Trie[10001];


        for (String word : words) {
            int wordLength = word.length();

            if (tries[wordLength] == null) {
                tries[wordLength] = new Trie();
                reversedTries[wordLength] = new Trie();
            }

            tries[wordLength].insert(word);
            reversedTries[wordLength].insert(new StringBuilder(word).reverse().toString());
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int wordLength = query.length();

            if (tries[wordLength] == null) {
                answer[i] = 0;
                continue;
            }

            if (query.charAt(0) == '?') {
                answer[i] = reversedTries[wordLength].getCount(new StringBuilder(query).reverse().toString());
                continue;
            }

            answer[i] = tries[wordLength].getCount(query);
        }

        return answer;
    }

    class Trie {
        private Node rootNode;

        public Trie() {
            this.rootNode = new Node();
        }

        public void insert(String word) {
            Node thisNode = rootNode;

            for (int i = 0; i < word.length(); i++) {
                thisNode.count++;
                thisNode = thisNode.children.computeIfAbsent(word.charAt(i), node -> new Node());
            }

            thisNode.setLast(true);
        }


        public int getCount(String word) {
            Node thisNode = rootNode;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (character == '?') {
                    break;
                }

                if (!thisNode.getChildren().containsKey(character)) {
                    return 0;
                }

                thisNode = thisNode.getChildren().get(character);
            }

            return thisNode.count;
        }
    }

    class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean isLast;
        private int count;

        public int getCount() {
            return count;
        }

        public Map<Character, Node> getChildren() {
            return this.children;
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }

        public boolean isLast() {
            return this.isLast;
        }

        public void setLast(boolean last) {
            this.isLast = last;
        }
    }
}
