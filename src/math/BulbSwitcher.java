package math;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
    	//第i个灯泡开关次数为i的约数的个数
    	//只有i为完全平方数，i的约数个数为奇数，第i个灯泡从off->on
    	return(int)Math.sqrt(n);
    }
}
