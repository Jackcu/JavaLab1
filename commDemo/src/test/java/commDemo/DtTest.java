package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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
        System.out.println(new Date());
        String cnWeekDay=Dt.GetCnWeekDay("2016-05-20");
        String enWeekDay=Dt.GetEnWeekDay("2016-05-20");
        int days=Dt.GetIntWeekDayT1(new Date());
        String shortName= Dt.GetMonthByShortName("JAN");
        int woY=  Dt.GetWeekOfYear(new Date());
        int woM=  Dt.WeekOfMonth(new Date(),1);

        Date d1=Dt.T4("20160606");
        String t5t1Str= Dt.T5ToT1("18AUG");
        String t5t12Str=Dt.T5ToT1_2("18AUG");

        String t8t1Str=Dt.T8ToT1("20MAR 0910");
        String t1Str=Dt.ToT1(new Date());
        String t2Str=Dt.ToT2(new Date());
        String t3Str=Dt.ToT3("0730");
        String t5Str=Dt.ToT5("2014-06-06");
        String t6Str=Dt.ToT6("2014-06-07");

        String t7Str= Dt.ToT7("2008-01-01 07:00");
        String test=Dt.ToT5(new Date());
        String orgStr=Dt.ToJsOrgDateString(new Date());
        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DtTest.class );
    }

    public void test_wt_rt() throws IOException {

        //assertEquals("12312121".substring(2,3),"3");

        FileIO.wt("a.txt","1\r\n2\r\n中文");

        assertEquals(
                true
                ,
                FileIO.rt("a.txt").contains("中文")
        );


    }

}
