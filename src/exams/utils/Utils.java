package exams.utils;

public class Utils {
	public static class Pair<T1, T2> {
		T1 t1;
		T2 t2;
		
		public Pair(T1 t1, T2 t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
	}
	
	public static class Triple<T1, T2, T3> extends Pair<T1, T2> {
		T3 t3;
		
		public Triple(T1 t1, T2 t2, T3 t3) {
			super(t1, t2);
			this.t3 = t3;
		}
		
		public String toString() {
			return t1.toString() + ", " + t2.toString() + ", " + t3.toString();
		}
	}
}
