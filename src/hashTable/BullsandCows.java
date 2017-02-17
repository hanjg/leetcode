package hashTable;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        int[] map=new int[10];//记录当前各个数字s中的数量-g中的数量 >0secret多，<0guess多
        int bulls=0,cows=0;
        for(int i=0;i<secret.length();i++){
        	int s=secret.charAt(i)-'0';
        	int g=guess.charAt(i)-'0';//secret,guess当前的数字
        	if(s==g)bulls++;
        	else {
        		if(map[g]>0)cows++;
        		if(map[s]<0)cows++;
        		map[g]--;map[s]++;
        	}
        }
        return bulls+"A"+cows+"B";
    }
}
