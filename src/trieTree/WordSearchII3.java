package trieTree;
import java.util.*;

public class WordSearchII3 {
	List<String>result;
	int m,n;
	public List<String> findWords(char[][] board, String[] words){
		result=new ArrayList<>();
		m=board.length;n=board[0].length;
		TrieNode root=buildTree(words);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dfs(board, i, j,root);
			}
		}
		return result;
	}
	private void dfs(char[][] board,int i,int j,TrieNode cur){//从cur开始寻找c
		char c=board[i][j];
		if(c=='#'||cur.next[c-'a']==null)return;//c访问过或者trie树上没有c这个节点
		cur=cur.next[c-'a'];
		if (cur.word!=null) {
			result.add(cur.word);cur.word=null;
		}
		board[i][j]='#';
		if(i>0)dfs(board, i-1, j, cur);
		if(i<m-1)dfs(board, i+1, j, cur);
		if(j>0)dfs(board, i, j-1, cur);
		if(j<n-1)dfs(board, i, j+1, cur);
		board[i][j]=c;
	}
	
	class TrieNode{
		String word;
		TrieNode[] next=new TrieNode[26];
	}
	private TrieNode buildTree(String[] words){
		//以words建立trie数，只在叶节点储存单词，非叶节点不储存单词或者字符
		TrieNode root=new TrieNode();
		for(String word:words){
			TrieNode cur=root;
			for(char c:word.toCharArray()){
				int i=c-'a';
				if(cur.next[i]==null)cur.next[i]=new TrieNode();
				cur=cur.next[i];
			}
			cur.word=word;
		}
		return root;
	}
}
