import static org.junit.jupiter.api.Assertions.*;



import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest
{
    

    private Date d;

    private Date expected;
    private Exception exception;
    private int iyear; 
    private int imonth; 
    private int iday; 
    private int eyear;
    private int emonth;
    private int eday;


    /*
    @param iday

    @param imonth

    @param iyear

    @param eday

    @param emonth

    @param eyear
    */




    public DateNextDateExceptionTest(int iyear, int imonth, int iday){
    
        this.iday = iday;
        this.imonth = imonth;
        this.iyear = iyear;
        
        

        
    }


    @Parameters
	public static List<Integer[]> data( )
	{
		List<Integer[]> params = new LinkedList<Integer[]>( );
		params.add(new Integer[] { 1500,2,31 });
		params.add(new Integer[] { 1500,2,29 });
		params.add(new Integer[] { -1,10,20 });
		params.add(new Integer[] { 1458,15,12 });
        params.add(new Integer[] { 1975,6,-50 });
		
		return params;
	}
/*
    @Test
	public void testAnd()
	{
		Date actual = initial.nextDate();
		Assert.assertEquals(expected, actual);
	}
    */
    @Test
	public void testAnd()
	{
    Exception exception = assertThrows(
      IllegalArgumentException.class, 
      () -> {Date d = new Date(1500,2,29);
        d.nextDate();});
	}


}