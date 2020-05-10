package binarySearch;

import java.util.Arrays;

/**
 * problems-1011 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r) {
            //中点偏左
            int m = l + (r - l) / 2;
            if (!canLoad(weights, D, m)) {
                //左端点+1
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean canLoad(int[] weights, int D, int load) {
        int indexWeight = 0;
        for (int day = 0; day < D; day++) {
            int loaded = 0;
            while (loaded + weights[indexWeight] <= load) {
                loaded += weights[indexWeight++];
                if (indexWeight >= weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
