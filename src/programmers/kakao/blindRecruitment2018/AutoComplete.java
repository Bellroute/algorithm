package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class AutoComplete {

    @Test
    public void test() {
        String[] words1 = {"go", "gone", "guild"};
        String[] words2 = {"abc", "def", "ghi", "jklm"};
        String[] words3 = {"word", "war", "warrior", "world"};

        assertEquals(7, solution(words1));
        assertEquals(4, solution(words2));
        assertEquals(15, solution(words3));
    }

    public int solution(String[] words) {
        int answer = 0;
        Tire tire = new Tire();

        for (String word : words) {
            tire.insert(word);
        }

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                answer++;
                String str = word.substring(0, i);

                if (tire.find(str).size() == 1) {
                    break;
                }
            }
        }

        return answer;
    }
}

class Tire {
    Node root;

    public Tire() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);

            if (current.getChild(alphabet) != null) {
                current = current.getChild(alphabet);
            } else {
                current = current.putChild(alphabet);
            }
        }

        current.isLeaf = true;
    }

    public List<Node> find(String word) {
        List<Node> nodeList = new ArrayList<>();
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);

            if (current.getChild(alphabet) != null) {
                current = current.getChild(alphabet);
            } else {
                nodeList.clear();
                return nodeList;
            }
        }

        if (current.isLeaf) {
            nodeList.add(current);
        }

        nodeList.addAll(current.getAllChildren());

        return nodeList;
    }
}

class Node {
    char alphabet;
    boolean isLeaf;
    Map<Character, Node> children;

    public Node(char alphabet) {
        this.alphabet = alphabet;
        this.isLeaf = false;
        this.children = new HashMap<>();
    }

    public Node getChild(char alphabet) {
        return children.get(alphabet);
    }

    public Node putChild(char alphabet) {
        Node node = new Node(alphabet);
        children.put(alphabet, node);

        return node;
    }

    public List<Node> getAllChildren() {
        List<Node> nodeList = new ArrayList<>();

        for (Node node : children.values()) {
            if (node.isLeaf) {
                nodeList.add(node);
            }

            nodeList.addAll(node.getAllChildren());
        }

        return nodeList;
    }
}
