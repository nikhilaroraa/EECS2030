package lab3;

public class Lab3 {

}

/*  
 * Recall that :
 * 1. No System.out.println statements should appear here.
 * 	  Instead, you need to return the result.
 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
 *    Instead, refer to the input parameters of this method.   
 */
/**
 * Class Rational that represents mathematical rational numbers of the form
 * num/den
 * 
 */
class Rational {

	/**
	 * Numerator of the rational number
	 */
	private int num;

	/**
	 * Denominator of the rational number
	 */
	private int den;

	/**
	 * creates a rational number object that is equal to 1/1
	 */
	public Rational() {
		this.num = 1;
		this.den = 1;
	}

	/**
	 * creates a rational number object in its reduced form by dividing num and denum
	 * by their gcd.
	 * 
	 * @param numerator The numerator of the rational number.
     * @param denominator The denominator of the rational number.
	 */
	public Rational(int numerator, int denominator) {
		if (denominator != 0) {
			int gcd = gcd(numerator, denominator);
			this.num = numerator/gcd;
			this.den = denominator/gcd;
		}
	}

	/**
	 * Returns the numerator of the rational number.
	 * 
	 * @return the numerator
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Sets the numerator of the rational number.
	 * 
	 * @param num the new value of the numerator.
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * Returns the denominator of the rational number.
	 * 
	 * @return the denominator
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Sets the denominator of the rational number.
	 * 
	 * @param den the new value of the denominator.
	 */
	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * Computes the multiplication of this rational number with another rational
	 * number
	 * 
	 * @param b is the rational number to be multiplied by this rational number.
	 * @return returns a new rational number of the multiplication result
	 */
	public Rational times(Rational b) {
		int newNumerator = this.num * b.num;
		int newDenominator = this.den *b.den;
		return new Rational(newNumerator, newDenominator);
	}

	/**
	 * Computes the addition of this rational number with another rational number
	 * 
	 * @param b is the rational number to be added to this rational number.
	 * @return returns a new rational number of the addition result
	 */
	public Rational plus(Rational b) {
		int newNumerator = this.num * b.den + this.den * b.num;
		int newDenominator = this.den * b.den;
		return new Rational(newNumerator, newDenominator);
	}

	/**
	 * Computes the division of this rational number with another rational number
	 * 
	 * @param b is the rational number to divide this rational number.
	 * @return returns a new rational number of the division result
	 */
	public Rational divides(Rational b) {
		int newNumerator = this.num * b.den;
		int newDenominator = this.den * b.num;
		return new Rational(newNumerator, newDenominator);
	}

	/**
	 * Returns a string representation of the rational number as num/den, where num,
	 * and den are the components of the rational number
	 * 
	 * @return a string representation of the rational number
	 */
	public String toString() {
		return num + "/" + den;
	}

	/**
	 * Checks the equality of two rational numbers
	 * 
	 * @param b rational number to be compared with this rational number.
	 * @return true if both rational numbers are equal, false otherwise
	 */
	public boolean equals(Rational b) {
		return this.num == b.num && this.den == b.den;
	}

	/**
	 * Helper method to calculate the gcd of two positive integers
	 * 
	 * @param m is the larger positive integer
	 * @param n is the smaller positive integer
	 * @return an integer which is the gcd of both m and n
	 */
	private static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}
		else {
			return gcd(n, m%n);
		}
	}

}