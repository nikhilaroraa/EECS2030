package lab2;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_TestingExample {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	//Test created to check for an amount that is spent over 500 CAD over the credit limit based on the rewards system
	@Test
	public void test1() {
		
		assertEquals("The function should give 1800 points in this situation", 1800, TestingExample.RewardPoints(1100, 500));
	}
	
	//Test created to check for an amount that is spent over 500 CAD over the credit limit based on the rewards system
	@Test
	 public void test2() {

		assertEquals("The function should give 1800 points in this situation", 1800, TestingExample.RewardPoints(1100, 500));
		
	}
	
	@Test
	//Test created to check for negative spending amount
	public void test3() {
		
		assertEquals("A negative spent amount should result in -1 in this situation", -1, TestingExample.RewardPoints(-200, 500));
		
	}
	
	@Test
	//Test created to check for negative credit limit amount
	public void test4() {
		
		assertEquals("A negative credit limit amount should result in -1 in this situation", -1, TestingExample.RewardPoints(200, -500));
		
	}
	
	@Test
	//Test created to check for an amount that is spent less than the credit limit
	public void test5() {
		
		assertEquals("A spending amount less than the less credit limit should result in -1 in this situation", -1, TestingExample.RewardPoints(200,500));
	}
	
	@Test
	//Test created to check for an amount that is spent equal to the credit limit
	public void test6() {
		
		assertEquals("A spending amount equal to the credit limit should result in 0 in this situation", 0, TestingExample.RewardPoints(500,500));
	}

	@Test
	//Test created to check for an amount that is spent between 0 and 99 CAD over the credit limit based on the rewards system
	public void test7() {
			
		assertEquals("The function should give 0 points in this situation", 0, TestingExample.RewardPoints(580,500));
	}
	
	@Test
	//Test created to check for an amount that is spent between 100 and 299 CAD over the credit limit based on the rewards system
	public void test8() {
			
		assertEquals("The function should give 200 points in this situation", 200, TestingExample.RewardPoints(700,500));
	}
	
	@Test
	//Test created to check for an amount that is spent between 300 and 499 CAD over the credit limit based on the rewards system
	public void test9() {
			
		assertEquals("The function should give 800 points in this situation", 800, TestingExample.RewardPoints(900,500));
	}
	
}
