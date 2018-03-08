package org.jack.anime.utils.tool;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

/**
 * @author jack
 *
 */
public class DateUtil {

	  public static Date getMonthEnd(Date date)
	  {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    
	    calendar.set(5, calendar.getActualMaximum(5));
	    calendar.add(14, 86399999);
	    return calendar.getTime();
	  }
	  
	  public static java.util.Date parseDate(java.sql.Date date)
	  {
	    return date;
	  }
	  
	  public static java.sql.Date parseSqlDate(java.util.Date date)
	  {
	    if (date != null) {
	      return new java.sql.Date(date.getTime());
	    }
	    return null;
	  }
	  
	  public static int getYear(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(1);
	  }
	  
	  public static int getMonth(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(2) + 1;
	  }
	  
	  public static int getDayOfMonth(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(5);
	  }
	  
	  public static int getDayOfWeek(java.util.Date date)
	  {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal.get(7);
	  }
	  
	  public static int getHour(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(11);
	  }
	  
	  public static int getMinute(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(12);
	  }
	  
	  public static int getSecond(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(13);
	  }
	  
	  public static long getMillis(java.util.Date date)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.getTimeInMillis();
	  }
	  
	  public static int[] getDateData(java.util.Date date)
	  {
	    int[] dateData = new int[5];
	    Calendar now = Calendar.getInstance();
	    now.setTime(date);
	    dateData[0] = now.get(1);
	    dateData[1] = now.get(5);
	    dateData[2] = (now.get(2) + 1);
	    dateData[3] = now.get(10);
	    dateData[4] = now.get(12);
	    dateData[5] = now.get(13);
	    return dateData;
	  }
	  
	  public static boolean isSameWeekDates(java.util.Date date1, java.util.Date date2)
	  {
	    Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    cal1.setTime(date1);
	    cal2.setTime(date2);
	    int subYear = cal1.get(1) - cal2.get(1);
	    if (subYear == 0)
	    {
	      if (cal1.get(3) == cal2.get(3)) {
	        return true;
	      }
	    }
	    else if ((1 == subYear) && (11 == cal2.get(2)))
	    {
	      if (cal1.get(3) == cal2.get(3)) {
	        return true;
	      }
	    }
	    else if ((-1 == subYear) && (11 == cal1.get(2)) && 
	      (cal1.get(3) == cal2.get(3))) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static String getSeqWeek()
	  {
	    Calendar c = Calendar.getInstance(Locale.CHINA);
	    String week = Integer.toString(c.get(3));
	    if (week.length() == 1) {
	      week = "0" + week;
	    }
	    String year = Integer.toString(c.get(1));
	    return year + week;
	  }
	  
	  public static java.util.Date getDateByDayOfWeek(java.util.Date date, int dayOfWeek)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.set(7, dayOfWeek);
	    return c.getTime();
	  }
	  
	 /* public static Calendar getDateFromIDCard(String IDCardNum)
	  {
	    int idLength = IDCardNum.length();
	    Calendar cal = Calendar.getInstance();
	    int day;
	    if (idLength == 18)
	    {
	      int year = Integer.parseInt(IDCardNum.substring(6, 10));
	      int month = Integer.parseInt(IDCardNum.substring(10, 12));
	      day = Integer.parseInt(IDCardNum.substring(12, 14));
	    }
	    else
	    {
	      int day;
	      if (idLength == 15)
	      {
	        int year = Integer.parseInt(IDCardNum.substring(6, 8)) + 1900;
	        int month = Integer.parseInt(IDCardNum.substring(8, 10));
	        day = Integer.parseInt(IDCardNum.substring(10, 12));
	      }
	      else
	      {
	        return null;
	      }
	    }
	    int day;
	    int month;
	    int year;
	    cal.set(year, month, day);
	    return cal;
	  }*/
	  
	  public static java.util.Date changeDay(java.util.Date date, int offset)
	  {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(6, calendar.get(6) + offset);
	    return calendar.getTime();
	  }
	  
	  public static Calendar changeDay(Calendar calendar, int offset)
	  {
	    calendar.set(6, calendar.get(6) + offset);
	    return calendar;
	  }
	  
	  public static int getDiffDate(java.util.Date date, java.util.Date date1)
	  {
	    return (int)((date.getTime() - date1.getTime()) / 86400000L);
	  }
	  
	  public static int getDiffDate(Calendar date, Calendar date1)
	  {
	    return getDiffDate(date.getTime(), date1.getTime());
	  }
	  
	  public static java.util.Date addDate(java.util.Date date, int day)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(getMillis(date) + day * 24L * 3600L * 1000L);
	    return c.getTime();
	  }
	  
	  public static java.util.Date addMillis(java.util.Date date, long millis)
	  {
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(getMillis(date) + millis);
	    return c.getTime();
	  }
	  
	  public static java.util.Date parseDate(String dateStr, String formatStr)
	  {
	    SimpleDateFormat format = new SimpleDateFormat(formatStr);
	    try
	    {
	      return format.parse(dateStr);
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  public static String formatDate(java.util.Date date, String format)
	  {
	    String result = "";
	    if (date != null) {
	      try
	      {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        result = sdf.format(date);
	      }
	      catch (Exception ex)
	      {
	        ex.printStackTrace();
	      }
	    }
	    return result;
	  }
	  
	  public static String formatDate(java.util.Date date, int i, String format)
	  {
	    DateFormat df = new SimpleDateFormat(format);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(5, i);
	    return df.format(calendar.getTime());
	  }
	  
	  public static java.sql.Date parseSqlDate(String dateStr, String format)
	  {
	    java.util.Date date = parseDate(dateStr, format);
	    return parseSqlDate(date);
	  }
	  
	  public static Timestamp parseTimestamp(String dateStr, String format)
	  {
	    java.util.Date date = parseDate(dateStr, format);
	    if (date != null)
	    {
	      long t = date.getTime();
	      return new Timestamp(t);
	    }
	    return null;
	  }
	  
	  public static boolean isLeapYear(int year)
	  {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(year, 2, 1);
	    calendar.add(5, -1);
	    if (calendar.get(5) == 29) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static int compareTime(String time1, String time2)
	  {
	    java.util.Date newDate1 = parseDate("1990-01-01 " + time1, "yyyy-MM-dd HH:mm:ss");
	    java.util.Date newDate2 = parseDate("1990-01-01 " + time2, "yyyy-MM-dd HH:mm:ss");
	    if (getMillis(newDate1) - getMillis(newDate2) > 0L) {
	      return 1;
	    }
	    if (getMillis(newDate1) - getMillis(newDate2) < 0L) {
	      return -1;
	    }
	    return 0;
	  }
	  
	  public static boolean isTimeBetween(String time, String beginTime, String endTime)
	  {
	    java.util.Date newDate = parseDate("1990-01-01 " + time, "yyyy-MM-dd HH:mm:ss");
	    java.util.Date newDate1 = parseDate("1990-01-01 " + beginTime, "yyyy-MM-dd HH:mm:ss");
	    java.util.Date newDate2 = parseDate("1990-01-01 " + endTime, "yyyy-MM-dd HH:mm:ss");
	    if ((getMillis(newDate) - getMillis(newDate1) >= 0L) && (getMillis(newDate) - getMillis(newDate2) <= 0L)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static String format(java.util.Date date, String format)
	  {
	    String result = "";
	    try
	    {
	      if (date != null)
	      {
	        DateFormat df = new SimpleDateFormat(format);
	        result = df.format(date);
	      }
	    }
	    catch (Exception localException) {}
	    return result;
	  }
	  
	  public static GregorianCalendar[] getBetweenDate(String d1, String d2)
	  {
	    Vector<GregorianCalendar> v = new Vector();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    GregorianCalendar gc1 = new GregorianCalendar();GregorianCalendar gc2 = new GregorianCalendar();
	    try
	    {
	      gc1.setTime(sdf.parse(d1));
	      gc2.setTime(sdf.parse(d2));
	      do
	      {
	        GregorianCalendar gc3 = (GregorianCalendar)gc1.clone();
	        v.add(gc3);
	        gc1.add(5, 1);
	      } while (!gc1.after(gc2));
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return (GregorianCalendar[])v.toArray(new GregorianCalendar[v.size()]);
	  }
}
