package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * problems-433 https://leetcode.cn/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        long count = Arrays.stream(bank).filter(p -> p.equals(endGene)).count();
        if (count == 0) {
            return -1;
        }
        Set<String> bankMap = new HashSet<>(Arrays.asList(bank));
        bankMap.add(endGene);
        char[] geneList = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int distance = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String cur = queue.poll();
                visited.add(cur);
                if (cur.equals(endGene)) {
                    return distance;
                }
                for (int p = 0; p < cur.length(); p++) {
                    char[] cs = cur.toCharArray();
                    for (char c : geneList) {
                        cs[p] = c;
                        String next = String.valueOf(cs);
                        if (bankMap.contains(next) && !visited.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }
}
