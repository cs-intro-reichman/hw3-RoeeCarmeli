// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		//System.out.println(plus(2,3));   // 2 + 3
		//System.out.println(minus(7,2));  // 7 - 2
		//System.out.println(minus(2,7));  // 2 - 7
		//System.out.println(times(-5,-5));  // 3 * 4
		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		System.out.println(pow(-5,3));      // 5^3
		//System.out.println(pow(3,5));      // 3^5
		//System.out.println(div(12,3));   // 12 / 3    
		//System.out.println(div(5,5));    // 5 / 5  
		//System.out.println(div(25,7));   // 25 / 7
		//System.out.println(mod(25,7));   // 25 % 7
		//System.out.println(mod(120,6));  // 120 % 6    
		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
			int sum = x1;
			if (x2 < 0) {
				for (int i = 0; i > x2; i--) {
					sum--;
				}
			}
			else{
				for (int i = 0; i < x2; i++) {
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1;
		if (x2 < 0){
			for (int i = 0; i > x2; i--){
				difference++;
			}
		}
		else {
			for (int i = 0; i < x2; i++){
			difference--;
			}
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multi = x1;
			if (x2 < 0) { // cheks if x2 is negitive so we run a minus instead
				for (int i = 1; i > x2; i--){
					multi = minus(multi, x1);
				}
			}
		else{ 
			for (int i = 1; i < x2; i++){
				multi = plus(multi, x1);
			}
		}
		
		if (x1 == 0 || x2 == 0) multi = 0;
		return multi;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power = x;
		for (int i = 1; i < n; i++){
			power = times(power, x);
		}
		if (n == 0) power = 1; //overide the resault if n is 0
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int part = x1;
		int count = 0;
		
		if (part < 0 && x2 > 0) {
			while (part < 0) {
				part = plus(part, x2);
				count--;
			}
			part = x1;
		}
		if (part < 0 && x2 < 0) {
			while (part < 0) {
				part = minus(part, x2);
				count++;
			}
			part = x1;
		}
		if (part > 0 && x2 > 0) {
			while (part > 0) {
				part = minus(part, x2);
				count++;
			}
		part = x1;
		}
		if (part > 0 && x2 < 0) {
			while (part > 0) {
				part = plus(part, x2);
				count--;
			}
		}
		if (part == 0) count = 0;
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int rest = x1;
		while (rest > 0) {
			rest = minus(rest, x2);
		}
		if (rest != 0) rest = plus(rest, x2);
		return rest;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		int newNum = 0;
		while (newNum < x) {
			i++;
			newNum = pow(i, 2);
		}

		return i;
	}	  	  
}