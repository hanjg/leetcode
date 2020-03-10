package design;

/**
 * problems-208 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTrie {

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode parentNode = root;
        for (char c : word.toCharArray()) {
            TrieNode curNode = parentNode.getChild(c);
            if (curNode == null) {
                curNode = new TrieNode(c);
            }
            parentNode.addChild(c, curNode);
            parentNode = curNode;
        }
        parentNode.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word, root);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix, root);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix, TrieNode parentNode) {
        TrieNode curNode = null;
        for (char c : prefix.toCharArray()) {
            curNode = parentNode.getChild(c);
            if (curNode == null) {
                return curNode;
            }
            parentNode = curNode;
        }
        return curNode;
    }

    class TrieNode {

        private char val;
        private boolean isEnd;
        private TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
        }

        public void addChild(char c, TrieNode child) {
            this.children[c - 'a'] = child;
        }

        public TrieNode getChild(char c) {
            return this.children[c - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public void unSetEnd() {
            this.isEnd = false;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}