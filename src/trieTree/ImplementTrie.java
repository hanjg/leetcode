package trieTree;

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
            TrieNode currentNode = parentNode.children[c - 'a'];
            if (currentNode == null) {
                currentNode = new TrieNode(c);
                parentNode.children[c - 'a'] = currentNode;
            }
            parentNode = currentNode;
        }
        parentNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                return null;
            }
            cur = next;
        }
        return cur;
    }

    private static class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children;

        public TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

}
