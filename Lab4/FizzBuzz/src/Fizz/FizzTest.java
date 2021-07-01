package Fizz;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzTest {
	FizzBuzz fiz = new FizzBuzz();
	@Test
	void printnum() {
		int[] arr = {1};
		int[] expected = fiz.buzz(1);
		System.out.println(arr[0]);
		
		assertEquals(arr[0], expected[0]);
		
	}
	
	@Test
	void getlist() {
		int[] arr = {1, 2, 3};
		int[] expected = fiz.buzz(3);
		for (int i=0; i<3; i++) {
			assertEquals(arr[i], expected[i]);
		}
	
	}
	

}
