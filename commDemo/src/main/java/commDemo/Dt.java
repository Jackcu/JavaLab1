package commDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hero3 on 2016-5-22.
 */
public class Dt {
    /**
     * to "Mon Dec 28 2015 15:19:17 GMT+0800 (China Standard Time)"
     */
    public static String ToJsOrgDateString(Date d) throws Exception{

        String ds1 = Dt.ToT1(d);
        String x="";
        String monthShort=GetMonthShortName(String.valueOf(d.getMonth()+1));
        Calendar cal = Calendar.getInstance();
        x = GetEnWeekDay(ds1).substring(0, 3) + " " + monthShort.substring(0,1)+monthShort.toLowerCase().substring(1) + " " + d.getDate() + " " +cal.get(Calendar.YEAR)+ " " + Dt.ToT1(d).substring(11) + "  GMT+0800 (China Standard Time)";
        return x;
    }

    /**
     * <summary>
     * Get Cn weekday
     * date yyyy-MM-dd
     * </summary>
     * <returns></returns>
    */
    public static String GetCnWeekDay(String date) throws Exception
    {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt=format1.parse(date);
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    public static String GetEnWeekDay(String date) throws Exception
    {
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt=format1.parse(date);
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
    /// <summary>
    /// 1-7
    /// </summary>
    /// <param name="date"></param>
    /// <returns></returns>
    */
     public static int GetIntWeekDayT1(Date date) throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 7;
        return w;
    }

    /**
    /// <summary>
    /// Get month short name . eg:jan,sep,oct
    /// </summary>
    /// <param name="m"></param>
    /// <returns></returns>
   */
    public static String GetMonthShortName(String m)
    {
        String months = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";
        return months.substring((Integer.parseInt(m) - 1) * 3, (Integer.parseInt(m) - 1) * 3+3);

    }

    /**
    /// <summary>
    /// Get month by short name
    /// </summary>
    /// <param name="m"></param>
    /// <returns></returns>
     */
    public static String GetMonthByShortName(String m)
    {

        if(m.equals("JAN"))
        {
            return "01";
        }
        else if(m.equals("FEB"))
        {
            return "02";
        }
        else if(m.equals("MAR"))
        {
            return "03";
        }
        else if(m.equals("APR"))
        {
            return "04";
        }
        else if(m.equals("MAY"))
        {
            return "05";
        }
        else if(m.equals("JUN"))
        {
            return "06";
        }
        else if(m.equals("JUL"))
        {
            return "07";
        }
        else if(m.equals("AUG"))
        {
            return "08";
        }
        else if(m.equals("SEP"))
        {
            return "09";
        }
        else if(m.equals("OCT"))
        {
            return "10";
        }
        else if(m.equals("NOV"))
        {
            return "11";
        }
        else if(m.equals("DEC"))
        {
            return "12";
        }
        System.out.println("test:"+m);
        return "";
    }

    /**
    /// <summary>
    /// Get No of Week in year
    /// </summary>
    /// <param name="dt"></param>
    /// <returns></returns>
     */
    public static int GetWeekOfYear(Date dt)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setGregorianChange(dt);
        int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        return weekOfYear;
    }

