package greedy;

public class Candy {
	public int candy(int[] ratings) {
		int[] amount=new int[ratings.length];
		amount[0]=1;
		for(int i=1;i<ratings.length;i++){
			amount[i]=ratings[i]>ratings[i-1]?amount[i-1]+1:1;
		}
		for(int i=ratings.length-2;i>=0;i--){
			if (ratings[i]>ratings[i+1]&&amount[i]<=amount[i+1]) {//<=保证amount的值不会减小
				amount[i]=amount[i+1]+1;
			}
		}
		int sum=0;
		for(int i=0;i<amount.length;i++){
			sum+=amount[i];
		}
		return sum;
    }

}
