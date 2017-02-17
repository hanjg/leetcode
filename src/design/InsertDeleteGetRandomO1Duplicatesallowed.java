package design;

import java.util.*;

public class InsertDeleteGetRandomO1Duplicatesallowed {
	List<Integer> data;
	HashMap<Integer, TreeSet<Integer>> map;//存储数据和下标的列表（下标一定要从小到大排列）
	Random random;
	
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed() {
    	data=new ArrayList<>();
    	map=new HashMap<>();
    	random=new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        data.add(val);
        if(!map.containsKey(val))map.put(val, new TreeSet<Integer>());
        map.get(val).add(data.size()-1);
        return map.get(val).size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        TreeSet<Integer> set=map.get(val);//val对应的下标栈
        int id=set.pollLast();//删除的val的下标
        if(id!=data.size()-1){
        	Integer last=data.get(data.size()-1);
        	data.set(id, last);
        	TreeSet<Integer> temp=map.get(last);
        	//将temp中last的下标改为id
        	temp.pollLast();//temp的最后一个元素为last的下标（temp中由小到大排列）
        	temp.add(id);
        }
        data.remove(data.size()-1);
        if(set.isEmpty())map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}
