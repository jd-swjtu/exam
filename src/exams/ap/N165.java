package exams.ap;

public class N165 {

	public static void main(String[] args) {
		System.out.println(new N165().compareVersion("1.10", "21.11"));
	}

public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int v11 = Integer.parseInt(v1[0]);
        int v21 = Integer.parseInt(v2[0]);
        
        if(v11 == v21) {
        	int v12 = Integer.parseInt(v1[1]);
        	int v22 = Integer.parseInt(v2[1]);
        	
        	if(v12 == v22) {
        		return 0;
        	} else {
        		return v12<v22?-1:1;
        	}
        } else {
        	return v11<v21?-1:1;
        }
    }
}
