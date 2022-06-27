package com.example.bootmaven.tools;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: JavaApp
 * @description: 关于时间的工具集合
 * @author: caowujun
 * @create: 2018-07-19 10:17
 **/
public class DateUtils {

    /*
     * @description：
     * @param： [date]
     * @return： java.lang.String
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static String LongTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(date).toString();
    }

    /*
     * @description：
     * @param： [date]
     * @return： java.lang.String
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static String ShortTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }

    /*
     * @description：
     * @param： [date]
     * @return： java.util.Date
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Date StringToShortDate(String date) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date);
    }

    /**
     * @Description:
     * @Param: * @param date
     * @return: java.util.Date
     * @Author: caowujun
     * @Date: 2018/12/8
     */
    public static Date StringToLongDate(String date) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(date);
    }

    /*
     * @description：
     * @param： [fDate, oDate]
     * @return： int
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static int daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        int year1 = aCalendar.get(Calendar.YEAR);
        aCalendar.setTime(oDate);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        int year2 = aCalendar.get(Calendar.YEAR);

        return 1+day2 - day1 + 365 * (year2 - year1);

    }

    /*
     * @description：
     * @param： [limit]
     * @return： java.lang.String
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static String addDays(Integer limit) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, limit);
        Date date = calendar.getTime();
        return simpleDateFormat.format(date).toString();
    }

    /*
     * @description：
     * @param： [d, limit]
     * @return： java.util.Date
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Date addDays(Date d, int limit) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, limit);
        return calendar.getTime();
    }

    /*
     * @description：
     * @param： [calendar1]
     * @return： java.util.Date
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Date getBeginOfDate(Calendar calendar) {
        //Calendar calendar1 = Calendar.getInstance();
        calendar .set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        return calendar.getTime();

    }
    /**
     * @Author wujun.cao
     * @Description 
     * @Date Created in 2021/03/26 11:41
     * @param calendar
     * @Return {@link String}
     **/
    public static String getBeginOfDate1(Calendar calendar) {
        calendar .set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        Date beginOfDate = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(beginOfDate);
    }
    /*
     * @description：
     * @param： [calendar1] 
     * @return： java.util.Date 
     * @author： caowujun
     * @date： 2019/8/14 
     */ 
    public static String getFirstDay(Date date ) {
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);

        return  ShortTime(calendar.getTime());
    }
    /*
     * @description：
     * @param： [calendar2]
     * @return： java.util.Date
     * @author： caowujun
     * @date： 2019/4/29
     */
    public static Date getEndOfDate(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);

        return calendar.getTime();
    }
    /**
     * @Author wujun.cao
     * @Description 
     * @Date Created in 2021/03/26 11:42
     * @param calendar
     * @Return {@link String}
     **/
    public static String getEndOfDate1(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        Date endOfDate = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(endOfDate);
    }
/*
 * @description：
 * @param： [date] 
 * @return： java.lang.String 
 * @author： caowujun
 * @date： 2019/8/14 
 */ 
    public static String getlastDay(Date date) {
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return  ShortTime(calendar.getTime());
    }

}
