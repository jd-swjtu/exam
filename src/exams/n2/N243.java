package exams.n2;

public class N243 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
		
		String word1 = "coding", word2 = "practice";
		System.out.println(new N243().shortestDistance(words, word1, word2));
	}

	public int shortestDistance(String[] words, String word1, String word2) {
		int p1 = -1;
		int p2 = -1;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<words.length; i++) {
			String word = words[i];
			if(word1.equals(word)) {
				p1 = i;
				
				if(p2 >=0) min = Math.min(min, p1 - p2);
			} else
			if(word2.equals(word)) {
				p2 = i;
				
				if(p1>=0) return min = Math.min(min, p2 - p1);
			}
		}
		return min;
	}
	
}
