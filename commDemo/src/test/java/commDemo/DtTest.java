package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jack on 5/20/2016.
 */
public class DtTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DtTest(String testName ) throws Exception
    {
        super( testName );

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested+
     *
     *
     *
     *
     */
    public static Test suite()
    {
        return new TestSuite( DtTest.class );
    }

    public static void test_GetCnWeekDayTest() throws Exception
    {
        assertEquals("星期五",Dt.GetCnWeekDay("2016-05-20"));
    }

    public static void test_GetEnWeekDayTest() throws Exception
    {
        assertEquals(Dt.GetEnWeekDay("2016-05-20"),"Fri");
    }

    public static void test_GetIntWeekDayT1Test() throws Exception
    {
        assertEquals(1,Dt.GetIntWeekDayT1(new Date()));
    }

    public static void test_GetMonthByShortNameTest() throws Exception
    {
        assertEquals("01",Dt.GetMonthByShortName("JAN"));
    }

    public static void test_GetWeekOfYearTest() throws Exception
    {
        assertEquals(22,Dt.GetWeekOfYear(new Date()));
    }

    public static void test_T4Test() throws Exception
    {
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(format1.parse("2016-06-06"),Dt.T4("20160606"));
    }

    public static void test_WeekOfMonthTest() throws Exception
    {
        assertEquals(4,Dt.WeekOfMonth(new Date(),1));
    }

    public static void test_T5ToT1Test() throws Exception
    {
        assertEquals("2016-08-18",Dt.T5ToT1("18AUG"));
    }

    public static void test_T5ToT1_2Test() throws Exception
    {
        assertEquals("2016-08-18",Dt.T5ToT1_2("18AUG"));
    }

    public static void test_T8ToT1Test() throws Exception
    {
        assertEquals("2017-03-20 09:10",Dt.T8ToT1("20MAR 0910"));
    }

    public static void test_ToT1Test() throws Exception
    {
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals(format1.format(new Date()),Dt.ToT1(new Date()));
    }

    public static void test_ToT2Test() throws Exception
    {
        assertEquals("2016-05-23",Dt.ToT2(new Date()));
    }

    public static void test_ToT3Test() throws Exception
    {
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("07:30",Dt.ToT3("0730"));
    }

    public static void test_ToT5Test() throws Exception
    {
        assertEquals("06JUN",Dt.ToT5("2014-06-06"));
    }

    public static void test_ToT6Test() throws Exception
    {
        assertEquals("06JUN14",Dt.ToT6("2014-06-06"));
    }

    public static void test_ToT7Test() throws Exception
    {
        assertEquals("01JAN08 07:00",Dt.ToT7("2008-01-01 07:00"));
    }

}
