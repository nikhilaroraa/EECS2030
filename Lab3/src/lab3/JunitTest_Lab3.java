package lab3;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_Lab3 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	
	private double rand() {
		return (int) ((Math.random() * 100.0)*10)/10.0;
	}
	private int gcd(int m, int n) {
        if (0 == n) return m;
        else return gcd(n, m % n);
    }
	
	
	@Test
	public void test_plus1() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(3,4);
		Rational r3 = r1.plus(r2);
		assertEquals("Failed test_plus1",r3.getNum(), 5);
		assertEquals("Failed test_plus1",r3.getDen(), 4);
	}
	@Test
	public void test_plus2() {
		Rational r1 = new Rational(11,6);
		Rational r2 = new Rational(54,43);
		Rational r3 = r1.plus(r2);
		assertEquals("Failed test_plus2",r3.getNum(), 797);
		assertEquals("Failed test_plus22",r3.getDen(), 258);
	}
	
	
	@Test
	public void test_times1() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(3,4);
		Rational r3 = r1.times(r2);
		assertEquals("Failed test_times1",r3.getNum(), 3);
		assertEquals("Failed test_times11",r3.getDen(), 8);
	}
	@Test
	public void test_times2() {
		Rational r1 = new Rational(11,6);
		Rational r2 = new Rational(54,43);
		Rational r3 = r1.times(r2);
		assertEquals("Failed test_times2",r3.getNum(), 99);
		assertEquals("Failed test_times22",r3.getDen(), 43);
	}
	@Test
	public void test_divides1() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(3,4);
		Rational r3 = r1.divides(r2);
		assertEquals("Failed test_divides1",r3.getNum(), 2);
		assertEquals("Failed test_divides11",r3.getDen(), 3);
	}
	@Test
	public void test_divides2() {
		Rational r1 = new Rational(11,6);
		Rational r2 = new Rational(54,43);
		Rational r3 = r1.divides(r2);
		assertEquals("Failed test_divides2",r3.getNum(), 473);
		assertEquals("Failed test_divides22",r3.getDen(), 324);
	}

	
	@Test
	public void testToString() {
		double r = Math.random(); 
		int x1 = 0; 
		int y1 = 0; 
		x1 = (int)rand(); 
		r = Math.random(); 
		y1 = (int)rand(); 
		int g = gcd(x1, y1);
		
		Rational r1 = new Rational (x1, y1);
		String s1 = r1.toString();
		String s2 = "" + (x1 == 0 ? x1 : ((y1/g) != 1 ? (x1/g + "/" + y1/g) : x1/g));
		
		int eq = s1.compareTo(s2);
		boolean equal = eq == 0 ? true : false; 
		String message = "toString() is not correct for the rational number: " + x1 + "/" + y1 ;
		assertTrue( message,equal);
	}
	@Test
	public void testEqual() {
		double r = Math.random(); 
		int x1 = 0; 
		int y1 = 0; 
		x1 = (int)rand(); 
		r = Math.random(); 
		y1 = (int)rand(); 
		Rational r1 = new Rational (x1, y1);
		int g1  = gcd(x1, y1);
		
		int x2 = 0; 
		int y2 = 0; 
		x2 = (int)rand(); 
		r = Math.random(); 
		y2 = (int)rand(); 
		Rational r2 = new Rational (x2, y2);
		int g2  = gcd(x2, y2);
		
		boolean expected = ((x1/g1) == (x2/g2) && (y1/g1) == (y2/g2));
		boolean actual = r1.equals(r2);
		
		String message = "equals() is not correct for " +x1+ "/" + y1 + "and "+x2+ "/" + y2;
		assertEquals(message, expected, actual);
	}
}
