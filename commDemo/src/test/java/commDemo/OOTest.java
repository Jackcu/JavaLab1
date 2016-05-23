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
public class OOTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public OOTest(String testName )
    {

        super( testName );

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( OOTest.class );
    }

    public void test_t1()
    {

        OO.OO2 oo2 = new OO.OO2("test");
        oo2.M1();

        OO.OO1 oo1=oo2;
        oo1.M1();

        oo2.SM1();
        oo1.SM1();

        oo2.color= OO.Color.RED;

    }

}
