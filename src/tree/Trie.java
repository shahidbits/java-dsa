package tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node currNode = root;

        for (char c : word.toCharArray()) {

            if (!currNode.children.containsKey(c)) {
                currNode.children.put(c, new Node());
            }

            currNode = currNode.children.get(c);
        }

        currNode.isWord = true;

    }

    public boolean search(String word) {

        Node currNode = root;

        for (char c : word.toCharArray()) {

            if (!currNode.children.containsKey(c)) {
                return false;
            } else {
                currNode = currNode.children.get(c);
            }
        }

        return currNode.isWord;
    }

    public boolean startsWith(String prefix) {

        Node currNode = root;

        for (char c : prefix.toCharArray()) {

            if (!currNode.children.containsKey(c)) {
                return false;
            } else {
                currNode = currNode.children.get(c);
            }
        }

        return true;
    }

    public class Node {

        Map<Character, Node> children;
        boolean isWord;

        public Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}
