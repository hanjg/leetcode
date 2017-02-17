package bfs;
import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> set=new HashSet<>();//存储曾经存入队列的单词
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);set.add(beginWord);
        int length=1;
        while(!queue.isEmpty()){
        	int num=queue.size();
        	length++;
        	for(int i=0;i<num;i++){
        		String cur=queue.poll();
        		for(int j=0;j<cur.length();j++){//修改cur的位置下标
        			char[] chars=cur.toCharArray();
        			for(char c='a';c<='z';c++){
        				chars[j]=c;
        				String next=new String(chars);
        				if(next.equals(endWord))return length;
        				if(wordList.contains(next)&&!set.contains(next)){
        					queue.add(next);set.add(next);
        				}
        			}
        		}
        	}
        }
        return 0;
    }

	public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
	    //将访问过的单词从wordlist中除去
	    Queue<String> queue=new LinkedList<>();
	    queue.add(beginWord);
	    int length=1;
	    if(beginWord.equals(endWord)) return length;
	    while(!queue.isEmpty()){
	    	int num=queue.size();
	    	length++;
	    	for(int i=0;i<num;i++){
	    		String cur=queue.poll();
	    		for(int j=0;j<cur.length();j++){//修改cur中字符的下标
	    			char[] chars=cur.toCharArray();
	    			for(char c='a';c<='z';c++){
	    				if(c==cur.charAt(j)) continue;
	    				chars[j]=c;
	    				String next=new String(chars);
	    				if(next.equals(endWord))return length;
	    				if(wordList.contains(next)){
	    					queue.add(next);wordList.remove(next);
	    				}
	    			}
	    		}
	    	}
	    }
	    return 0;
	}

	public int ladderLength3(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
}

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		String[] strings={"hot","cog","dot","dog","hit","lot","log"};
		for(int i=0;i<strings.length;i++){
			set.add(strings[i]);
		}
		WordLadder test=new WordLadder();
		System.out.println(test.ladderLength("hit", "cog", set));
	}

}
