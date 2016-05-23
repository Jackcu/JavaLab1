package commDemo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jack on 5/20/2016.
 */
public class ContinerTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ContinerTest(String testName) {

        super(testName);

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ContinerTest.class);
    }

    public void test_ArrayList() {

        // List<String> list=new ArrayList<String>();
        //list.add("1");

        List<HashMap> mapList = new ArrayList<>();

        HashMap dic1 = new HashMap();
        dic1.put("test", 3);
        mapList.add(dic1);

        HashMap dic2 = new HashMap();
        dic2.put("test", 1);
        mapList.add(dic2);

        HashMap dic3 = new HashMap();
        dic3.put("test", 8);
        mapList.add(dic3);

        //.remove(dic3);

        //List<HashMap> mapList2=new ArrayList<HashMap>();

        Vector<String> x = new Vector<>();
        x.add("A");
        assertEquals(x.elementAt(0),"A");

        ArrayList<String> x2 = new ArrayList<>();
        x2.add("A");
        assertEquals(x2.get(0),"A");

        HashSet<String> x3=new HashSet<>();
        assertEquals(true,x3.add("A"));
        assertEquals(false,x3.add("A"));
        assertEquals(1,x3.size());

        for (HashMap test : mapList) {

            Iterator iter = test.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

        }
        Collections.sort(mapList, new SortByTest());

        for (HashMap test : mapList) {
            Iterator iter = test.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(4);
        intList.add(2);
        intList.add(5);
        intList.add(88);
        intList.add(1);
        intList.add(98);
        intList.add(45);
        intList.add(3);

        Collections.sort(intList, new SortByTest1());

        for (int temp : intList) {
            System.out.println(temp);

        }


        assertEquals(true, mapList.contains(dic2));
    }

    class SortByTest1 implements Comparator {
        public int compare(Object o1, Object o2) {
            int i1 = Integer.valueOf(String.valueOf(o1));
            int i2 = Integer.valueOf(String.valueOf(o2));
            if (i1 > i2)
                return 1;
            return -1;
        }

    }


    class SortByTest implements Comparator {
        public int compare(Object o1, Object o2) {
            HashMap s1 = (HashMap) o1;
            HashMap s2 = (HashMap) o2;
            if (s1.size() == 0) return 1;
            if (s2.size() == 0) return 0;
            if (Integer.parseInt(String.valueOf(s1.get("test"))) > Integer.parseInt(String.valueOf(s2.get("test"))))
                return 1;
            return -1;
        }

    }

}
