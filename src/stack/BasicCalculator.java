package stack;

import java.util.Stack;

public class BasicCalculator {
	Stack<Character> operator;
	Stack<Integer> num;
	

	public char priority(char a,char b){//操作符的优先级
		if (a=='+'||a=='-') {
			if (b=='(') {
				return '<';
			}
		}
		if (a=='(') {
			if (b=='+'||b=='-'||b=='(') {
				return '<';
			}
			if (b==')') {
				return '=';
			}
		}
		return '>';
	}
	
    public int calculate(String s) {
    	num=new Stack<>();operator=new Stack<>();
        for(int i=0;i<s.length();i++){
        	char ch=s.charAt(i);
        	if(ch==' ') continue;
        	if (Character.isDigit(ch)) {
        		int temp=ch-'0';
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
					temp=10*temp+s.charAt(i+1)-'0';i++;
				}
				num.push(temp);
			}
        	else if (operator.isEmpty()) {
				operator.push(ch);
			}
        	else {
				switch (priority(operator.peek(), ch)) {
				case '<':
					operator.push(ch);
					break;
				case '=':
					operator.pop();
					break;
				case '>':
					char op=operator.pop();
					int b=num.pop(),a=num.pop();
					if (op=='+') num.push(a+b);
					if(op=='-') num.push(a-b);
					i--;
				}
			}
        }
        while(!operator.isEmpty()){
			char op=operator.pop();
			int b=num.pop(),a=num.pop();
			if (op=='+') num.push(a+b);
			if(op=='-') num.push(a-b);
        }
        return num.peek();
    }
    public int calculate2(String s) {
    	int res=0;
    	Stack<Integer> stack=new Stack<>();//存储当前括号的符号
    	stack.push(1);
    	int sign=1;//记录当前数字或者括号的符号
    	
    	s=s.replace(" ","");
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(c=='+')sign=1;
    		else if(c=='-')sign=-1;
    		else if(c=='('){
    			stack.push(stack.peek()*sign);
    			sign=1;
    		}
    		else if (c==')') {
				stack.pop();
			}
    		else {
				int t=c-'0';
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
					i++;
					t=10*t+s.charAt(i)-'0';
				}
				res+=t*sign*stack.peek();
			}
    	}
    	return res;
	}

	public static void main(String[] args) {
    	System.out.println(new BasicCalculator().calculate("1-11"));
    }

}
