package lab1;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_Lab1 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	
	  @Test
	    public void test_999_NoLoop() {

	        try {
	            File file = new File("src/lab1/Lab1.java");
	            Scanner myReader = new Scanner(file);
	            Pattern pattern = Pattern.compile("(for|while)\\s*\\(");
	            while (myReader.hasNextLine()) {
	                String data = myReader.nextLine();
	                Matcher matcher = pattern.matcher(data);
	                if (matcher.find()) {
	                    fail("Do NOT use any loop!");
	                }
	            }
	            myReader.close();
	        }
	        catch (Exception ex) {
	            fail("File does not exist.");
	        }
	    }
	
	@Test
	public void test_01_01() {
		int start = 0;
		int end = 5;
		int prod = 1;
		for (int i = start; i <= end; i++)
			prod *= i;

		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));

	}

	@Test
	public void test_01_02() {
		int start = -10;
		int end = 10;
		int prod = 1;
		for (int i = start; i <= end; i++)
			prod *= i;
		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));

	}

	@Test
	public void test_01_03() {
		int start = 10;
		int end = 10;
		int prod = 1;
		for (int i = start; i <= end; i++)
			prod *= i;
		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));

	}

	@Test
	public void test_02_01() {

		char init = '*';
		int n = 5;
		String result = "";
		for (int i = 0; i < n; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab1.makeString(init, n));
	}

	@Test
	public void test_02_02() {
		char init = '*';
		int n = 0;
		String result = "";
		for (int i = 0; i < n; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab1.makeString(init, n));
	}

	@Test
	public void test_03_01() {

		assertEquals("Failed: testWriteChars1", "*", Lab1.writeChars(1));
	}

	@Test
	public void test_03_02() {
		assertEquals("Failed: testWriteChars2", "**", Lab1.writeChars(2));

	}

	@Test
	public void test_03_03() {
		assertEquals("Failed: testWriteChars3", "<*>", Lab1.writeChars(3));

	}

	@Test
	public void test_03_04() {
		assertEquals("Failed: testWriteChars4", "<**>", Lab1.writeChars(4));

	}

	@Test
	public void test_03_05() {
		assertEquals("Failed: testWriteChars5", "<<<<**>>>>", Lab1.writeChars(10));

	}

	@Test
	public void test_03_06() {
		assertEquals("Failed: testWriteChars6", "<<<<<<<<<<<<*>>>>>>>>>>>>", Lab1.writeChars(25));

	}

	@Test
	public void test_04_01() {
		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result,
				Lab1.getSubstring(str1, open, close));

	}

	@Test
	public void test_04_02() {

		String str1 = "This is a \"good\" practice";
		String result = "good";
		char open = '"';
		char close = '"';
		assertEquals("Failed: getSubstring(\"This is a 'good' practice\", '\"', '\"')", result,
				Lab1.getSubstring(str1, open, close));
	}

	@Test
	public void test_04_03() {

		String str1 = "[x + y + (y - z)]";
		String result = "x + y + (y - z)";
		char open = '[';
		char close = ']';
		assertEquals("Failed: getSubstring(\"[x + y + (y - z)]\", '[', ']')", result,
				Lab1.getSubstring(str1, open, close));
	}

	@Test
	public void test_04_04() {

		String str1 = "[]";
		String result = "";
		char open = '[';
		char close = ']';
		assertEquals("Failed: getSubstring(\"[]\", '[', ']')", result, Lab1.getSubstring(str1, open, close));
	}

	@Test
	public void test_04_05() {

		String str1 = "{a}";
		String result = "a";
		char open = '{';
		char close = '}';
		assertEquals("Failed: getSubstring(\"{a}\", '{', '}')", result, Lab1.getSubstring(str1, open, close));
	}

	@Test
	public void test_04_06() {
		String str1 = " This is [quite} an example!";
		String result = "quite";
		char open = '[';
		char close = '}';
		assertEquals("Failed: getSubstring(\" This is [quite} an example!\", '[', '}')", result,
				Lab1.getSubstring(str1, open, close));

	}

	@Test
	public void test_05_01() {

		int decimal = 0;
		String binary = "0";
		assertEquals("Failed: decimalToBinary(0)", binary, Lab1.decimalToBinary(decimal));
	}

	@Test
	public void test_05_02() {

		int decimal = 1;
		String binary = "1";
		assertEquals("Failed: decimalToBinary(1)", binary, Lab1.decimalToBinary(decimal));
	}

	@Test
	public void test_05_03() {
		int decimal = 2;
		String binary = "10";
		assertEquals("Failed: decimalToBinary(2)", binary, Lab1.decimalToBinary(decimal));

	}

	@Test
	public void test_05_04() {

		int decimal = 23;
		String binary = "10111";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab1.decimalToBinary(decimal));
	}

	@Test
	public void test_05_05() {
		int decimal = 1073741824;
		String binary = "1000000000000000000000000000000";
		assertEquals("Failed: decimalToBinary(1073741824)", binary, Lab1.decimalToBinary(decimal));

	}

}
