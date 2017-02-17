package math;


public class SelfCrossing {

    public boolean isSelfCrossing(int[] x) {
    	if (x.length<=3) {
			return false;
		}
    	for(int i=3;i<x.length;i++){
    		//第四条边和第一条边相交l4>=l2,l3<=l1
    		if (x[i]>=x[i-2]&&x[i-1]<=x[i-3]) {
				return true;
			}
    		//第五条边和第一条边相交l5+l1>=l3,l2=l4
    		else if (i>=4&&x[i]+x[i-4]>=x[i-2]&&x[i-1]==x[i-3]) {
				return true;
			}
    		//第六条边和第一条边相交l2<l4,l2+l6>=l4,l5<l3,l1+l5>=l3
    		else if (i>=5&&x[i-4]<x[i-2]&&x[i-4]+x[i]>=x[i-2]&&
    				x[i-1]<x[i-3]&&x[i-5]+x[i-1]>=x[i-3]) {
				return true;
			}
    	}
    	return false;
    }
}
