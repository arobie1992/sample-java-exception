import java.util.Math;

public class Example {
	
	// tool flags this because it throws IAE without declaring it in a javadoc comment
	public double posSqrt(double d) {
		if(d < 0) {
			throw new IllegalArgumentException("d must be >= 0");
		}
		return Math.sqrt(d);
	}

	// tool flags this because it calls a method that can throw IAE without either handling or specifying in javadoc
	public void printSqrt(double d) {
		System.out.println(d + "'s square root is " + posSqrt(d));
	}

	// tool doesn't flag this because it declares the throws in the javadoc and provides an explanation
	// stretch goal could be to make sure the reason is accurate
	/**
         * @throws NullPointerException if {@code d} is {@code null}
	 * @throws IllegalArgumentException if {@code d} is less than 0
	 */
	public Double posSqrt(Double d) {
		if(d == null) {
			throw new NullPointerException("d cannot be null");
		}
		return posSqrt(d);
	}

	// tool would flag this because posSqrt(Double) specifies @throws in its javadoc
	// stretch goal would be to infer the reason for the @throws exception 
	public void printSqrt(Double d) {
		System.out.println(d + "'s square root is " + posSqrt(d));
	}

}
