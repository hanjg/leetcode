package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * problems-451 https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        //按照频率，桶排序
        String[] subList = new String[s.length() + 1];
        Arrays.fill(subList, "");
        for (Character c : counter.keySet()) {
            int count = counter.get(c);
            String sub = subList[count];
            subList[count] = sub + c;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            String sub = subList[i];
            if ("".equals(sub)) {
                continue;
            }
            for (char c : sub.toCharArray()) {
                int count = i;
                while (count-- > 0) {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
