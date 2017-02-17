package string;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	s=s.trim();
    	return s.length()-s.lastIndexOf(' ')-1;
    }

}
