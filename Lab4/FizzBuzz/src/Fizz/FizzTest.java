package Fizz;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzTest {
	FizzBuzz fiz = new FizzBuzz();
	@Test
	void buzz() {
		assertEquals("1", fiz.buzz(1));
		
	}

}
