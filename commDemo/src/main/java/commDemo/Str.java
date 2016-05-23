package commDemo;

/**
 * Created by Jack on 5/20/2016.
 */
public class Str {

    /**
     * 去左空格
     * @param str
     * @return
    */
    public static String leftTrim(String str) {
        if (str == null || str.equals("")) {
            return str;
        } else {
            return str.replaceAll("^[　 ]+", "");
        }
    }

    /**
     * 去右空格
     * @param str
     * @return
    */
    public static String rightTrim(String str) {
        if (str == null || str.equals("")) {
            return str;
        } else {
            return str.replaceAll("[　 ]+$", "");
        }

    }

}
