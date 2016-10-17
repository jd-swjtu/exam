package exam;

public class Utils {
	public static class Pair<T1, T2> {
		T1 t1;
		T2 t2;
		
		public Pair(T1 t1, T2 t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
	}
	
	public static class Turple<T1, T2, T3> {
		T1 t1;
		T2 t2;
		T3 t3;
		
		public Turple(T1 t1, T2 t2, T3 t3) {
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
		}
	}
}
