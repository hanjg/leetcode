package string;

public class NumberofSegmentsinaString {
    public int countSegments(String s) {
    	s = s.trim();
    	if (s.length() == 0) {
			return 0;
		}
    	String[] tokens = s.split(" ");
    	int count = 0;
    	for (String token : tokens) {
			if (token.equals("")) {
				continue;
			}
			count++;
		}
    	return count;
    }

    public int countSegments2(String s) {
    	s = s.trim();
    	if (s.length() == 0) {
			return 0;
		}
    	int count = 1;
    	char[] ca = s.toCharArray();
    	for (int i = 0; i < ca.length; i++) {
			if (ca[i] == ' ' && i + 1 < ca.length && ca[i + 1] != ' ') {
				count++;
			}
		}
    	return count;
    }

}
