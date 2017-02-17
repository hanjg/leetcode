package dfs;
import java.util.*;
public class LexicographicalNumbers {
	List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res=new ArrayList<>();
        pickNext(0,0,n);
        return res;
    }
    private void pickNext(int pos,int pre,int n){
    	for(int i=pos==0?1:0;i<=9;i++){
    		int cur=10*pre+i;
    		if(cur>n) break;
    		res.add(cur);
    		pickNext(pos+1, cur, n);
    	}
    }
    public List<Integer> lexicalOrder2(int n) {
	    List<Integer>res=new ArrayList<>();
	    int cur=1;
	    for(int i=1;i<=n;i++){
	    	res.add(cur);
	    	if(cur*10<=n)cur*=10;
	    	else if(cur%10!=9&&cur+1<=n)cur++;
	    	else{//末尾是9
	    		while((cur/10)%10==9)cur/=10;
	    		cur=cur/10+1;
	    	}
	    }
	    return res;
	}
	public static void main(String[] args) {
		System.out.println(new LexicographicalNumbers().lexicalOrder(13));
	}
}
