import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
Q2:[10 points]Consider the following function,written in Java.

public class Computation {
public int compute(int a, int b)
{
int x = 0;
if (b > a) {
if (a > 6) {
x = b;
} else {
x = a;
}
}
if (x == 3 || x < 0) {
x = x * b;
}
if (b <= a) {
x = x + 1;
} else {
x = x - 1;
}
return x;
}

}

This is (unfortunately) untested code.
You would like to refactor this code to make it simpler, but before you do, you must
write sufficient

	tests (in JUnit) to achieve 100% branch/condition coverage. Show your
work to clearly demonstrate that your test cases will achieve the desired coverage.


Assumptions: 
ComputationTest is in a package with a file called Compuation.java
junit is installed and is used to run tests
*/


class ComputationTest {
    

	Computation comp = new Computation();
	@Test
	void tc1() {
		int expected = 7;
		assertEquals(compute(7,8), expected);
		
	}
	@Test
	void tc2() {
		int expected = 11;
		assertEquals(compute(3,4), expected);
		
	}
	@Test
	void tc3() {
		int expected = -1;
		assertEquals(compute(-1,0), expected);
		
	}
	@Test
	void tc4() {
		int expected = 1;
		assertEquals(compute(0,1), expected);
		
	}
	
	
	
	

}