package design;

import java.util.*;

public class InsertDeleteGetRandomO1 {
	List<Integer> data;
	HashMap<Integer, Integer> address;
	Random random;
	
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        data=new ArrayList<>();//存储数据
        address=new HashMap<>();//K=数据,V=数据在data中的下标
        random=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(address.containsKey(val))return false;
        data.add(val);
        address.put(val, data.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!address.containsKey(val))return false;
        int id=address.get(val);
        if(id!=data.size()-1){//防止删除val引起之后的数据下标变化
        	Integer last=data.get(data.size()-1);
        	//修改原来的最后一个元素在data中的位置和address中的数值
        	data.set(id, last);
        	address.put(last, id);
        }
        address.remove(val);data.remove(data.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }


}
