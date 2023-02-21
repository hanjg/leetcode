package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * problems-464 https://leetcode.cn/problems/can-i-win/
 */
public class CanIWin {
    private Map<Integer, Boolean> history;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1+maxChoosableInteger)*maxChoosableInteger /2 < desiredTotal){
            return false;
        }
        history = new HashMap<>();
        int used = 0; //bitmap状态压缩
        return first(used, maxChoosableInteger, desiredTotal);
    }

    private boolean first(int used, int maxChoosableInteger, int desiredTotal){
        //hashmap记忆化搜索
        if (history.containsKey(used)){
            return history.get(used);
        }
        for (int target = maxChoosableInteger; target >= 1; target--){
            if ((used & (1<< target)) > 0){
                continue;
            }
            if (target >= desiredTotal){
                history.put(used, true);
                return true;
            }
            boolean result = first(used | (1 << target), maxChoosableInteger, desiredTotal - target);
            if (!result){
                history.put(used, true);
                return true;
            }
        }
        history.put(used, false);
        return false;
    }
}
