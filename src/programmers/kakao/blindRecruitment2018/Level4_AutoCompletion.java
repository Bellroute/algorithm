package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Level4_AutoCompletion {

    @Test
    public void test() {
        assertEquals(7, solution(new String[]{"go", "gone", "guild"}));
        assertEquals(4, solution(new String[]{"abc", "def", "ghi", "jklm"}));
        assertEquals(15, solution(new String[]{"word", "war", "warrior", "world"}));

    }

    public int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            Node thisNode = trie.root;

            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChild(word.charAt(i));

                if (i == word.length() - 1) {
                    answer += word.length();
                    break;
                }

                if (thisNode.numberOfChildren == 1) {
                    answer += i + 1;
                    break;
                }

            }
        }

        return answer;
    }

    class Trie {
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node thisNode = root;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (!thisNode.children.containsKey(character)) {
                    thisNode.insert(character);
                }

                thisNode = thisNode.getChild(character);
                thisNode.numberOfChildren++;
            }
        }
    }

    class Node {
        private char character;
        private int numberOfChildren = 0;
        private Map<Character, Node> children = new HashMap<>();


        public Node() {
        }

        public Node(char character) {
            this.character = character;
        }

        public void insert(char character) {
            children.put(character, new Node(character));
        }

        public Node getChild(char character) {
            return children.get(character);
        }
    }
}
