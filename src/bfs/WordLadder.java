package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * problems-127 https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

    /**
     * 单向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();//存储曾经存入队列的单词
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int num = queue.size();
            length++;
            for (int i = 0; i < num; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {//修改cur的位置下标
                    char[] chars = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if (next.equals(endWord)) {
                            return length;
                        }
                        if (wordList.contains(next) && !set.contains(next)) {
                            queue.add(next);
                            set.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 双向BFS
     */
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        //初始长度
        int len = 1;
        HashSet<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//            if (beginSet.size() > endSet.size()) {
//                Set<String> set = beginSet;
//                beginSet = endSet;
//                endSet = set;
//            }
            Set<String> nextSet = new HashSet<>();
            for (String beginStr : beginSet) {
                char[] cs = beginStr.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = cs[i];
                        cs[i] = c;
                        String nextWord = String.valueOf(cs);
                        if (endSet.contains(nextWord)) {
                            return len + 1;
                        }
                        if (!visited.contains(nextWord) && wordList.contains(nextWord)) {
                            nextSet.add(nextWord);
                            visited.add(nextWord);
                        }
                        cs[i] = oldChar;
                    }
                }
            }
            beginSet = nextSet;
            len++;
        }
        return 0;
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String[] strings = {"hot","dot","dog","lot","log"};
        for (int i = 0; i < strings.length; i++) {
            set.add(strings[i]);
        }
        WordLadder test = new WordLadder();
        System.out.println(test.ladderLength2("hit", "cog", set));
    }

}
