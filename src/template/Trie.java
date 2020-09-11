package template;

import java.util.HashMap;
import java.util.Map;

public class Trie {

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
