package stack;

import java.util.*;

public class FlattenNestedListIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack=new Stack<>();
        for(int i=nestedList.size()-1;i>=0;i--){//从后向前放入stack
        	stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {//将stack顶处理为isInteger
        while(!stack.isEmpty()){
        	NestedInteger cur=stack.peek();
        	//考虑cur为整数
        	if (cur.isInteger()) {
				return true;
			}
        	//cur为表
        	stack.pop();
        	for(int i=cur.getList().size()-1;i>=0;i--){
        		stack.push(cur.getList().get(i));
        	}
        }
        return false;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
