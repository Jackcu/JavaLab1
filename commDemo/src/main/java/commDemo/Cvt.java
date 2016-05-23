package commDemo;

/**
 * Created by Jack on 5/20/2016.
 */
public class Cvt {

    /**
     * 逢1进10
     * @param x1
     * @return
    */
    public static double eval1(double x1) {

        double x2=Math.ceil(x1);
        return (x2+(10-(x2%10)));

    }


}
