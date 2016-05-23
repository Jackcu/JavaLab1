package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jack on 5/20/2016.
 */
public class ConvertTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConvertTest(String testName) {

        super(testName);

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConvertTest.class);
    }

    /**
     * toString 转换
     */
    public void test_convert1() {

        float f = 1.2345f; // 单精度浮点类型
        double d1 = 1.234; // 双精度浮点类型,没有加后缀使用默认
        double d2 = 1.234d; // 双精度浮点型，显示加后缀

        //logger.trace(String.valueOf(f));
        assertEquals("1.2345", (String.valueOf(f)));
        assertEquals("1.234", (String.valueOf(d1)));
        assertEquals("1.234", (String.valueOf(d2)));

    }

    /**
     * 类型转换之自动转换
     */
    public void test_convert2() {

        short s = 3; // 16位整数
        int i = s; // 32位整数
        float f = 1.0f; // 32位浮点数
        double d = f; // 64位浮点数
        long l = 1234l; // 64位整数
        double d2 = l;

        System.out.println("short自动转换为int后的值为：" + i);
        assertEquals(3, i);

        System.out.println("float自动转换为double后的值为" + d);
        assertEquals(1.0d, d);

        System.out.println("long自动转换为double后的值为" + d2);
        assertEquals(1234.0d, d2);

    }

    /**
     * 类型转换之强制转换
     */
    public void test_convert3() {

        //基本数据类型转换之强制转换
        int i = 123;
        byte b = (byte) i; //强制转换

        double x = 123.523d;
        int x1 = (int) x;

        System.out.println("int类型强制转换为byte后值为：" + b);
        assertEquals(123, b);

        System.out.println("double类型强制转换为int后值为：" + x1);
        assertEquals(123, x1);

    }

    /**
     * string 转基本类型
     */
    public void test_convert4() {

        assertEquals(123, Integer.parseInt("123"));

        assertEquals((Integer) 123, new Integer(123));

        assertEquals(true, 123 == new Integer(123));

        assertEquals(123.123d, Double.parseDouble("123.123"));
        assertEquals(123.123d, Double.valueOf("123.123"));

    }

    /**
     * 取整： 四舍五入。。。。。
     */
    public void test_convert5() {

        double i = 2, j = 2.1, k = 2.5, m = 2.9;

        System.out.println("舍掉小数取整:Math.floor(2)=" + (int) Math.floor(i));
        System.out.println("舍掉小数取整:Math.floor(2.1)=" + (int) Math.floor(j));
        System.out.println("舍掉小数取整:Math.floor(2.5)=" + (int) Math.floor(k));
        System.out.println("舍掉小数取整:Math.floor(2.9)=" + (int) Math.floor(m));

        System.out.println("舍掉小数取整:Math.floor(-2)=" + (int) Math.floor(-i));
        System.out.println("舍掉小数取整:Math.floor(-2.1)=" + (int) Math.floor(-j));
        System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int) Math.floor(-k));
        System.out.println("舍掉小数取整:Math.floor(-2.9)=" + (int) Math.floor(-m));

        System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

        System.out.println("四舍五入取整:(-2)=" + new BigDecimal("-2").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(-2.1)=" + new BigDecimal("-2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(-2.5)=" + new BigDecimal("-2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(-2.9)=" + new BigDecimal("-2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

        System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(1, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.11)=" + new BigDecimal("2.11").setScale(1, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.55)=" + new BigDecimal("2.55").setScale(1, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.91)=" + new BigDecimal("2.91").setScale(1, BigDecimal.ROUND_HALF_UP));

        System.out.println("逢小进一:Math.ceil(2)=" + (int) Math.ceil(i));
        System.out.println("逢小进一:Math.ceil(2.1)=" + (int) Math.ceil(j));
        System.out.println("逢小进一:Math.ceil(2.5)=" + (int) Math.ceil(k));
        System.out.println("逢小进一:Math.ceil(2.9)=" + (int) Math.ceil(m));


        assertTrue(Cvt.eval1(1120.1111d) == 1130d);
        assertTrue(Cvt.eval1(1.1111d) == 10d);


    }

}
