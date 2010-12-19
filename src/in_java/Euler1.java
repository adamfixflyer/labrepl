package in_java;

public class Euler1 {

	public static void main(String[] args) {
		Euler1 eu = new Euler1();
		
		for(int i=0; i<15; i++) {
			System.out.print(eu.next() + ", ");
		}
	}
	
	int next3 = 3, next5 = 5;
	
	int next() {
		if(next3 == next5) {
			int min = next3;
			next3 += 3;
			next5 += 5;
			return min;
		}
		if(next3 < next5) {
			int min = next3;
			next3 += 3;
			return min;
		}
		int min = next5;
		next5 += 5;
		return min;
	}
	
}
