package weekly;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/destroying-asteroids/
 */
public class DestroyingAsteroids {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curMass = mass;
        for (int m : asteroids) {
            if (curMass < m) {
                return false;
            }
            curMass += m;
        }
        return true;
    }
}
