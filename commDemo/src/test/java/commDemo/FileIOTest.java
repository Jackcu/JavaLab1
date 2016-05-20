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
public class FileIOTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FileIOTest(String testName )
    {

        super( testName );
        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FileIOTest.class );
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
