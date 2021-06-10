package Fizz;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzTest {
	FizzBuzz fiz = new FizzBuzz();
	@Test
	void printNumberList() {
		assertEquals(1, fiz.printlist(1));
		
	}

}
