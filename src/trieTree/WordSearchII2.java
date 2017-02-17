package trieTree;
import java.util.*;
public class WordSearchII2 {
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
        		for(int k=0;k<26;k++)
        			if(root.children[k]!=null){
        				dfs(board, i, j,"",root.children[k]);
        			}
        	}
        }
        return result;
    }

    private void dfs(char[][] board,int i,int j,String ex,TrieNode cur){
    	//在cur搜索,当前已搜索了ex
    	if(i<0||i==m||j<0||j==n||cur.val!=board[i][j])return;
    	
    	ex+=cur.val;
    	
    	if(cur.isWord){
    		result.add(ex);cur.isWord=false;
    	}
    	board[i][j]^=256;
    	for(int child=0;child<26;child++){
    		if(cur.children[child]!=null){
    			dfs(board, i+1, j, ex, cur.children[child]);
    			dfs(board, i-1, j, ex, cur.children[child]);
    			dfs(board, i, j+1, ex, cur.children[child]);
    			dfs(board, i, j-1, ex, cur.children[child]);
    		}
    	}
    	board[i][j]^=256;
    }
    
    private TrieNode buildTree(String[] words){//以words建立Trie树
    	TrieNode root=new TrieNode(' '),current;
    	for(int i=0;i<words.length;i++){
    		current=root;
    		for(int j=0;j<words[i].length();j++){
    			char c=words[i].charAt(j);
    			if(current.children[c-'a']==null) current.children[c-'a']=new TrieNode(c);
    			current=current.children[c-'a'];
    		}
    		current.isWord=true;
    	}
    	return root;
    }
    class TrieNode{
    	char val;
    	boolean isWord;
    	TrieNode[] children;
    	
    	TrieNode(char val){
    		this.val=val;
    		children=new TrieNode[26];
    	}
    }
    
    public static void main(String[] args){
    	char[][] board={{'a'}};
    	String[] words={"a"};
    	System.out.println(new WordSearchII2().findWords(board, words));
    }
}
