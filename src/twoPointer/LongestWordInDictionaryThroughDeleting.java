package twoPointer;

import java.util.Arrays;
import java.util.List;

/**
 * problems-524 https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String candidate : d) {
            int i = 0;//s
            int j = 0;//candidate
            while (i < s.length() && j < candidate.length()) {
                if (s.charAt(i) == candidate.charAt(j)) {
                    j++; //如果字符相等，子序列、父序列指针后移
                    i++; 
                } else {
                    i++; //父序列指针后移
                }
            }
            if (j == candidate.length()) {
                //符合条件(candidate是s的子序列)，比较长度和字典序
                if (candidate.length() > res.length() || (candidate.length() == res.length()
                        && candidate.compareTo(res) < 0)) {
                    res = candidate;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionaryThroughDeleting()
                .findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
