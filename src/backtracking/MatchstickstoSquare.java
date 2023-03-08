package backtracking;

import java.util.Arrays;

/**
 * problems-473 https://leetcode.cn/problems/matchsticks-to-square/
 */
public class MatchstickstoSquare {

    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = t;
        }
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int[] target = new int[4];
        Arrays.fill(target, sum / 4);
        return search(matchsticks, 0, target);
    }

    /**
     * @param matchIndex 放第几个火柴
     */
    private boolean search(int[] matchsticks, int matchIndex, int[] edgeTarget) {
        if (matchIndex == matchsticks.length) {
            return true;
        }
        //有4个边可以放置
        for (int i = 0; i < edgeTarget.length; i++) {
            if (matchsticks[matchIndex] > edgeTarget[i]) {
                continue;
            }
            edgeTarget[i] -= matchsticks[matchIndex];
            boolean res = search(matchsticks, matchIndex + 1, edgeTarget);
            if (res) {
                return true;
            }
            edgeTarget[i] += matchsticks[matchIndex];
        }
        return false;
    }
}
