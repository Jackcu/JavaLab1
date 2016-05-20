package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jack on 5/20/2016.
 */
public class HttpIOTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HttpIOTest(String testName )
    {

        super( testName );
        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HttpIOTest.class );
    }

    public void test_get() throws IOException {

        String result = HttpIO.get("http://baidu.com", 1000);

    }

}
