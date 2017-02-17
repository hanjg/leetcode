package greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	//总加油量大于等于消耗的油量则一定有解
        int start=0,tank=0,total=0;
        //tank从start开到下一站油箱剩余的油量,total为从0出发到start的净油量
        for(int i=0;i<gas.length;i++){
        	tank+=gas[i]-cost[i];
        	if (tank<0) {
				total+=tank;tank=0;start=i+1;
			}
        }
        return total+tank<0?-1:start;
    }

}
