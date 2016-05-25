package commDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Jack on 5/22/2016.
 */
public class OO {


    public static Logger logger = LogManager.getLogger("");

    public OO(String arg1) {

        logger.trace("OO run" + arg1);

    }

    public enum Color {
        RED, GREEN, BLANK, YELLOW
    }

    public static class OO1 {


        public static Integer[] array1 = { 1, 2, 3, 4, 5 }; //常用

        public Color color;

        public OO1(String arg1) {

            this.color=Color.RED;
            logger.trace("OO1 run" + arg1);
            Object x=1;
        }

        public static void SM1(){

            logger.trace("OO1 SM1");

            for(int item:array1){

                logger.trace(String.valueOf(item)+1);

            }

        }

        public void M1(){

            logger.trace("OO1 M1");

        }

    }

    public static class OO2 extends OO1 {

        public OO2(String arg1) {

            super(arg1);
            logger.trace("OO2 run" + arg1);

        }

        public static void SM1(){

            logger.trace("OO2 SM1");

        }

        public void M1(){

            logger.trace("OO2 M1");

        }

    }

}

