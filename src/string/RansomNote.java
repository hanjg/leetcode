package string;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] amount=new int[26];//存储所有字母出现的个数
        for(int i=0;i<magazine.length();i++){
        	amount[magazine.charAt(i)-'a']+=1;
        }
        for(int i=0;i<ransomNote.length();i++){
        	if(amount[ransomNote.charAt(i)-'a']==0) return false;
        	else amount[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

}
