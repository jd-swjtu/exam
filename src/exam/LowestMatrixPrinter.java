package exam;

public class LowestMatrixPrinter {

	public static void main(String[] args) {
		int cityWidth=80;
		int cityLength=80;
		int[] xCordinates ={2,4};
		int[] yCordinates={3,7};

		printMatrix(cityWidth,cityLength,xCordinates,yCordinates);
		System.out.println("###########");
		printMatrixX(cityWidth,cityLength,xCordinates,yCordinates);
	}

	private static void printMatrix(int cityWidth, int cityLength,
			int[] xCordinates, int[] yCordinates) {

		for(int i=0;i<cityLength;i++){
			for(int j=0;j<cityWidth;j++){
				int lockDistance=findNearestLocker(i,j,xCordinates,yCordinates);
				System.out.print(lockDistance +" ");
			}
			System.out.println();
		}
	}

	private static int findNearestLocker(int i, int j, int[] xCordinates,
			int[] yCordinates) {
		int totalLocker= xCordinates.length;
		int distance=Integer.MAX_VALUE;
		for(int l=0;l<totalLocker;l++){
			int x=xCordinates[l];
			int y =yCordinates[l];
			int tempDistance=Math.abs(x-j-1)+Math.abs(y-i-1);
			if(distance>tempDistance){
				distance=tempDistance;
			}
		}
		return distance;
	}
	
	private static void printMatrixX(int cityWidth, int cityLength,
			int[] xCordinates, int[] yCordinates) {
		int[][] m = new int[cityLength][cityWidth];
		
		for(int i=0;i<cityLength;i++){
			for(int j=0;j<cityWidth;j++){
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int totalLocker= xCordinates.length;
		for(int l=0;l<totalLocker;l++){
			int x=xCordinates[l];
			int y =yCordinates[l];
			
			//m[x][y] = 0;
			go(m, cityLength, cityWidth, y-1, x-1, 0);
			//System.out.println("##" + x + ":" + y);
		}
		
		for(int i=0;i<cityLength;i++){
			for(int j=0;j<cityWidth;j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void go(int[][] m, int l, int w, int i, int j, int v) {
		if(i<0 || i>=l || j < 0 || j>=w) return;
		//System.out.println("##:" + i +" " + j + " " + l + ":" + w);
		if(m[i][j] == 0) return;
		if(m[i][j] <= v) return;
		
		m[i][j] = v;
		go(m, l, w, i+1, j, v+1);
		go(m, l, w, i-1, j, v+1);
		go(m, l, w, i, j+1, v+1);
		go(m, l, w, i, j-1, v+1);
	}

}