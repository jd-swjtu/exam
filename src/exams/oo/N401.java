package exams.oo;

import java.util.ArrayList;
import java.util.List;

public class N401 {

	public static void main(String[] args) {
		System.out.println(new N401().getValue(1, 11, 0x0f));
		System.out.println(new N401().readBinaryWatch3(1));
	}

	/*
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
	 */

	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();

		for(int i=0; i<=num; i++) {
			List<Integer> hours = getValue(i, 11, 0xf);
			if(hours.size() == 0) continue;

			List<Integer> minutes = getValue(num-i, 59, 0x3f);
			if(minutes.size() == 0) continue;

			for(int h: hours) {
				for(int m: minutes) {
					res.add(String.format("%d:%02d", h, m));
				}
			}
		}

		return res;
	}

	public List<Integer> getValue(int n, int max, int maxBin) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<=max; i++) {
			int v = i & maxBin;

			int c = 0;
			while(v>0) {
				if((v & 0x01) == 1) c++;
				v = v>>1;
			}

			if(c == n) {
				res.add(i);
			}
		}
		return res;
	}
	
	public int getBits(int n) {
		int c = 0;
		while(n>0) {
			c += n & 0x1;
			n = n>>1;
		}
		return c;
	}
	
	public List<String> readBinaryWatch2(int num) {
		List<String> res = new ArrayList<String>();

		for(int i=0; i<=num; i++) {
			for(int h=0; h<12; h++) {
				if(this.getBits(h) != i) continue;
				
				for(int m=0; m<60; m++) {
					if(this.getBits(m) != num -i) continue;
					
					res.add(String.format("%d:%02d", h, m));
				}
			}
		}

		return res;
	}
	
	private void calculateBits(int[] bits) {
		for(int i=0; i<60; i++) {
			int n = i;
			int c = 0;
			while(n>0) {
				c += n & 0x1;
				n = n>>1;
			}
			bits[i] = c;
		}
		//System.out.println(Arrays.toString(bits));
	}
	
	public List<String> readBinaryWatch3(int num) {
		List<String> res = new ArrayList<String>();
		int[] bits = new int[60];
		
		calculateBits(bits);

		for(int i=0; i<=num; i++) {
			for(int h=0; h<12; h++) {
				if(bits[h] != i) continue;
				
				for(int m=0; m<60; m++) {
					if(bits[m] != num -i) continue;
					
					res.add(String.format("%d:%02d", h, m));
				}
			}
		}

		return res;
	}
}
