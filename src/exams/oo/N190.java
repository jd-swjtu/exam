package exams.oo;

public class N190 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(new N190().reverseBits(-3)));
		System.out.println(Integer.toBinaryString(new N190().reverseBits2(-3)));
	}

	public int reverseBits(int n) {
		int nn = 0;
		for(int i=0; i<32; i++) {
				nn = (nn <<1) | ((n & (0x1 << i)) >> i);
				//System.out.println(((n & (0x1 << i)) >> i) + ":" + Integer.toBinaryString(nn));
		}
		return nn;
	}
	
	public int reverseBits2(int n) {
		int nn = 0;
		for(int i=0; i<32; i++) {
				nn = nn | ((n & (0x1 << i)) >> i << (31 -i));
				//System.out.println(((n & (0x1 << i)) >> i) + ":" + Integer.toBinaryString(nn));
		}
		return nn;
	}
}
