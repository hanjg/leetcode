package math;

public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        //判断是否存在整数m,n使得m*x+n*y==z，即判断z是否为x,y最大公约数的倍数
    	if(z>x+y) return false;
    	return z==0||z%gcd(x, y)==0;
    }
    
    private int gcd(int x,int y){
    	return y==0?x:gcd(y, x%y);
    }

}
