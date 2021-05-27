import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EasterCalculatorTest {

  @Test
  void div_show_usage() {
    assertEasterDate("April 1", EasterCalculator.easterDate(1584));
    assertEasterDate(null, EasterCalculator.easterDate(500000));

  }
  @Test
  void test0(){
    assertEasterDate("April 1", EasterCalculator.easterDate(1584));
  }

  @Test
  void test1(){
    assertEasterDate("March 29", EasterCalculator.easterDate(4098));
  }

  @Test
  void test2(){
    assertEasterDate("April 18", EasterCalculator.easterDate(1954));
  }

  @Test
  void test3(){
    assertEasterDate(null, EasterCalculator.easterDate(1583));
  }

  @Test
  void test4(){
    assertEasterDate(null, EasterCalculator.easterDate(4099));
  }

  @Test
  void test5(){
    assertEasterDate(null, EasterCalculator.easterDate('a'));
  }

  
  

  private void assertEasterDate(String expected, MyDate actual) {
    if (actual == null) {
      assertEquals(expected, actual);
    } else {
      assertEquals(expected, actual.toString());
    }
  }

}