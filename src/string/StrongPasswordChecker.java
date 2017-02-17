package string;

public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
    	if(s.length()<=2)return 6-s.length();
    	int replace=0,paritcular=0;//要替换的数量和需要特别替换（缺少的类型）的数量
    	int[] delete=new int[3];//delete[1]表示可以用1次删除代替的1次replace的数量
    	//delete[2]表示可以用2次删除代替的1次replace的数量
    	char end=s.charAt(0);
    	int repeat=1;//end重复的次数
    	boolean up=Character.isUpperCase(end),low=Character.isLowerCase(end);
    	boolean digit=Character.isDigit(end);//是否出现这三种类型的字符
    	for(int i=1;i<s.length();i++){
    		if(s.charAt(i)==end)repeat++;
    		else {
				replace+=repeat/3;
				if(repeat>=3)delete[repeat%3+1]++;
				
				end=s.charAt(i);repeat=1;
				up=up||Character.isUpperCase(s.charAt(i));
				low=low||Character.isLowerCase(s.charAt(i));
				digit=digit||Character.isDigit(s.charAt(i));
			}
    	}
		replace+=repeat/3;
		if(repeat>=3)delete[repeat%3+1]++;
		paritcular=(up?0:1)+(low?0:1)+(digit?0:1);
		if(s.length()<6)return Math.max(6-s.length(), Math.max(paritcular, replace));
		else if(s.length()<=20)return Math.max(paritcular, replace);
		else {
			int todel=s.length()-20;
			if(todel<=delete[1])replace-=todel;
			else if(todel<=delete[1]+2*delete[2])replace-=delete[1]+(todel-delete[1])/2;
			else replace-=delete[1]+delete[2]+(todel-delete[1]-delete[2]*2)/3;//???
			return todel+Math.max(replace, paritcular);
		}
    }
    
    public static void main(String[] args) {
		System.out.println(new StrongPasswordChecker().strongPasswordChecker("aaaaaaaaaaaaa"));
	}
}
