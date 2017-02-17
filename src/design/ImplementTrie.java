package design;

class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isWord;
    TrieNode[] children=new TrieNode[26];
    
    public TrieNode(char val){
    	this.val=val;
    } 
}
public class ImplementTrie {
	private TrieNode root;
	
	public ImplementTrie(){
		root=new TrieNode(' ');
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current=root;
        for(int i=0;i<word.length();i++){
        	char c=word.charAt(i);
        	if (current.children[c-'a']==null) {
				current.children[c-'a']=new TrieNode(c);
			}
        	current=current.children[c-'a'];
        }
        current.isWord=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word, root);
    }
    
    private boolean searchNode(String word,TrieNode node){//从node开始搜索
    	TrieNode current=node;
    	for(int i=0;i<word.length();i++){
    		char c=word.charAt(i);
    		if (c=='.') {
				boolean result=false;
				for(int j=0;j<26&&result==false;j++){
					if (current.children[j]!=null) {
						result=searchNode(word.substring(i+1), current.children[j]);
					}
				}
				return result;
			}
    		else if (current.children[c-'a']==null) {
				return false;
			}
    		else {
				current=current.children[c-'a'];
			}
    	}
    	return current.isWord;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
