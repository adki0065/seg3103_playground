package Fizz;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzTest {
	FizzBuzz fiz = new FizzBuzz();
	@Test
	void printnum() {
		assertEquals("1", fiz.buzz(1));
		
	}
	
	void getlist() {
		int[] arr = {1,2,3};
		assertEquals(arr, fiz.buzz(3));
	}
	

}
