package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jack on 5/20/2016.
 */
public class StrTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StrTest( String testName )
    {

        super( testName );
        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StrTest.class );
    }

    public void test_subString()
    {
        assertEquals("12312121".substring(2,3),"3");
    }

    public void test_indexOf()
    {
        assertEquals("12312121".indexOf("23"),1);
    }

    public void test_length()
    {
        assertEquals("123".length(),3);
    }

    public void test_split()
    {

        String[] x = "12,22,".split(",");

        assertEquals(x.length,2);
        assertEquals(x[1],"22");

    }

    public void test_trim()
    {

        assertEquals(" 123 ".trim(),"123");
        assertEquals(Str.rightTrim(" 123 ")," 123");
        assertEquals(Str.leftTrim(" 123 "),"123 ");

    }

    public void test_regMatch()
    {

        Pattern p = Pattern.compile("\\d{3,5}");
        Matcher m = p.matcher("123");
        assertEquals(true,m.matches());

        assertEquals(

                "123".matches("1\\d3")

                ,

                true

        );

    }

    public void test_regReplace()
    {

        assertEquals(

                "a2389a".replaceAll("\\d", "*")

                ,

                "a****a"

        );

    }

    public void test_regFind()
    {

        Pattern p = Pattern.compile("(?<num>\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);

        assertEquals(m.groupCount(),2);

        while(m.find()){

            logger.trace(m.group()+","+m.groupCount());//数字字母都有
            logger.trace(m.group("num"));//只有数字
            logger.trace(m.group(2));//只有字母

        }

    }

}