    /**
    /// <summary>
    /// Get No of week in a month
    /// </summary>
    /// <param name="day"></param>
    /// <param name="WeekStart"></param>
    /// <returns></returns>
     */
    public static int WeekOfMonth(Date day, int WeekStart)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setGregorianChange(day);
        int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);
        return weekOfMonth;
    }

    /**
    /// <summary>
    /// to yyyy-MM-dd HH:mm:ss
    /// </summary>
    /// <returns></returns>
     */
    public static String ToT1(Date dt)
    {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(dt);
    }

    /// <summary>
    /// to yyyy-MM-dd
    /// </summary>
    /// <returns></returns>
    public static String ToT2(Date dt)
    {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dt);
    }

    /// <summary>
    ///  0730->07:30
    /// </summary>
    /// <param name="str"></param>
    /// <returns></returns>
    public static String ToT3(String str)
    {
        return str.substring(0, 2) + ":" + str.substring(2, 4);
    }

    /// <summary>
    /// 20100730 to datetime
    /// </summary>
    /// <returns></returns>
    public static Date T4(String date) throws Exception
    {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt=format1.parse(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
        return dt;
    }


    /// <summary>
    /// 2010-01-02 ->02JAN
    /// </summary>
    /// <param name="dt"></param>
    /// <returns></returns>
    public static String ToT5(Date dt)
    {
        SimpleDateFormat format1 = new SimpleDateFormat("ddMM");
        String dtDM=format1.format(dt);
        Integer month=Integer.parseInt(dtDM.substring(2,4));
        dtDM=dtDM.substring(0,2);
        switch (month)
        {
            case 1:
                dtDM+="JAN";
                break;
            case 2:
                dtDM+="FEB";
                break;
            case 3:
                dtDM+="MAR";
                break;
            case 4:
                dtDM+="APR";
                break;
            case 5:
                dtDM+="MAY";
                break;
            case 6:
                dtDM+="JUN";
                break;
            case 7:
                dtDM+="JUL";
                break;
            case 8:
                dtDM+="AUG";
                break;
            case 9:
                dtDM+="SEP";
                break;
            case 10:
                dtDM+="OCT";
                break;
            case 11:
                dtDM+="NOV";
                break;
            case 12:
                dtDM+="DEC";
                break;
        }
        return dtDM;
    }

    /// <summary>
    /// 18AUG -> 2011-08-18
    /// 18AUG11 -> 2011-08-18
    /// </summary>
    /// <param name="date"></param>
    /// <returns></returns>
    public static String T5ToT1(String date)
    {
        String year;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        Date dt=new Date();
        if (date.length()== 7)
        {
            year=format1.format(dt).substring(0,2)+date.substring(5, 7);
        }
        else
        {
            year = format1.format(dt);
        }
        String month = GetMonthByShortName(date.substring(2, 5));
        String day = date.substring(0, 2);
        return year + "-" + month + "-" + day;
    }

    /// <summary>
    /// 18AUG -> 2011-08-18(小于当前日期+1年)
    /// 18AUG11 -> 2011-08-18
    /// </summary>
    /// <param name="date"></param>
    /// <returns></returns>
    public static String T5ToT1_2(String date) throws Exception
    {
        String year;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        Date dt=new Date();
        if (date.length() == 7)
        {
            year=format1.format(dt).substring(0,2)+date.substring(5, 7);
        }
        else
        {
            year = format1.format(dt);
        }
        String month = GetMonthByShortName(date.substring(2, 5));
        String day = date.substring(0, 2);
        if (date.length() == 5)
        {
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

            try
            {

                if (format2.parse(year + "-" + month + "-" + day).getTime()<new Date().getTime())
                {
                    year =String.valueOf(Integer.parseInt(format1.format(new Date())) + 1);
                }
            }
            catch(Exception ex)
            {
                year =String.valueOf(Integer.parseInt(format1.format(new Date())) + 1);
            }

        }

        return year + "-" + month + "-" + day;

    }

    /// <summary>
    /// 2010-01-02 ->02JAN
    /// </summary>
    /// <param name="dt"></param>
    /// <returns></returns>
    public static String ToT5(String dt) throws Exception
    {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return ToT5(format1.parse(dt));
    }

    /// <summary>
    /// 2008-01-01 -> 01JAN08
    /// </summary>
    /// <param name="d"></param>
    /// <returns></returns>
    public static String ToT6(String d)
    {
        String[] dd = d.split("-");
        String return_date = "";
        return_date = dd[2] + GetMonthShortName(dd[1]);
        return_date += dd[0].substring(2, 4);
        return return_date;

    }

    /// <summary>
    /// 2008-01-01 07:00 -> 01JAN08 07:00
    /// </summary>
    /// <param name="d"></param>
    /// <returns></returns>
    public static String ToT7(String d) throws Exception
    {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm");
        Date dt = format2.parse(d);

        String part1 = ToT6(format1.format(dt));
        String part2 = format3.format(dt);

        return part1 + " " + part2;

    }

    /// <summary>
    /// 20MAR 0910 ->yyyy-MM-dd hh:mm:ss
    /// 20MAR 0910+2 ->yyyy-MM-dd hh:mm:ss
    /// </summary>
    /// <param name="d"></param>
    /// <returns></returns>
    public static String T8ToT1(String d) throws Exception
    {

        String date = d.split(" ")[0];
        String time = d.split(" ")[1];

        String modify = null;
        String modifyDay = null;

        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        Pattern pat1= Pattern.compile("(//d//d//d//d)([//+//-])(//d)");
        Matcher mc=pat1.matcher(time);
        Calendar cal1 = new GregorianCalendar();
        while(mc.find())
        {
            modify=mc.group(1);
            modifyDay=mc.group(2);
            time=mc.group(0);
            if (modify.equals("+"))
            {
                Date sd=format1.parse(T5ToT1_2(date));
                cal1.setTime(sd);
                cal1.add(Calendar.DATE,Integer.parseInt(modifyDay));
                date = Dt.ToT5(format1.format(cal1.getTime()));
            }
            else if (modify.equals("-"))
            {
                Date sd=format1.parse(T5ToT1_2(date));
                cal1.setTime(sd);
                cal1.add(Calendar.DATE,Integer.parseInt("-"+modifyDay));
                date = Dt.ToT5(format1.format(cal1.getTime()));
            }

        }

        String date2 = Dt.T5ToT1_2(date) + " " + Dt.ToT3(time);

        return date2;

    }


}
