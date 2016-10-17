package exam;

public class N125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("0P"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panamax"));
		System.out.println(isPalindrome("A sa"));
	}

	 public static boolean isPalindrome(String s) {
	        if(s == null || s.equals("")) return true;
	        int len = s.length();
	        int i=0;
	        int j=len-1;
	        
	        while(i < j) {
	        	char cl = s.charAt(i);
	        	char cr = s.charAt(j);
	        	
	        	if (!((cl >= '0' && cl <= '9') || (cl>='a' && cl <= 'z') || (cl>='A' && cl <= 'Z'))) {
	        		i++;
	        		continue;
	        	}
	        	
	        	if (!((cr >= '0' && cr <= '9') || (cr>='a' && cr <= 'z') || (cr>='A' && cr <= 'Z'))) {
	        		j--;
	        		continue;
	        	}
	        	
	        	if (cl>='A' && cl <= 'Z') {
	        		cl += 'a' - 'A';
	        	}
	        	if (cr>='A' && cr <= 'Z') {
	        		cr += 'a' - 'A';
	        	}
	        	
	        	if(cl == cr) {
	        		i++;
	        		j--;
	        	} else {
	        		return false;
	        	}
	        }
	        return true;
	    }
}
