package stack;
import java.util.*;

class NestedInteger {
     // Constructor initializes an empty nested list.
     public NestedInteger() {
	}

    // Constructor initializes a single integer.
     public NestedInteger(int value) {
	}

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger() {
		return false;
	}

     // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
     public Integer getInteger() {
		return null;
	}

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value) {
	}

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni) {
	}

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     List<NestedInteger> getList() {
		return null;
	}
 }
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s.length()==0)return null;
        if(s.charAt(0)!='[')return new NestedInteger(Integer.valueOf(s));//"234"类情况
        
        Stack<NestedInteger> stack=new Stack<>();
        NestedInteger cur=null;//指向正在处理的nestedinteger
        int start=0;//指向s中数字开始的下标
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if (c=='[') {
				if(cur!=null) stack.push(cur);
				cur=new NestedInteger();
				start=i+1;
			}
        	else if (c==']') {//]之前为]或者数字或者[
				if (start<i) {
					String num=s.substring(start, i);
					cur.add(new NestedInteger(Integer.valueOf(num)));
				}
				if (!stack.isEmpty()) {
					NestedInteger t=stack.pop();
					t.add(cur);
					cur=t;
				}
				start=i+1;
			}
        	else if (c==',') {//,之前为]或者数字
				if (start<i) {
					String num=s.substring(start, i);
					cur.add(new NestedInteger(Integer.valueOf(num)));
				}
				start=i+1;
			}
        }
        return cur;
    }

}
