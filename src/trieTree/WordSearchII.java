package trieTree;
import java.util.*;
public class WordSearchII {
	int m,n;
	List<String> result;
	TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
    	result=new ArrayList<>();
    	if(words.length==0)return result;
        m=board.length;n=board[0].length;
        root=buildTree(words);
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        				dfs(board, i, j,root);
        			
        	}
        }
        return result;
    }

    private void dfs(char[][] board,int i,int j,TrieNode cur){
    	//在cur搜索chilldern里是否存在board[i][j]
    	char c=board[i][j];
    	if(c=='#'||cur.children[c-'a']==null)return;
    	cur=cur.children[c-'a'];//此时cur的单词以c结尾
    	
    	if(cur.isWord){
    		result.add(cur.val);cur.isWord=false;
    	}
    	board[i][j]='#';
    	
    	if(i+1<m)dfs(board, i+1, j,cur);
    	if(i>0)dfs(board, i-1, j, cur);
    	if(j+1<n)dfs(board, i, j+1, cur);
    	if(j>0)dfs(board, i, j-1, cur);
    		
    	board[i][j]=c;
    }
    
    private TrieNode buildTree(String[] words){//以words建立Trie树
    	TrieNode root=new TrieNode(""),current;
    	for(int i=0;i<words.length;i++){
    		current=root;
    		for(int j=0;j<words[i].length();j++){
    			char c=words[i].charAt(j);
    			if(current.children[c-'a']==null) current.children[c-'a']=new TrieNode(current.val+c);
    			current=current.children[c-'a'];
    		}
    		current.isWord=true;
    	}
    	return root;
    }
    class TrieNode{
    	String val;
    	boolean isWord;
    	TrieNode[] children;
    	
    	TrieNode(String val){
    		this.val=val;
    		children=new TrieNode[26];
    	}
    }
    
    public static void main(String[] args){
    	char[][] board={"oaan".toCharArray(),"etae".toCharArray(),"ihkr".toCharArray(),"iflv".toCharArray()};
    	String[] words={"oath","pea","eat","rain"};
    	System.out.println(new WordSearchII().findWords(board, words));
    }
}
