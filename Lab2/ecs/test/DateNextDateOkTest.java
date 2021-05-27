import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DateNextDateOkTest
{

    private Date actual;

    private Date initial;

    private Date expected;

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




    public DateNextDateOkTest(int iyear, int imonth, int iday, int eyear, int emonth, int eday){
    
        this.iday = iday;
        this.imonth = imonth;
        this.iyear = iyear;
        this.eday = eday;
        this.emonth = emonth;
        this.eyear = eyear;
        

        
    }


    @Parameters
	public static List<Integer[]> data( )
	{
		List<Integer[]> params = new LinkedList<Integer[]>( );
		params.add(new Integer[] { 1700, 6, 20, 1700, 6, 21 });
		params.add(new Integer[] { 2005,4,15,2005,4,16 });
		params.add(new Integer[] { 1901,7,20,1901,7,21 });
		params.add(new Integer[] { 3456,3,27,3456,3,28 });
        params.add(new Integer[] { 1500,2,17,1500,2,18 });
		params.add(new Integer[] { 1700,6,29,1700,6,30 });
		params.add(new Integer[] { 1800,11,29,1800,11,30 });
		params.add(new Integer[] { 3453,1,29,3453,01,30 });
        params.add(new Integer[] { 444,2,29,444,3,1 });
		params.add(new Integer[] { 2005,4,30,2005,5,1 });
		params.add(new Integer[] { 3453,1,30,3453,1,31 });
		params.add(new Integer[] { 3456,3,30,3456,3,31 });
        params.add(new Integer[] { 1901,7,31,1901,8,1 });
		params.add(new Integer[] { 3453,1,31,3453,2,1 });
		params.add(new Integer[] { 3456,12,31,3457,1,1 });
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
		Date initial = new Date(iyear, imonth, iday);
		Assert.assertEquals(new Date(eyear, emonth, eday), initial.nextDate());
	}
}