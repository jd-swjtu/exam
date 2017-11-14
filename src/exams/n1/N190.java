package exams.n1;

public class N190 {

	public static void main(String[] args) {
		int n = -5;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(new N190().reverseBits3(n)));
		
		System.out.println( 1 << 31);
	}

	
	public int reverseBits3(int n) {
		int nn = 0;
		for(int i=0; i<32; i++) {
				nn = (nn << 1) | (n & 0x1);
				n = n >>> 1;
				System.out.println(i + "-- " + Integer.toBinaryString(n) + " " + n + " " + nn);
				//System.out.println(((n & (0x1 << i)) >> i) + ":" + Integer.toBinaryString(nn));
		}
		return nn;
	}
}
