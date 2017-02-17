package twoPointer;
import java.util.*;
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res=new ArrayList<>();
    	int len=words[0].length();
    	if(words.length*len>s.length())return res;
    	
    	HashMap<String , Integer> map=new HashMap<>();//建立words中单词和下标的映射
    	int[] count=new int[words.length];//words中各个的单词数量
    	int amount=words.length;//words中不重复的单词的数量
    	int[] exsit=new int[s.length()-len+1];
    	//以s中下标为i的字符开始的单词在words中，存在即为words中的下标，若不存在则为-1
    	int[] need=new int[words.length];//维护的窗口中还需要的各个单词数量
    	
    	int index=0;//单词映射的下标
    	for(int i=0;i<words.length;i++){
    		Integer address=map.get(words[i]);//words[i]映射的下标
    		if (address==null) {
				address=index++;
    			map.put(words[i], address);
			}
    		else amount--;
    		count[address]++;
    	}
    	for(int i=0;i<=s.length()-len;i++){
    		Integer address=map.get(s.substring(i, i+len));
    		exsit[i]=address==null?-1:address;
    	}
    	
    	for(int i=0;i<len;i++){
    		int begin=i,end=i;//将要维护的窗口[begin,end+len)，初始为[i,i);
    		need=Arrays.copyOf(count, count.length);
    		int left=amount;//窗口中还需要的words中不重复单词的数量
    		while(end<=s.length()-len){
    			while(left>0&&end<=s.length()-len){
    				//exsit[end]==-1时可以扩展end，因为最后会计算end-begin==words.length*len
    				//或者可以从end+len开始重新维护一个初始长度为0的窗口
    				if(exsit[end]!=-1&&--need[exsit[end]]==0)left--;
    				/*if (exsit[end]==-1) {
						begin=end+len;end=begin-len;
						need=Arrays.copyOf(count, count.length);left=amount;
					}
    				else {
						if(--need[exsit[end]]==0)left--;
					}*/
    				end+=len;
    			}
    			while(left==0&&begin<end){
    				if(end-begin==words.length*len)res.add(begin);
    				if(exsit[begin]!=-1&&++need[exsit[begin]]==1)left++;
    				begin+=len;
    			}
    		}
    	}
    	return res;
    }
	
	public List<Integer> findSubstring2(String s, String[] words) {
		//对hashmap增删开销较大，效率低
		List<Integer> result=new ArrayList<>();
		if(words.length==0) {
			return result;
		}
	    int wordLen=words[0].length();
	    HashMap<String, Integer> reSet=new HashMap<>();
	    for(int i=0;i<words.length;i++) {
	    	if (reSet.containsKey(words[i])) {
				reSet.put(words[i], reSet.get(words[i])+1);
			}
	    	else {
				reSet.put(words[i], 1);
			}
	    }
	    HashMap<String, Integer> map;//K=words中的字符串,出现的次数
	    for(int i=0;i<=s.length()-wordLen*words.length;i++){
	    	map=new HashMap<>(reSet);
	    	int j;
	    	for(j=0;j<words.length;j++){
	    		String sub=s.substring(i+j*wordLen, i+j*wordLen+wordLen);
	    		if (map.containsKey(sub)) {
					if (map.get(sub)==1) {
						map.remove(sub);
					}
					else{
						map.put(sub, map.get(sub)-1);
					}
				}
	    		else {
					break;
				}
	    	}
	    	if (j==words.length) {
				result.add(i);
			}
	    }
	    return result;
	}

	public List<Integer> findSubstring3(String s, String[] words) {
		List<Integer> result=new ArrayList<>();
		int step=words[0].length();//一个单词的长度,即每次窗口需要移动的步长
		if (words.length==0||words.length*step>s.length()) return result;
		
		HashMap<String, Integer> map=new HashMap<>();//K:words中的单词，V单词的下标,即建立单词到下标的映射
		int[] need=new int[words.length];//窗口中需要查找的单词的数量
		int[] found=new int[words.length];//窗口中已经查找到的单词的数量
		int count=words.length;//剩余需要查找的单词的数量
		
		int index=0;
		for(int i=0;i<words.length;i++){
			Integer mapped=map.get(words[i]);
			if (mapped==null) {
				map.put(words[i], index);
				mapped=index++;
			}
			else {
				count--;
			}
			need[mapped]++;
		}
		
		int[] exist=new int[s.length()-step+1];//exist[i]s中以i为初始下标的单词是否在words中存在
		//若存在则为其对应的下标，若不存在为-1
		for(int i=0;i<=s.length()-step;i++){
			Integer mapped=map.get(s.substring(i, i+step));
			exist[i]=mapped==null?-1:mapped;
		}
		
		for(int i=0;i<step;i++){
			int begin=i,end=i-step;//窗口为[begin,end]
			int cnt=count;
			Arrays.fill(found, 0);
			while(end+step<=s.length()-step){//s.length-step为i中最后一个单词的下标
	        	while(cnt>0&&end+step<=s.length()-step){
	        		end+=step;
	        		if (exist[end]!=-1&&++found[exist[end]]==need[exist[end]]) {
						cnt--;
//==-1情况暂时接受，因为添加结果的时候还需要保证end-begin+1==words.length*step,
		//若窗口中要存在-1的字符串时cnt==0，则窗口长度不满足条件
					}
	        	}
	        	while(cnt==0&&begin<=end){
	        		if (end-begin+step==words.length*step) {
						result.add(begin);
					}
	        		begin+=step;
	        		if (exist[begin-step]!=-1&&--found[exist[begin-step]]==need[exist[begin-step]]-1) {
						cnt++;
					}
	        	}
			}
		}
		return result;
    }

	public static void main(String[] args){
		SubstringwithConcatenationofAllWords test=new SubstringwithConcatenationofAllWords();
		String[] words={"foo","bar"};
		System.out.println(test.findSubstring("barfoothefoobarman", words));
	}
}
