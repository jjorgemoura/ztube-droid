package com.zindon.ztube.utils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ZDDate extends GregorianCalendar {

	//--------------------------VARS------------------------------------
	private static final String TAG = "ZDDate";
    
	/**
     * The format used by default (yyyy-MM-dd)
     */
    public static final String FORMAT_ONLY_DATE = "yyyy-MM-dd";

    /**
     * The format used by default (yyyy-MM-dd HH:mm)
     */
    public static final String FORMAT_DATE_HOUR_MIN = "yyyy-MM-dd HH:mm";

    /**
     * The format used by default (yyyy-MM-dd HH:mm:ss)
     */
    public static final String FORMAT_DATE_HOUR_MIN_SS = "yyyy-MM-dd HH:mm:ss.SS";
    
    
    private String mDefaultFormat = ZDDate.FORMAT_ONLY_DATE;
    
    
    
  //--------------------------CONSTRUTORES------------------------------------
    /**
     * Default constructor.
     */
    public ZDDate() {

        super();
    }

    /**
     * Constructor with init parameter.
     * 
     * @param timeInMillis The time in milisecs.
     */
    public ZDDate(long timeInMillis) {

        super();
        this.setTimeInMillis(timeInMillis);
    }

    /**
     * Constructor with init parameter.
     * 
     * @param date The java.util.Date
     */
    public ZDDate(Date date) {

        super();
        this.setTime(date);
    }

    /**
     * Constructor with init parameter.
     * 
     * @param inDate The date as String.
     */
    public ZDDate(String inDate) {
                
        //Alternativa
        super();
        String f = ZDDate.FORMAT_ONLY_DATE;
        
        
        try {
            
            String[] split = inDate.split("-");
        
            
            if(split[0].length() == 2 && split[1].length() == 2 && split[2].length() == 4) {
            
                f = "dd-MM-yyyy";
            }
        }
        catch(Exception ex) {
        
            throw new RuntimeException("Error parsing String to IZDate");
        }
        
        
        this.mDefaultFormat = f;

        if (inDate == null) {
            throw new InvalidParameterException("The date could not be null");
        }

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.mDefaultFormat);

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            throw new InvalidParameterException("The date and format have diferent sizes");
        }

        dateFormat.setLenient(false);

        try {

            //parse the inDate parameter
            Date parsedDate = dateFormat.parse(inDate.trim());
            this.setTime(parsedDate);

        } catch (ParseException pe) {
            throw new InvalidParameterException("Invalid date");
        }
    }

    /**
     * Constructor with init parameter.
     * 
     * @param inDate The date as String.
     * @param defaultDateFormat The date format.
     */
    public ZDDate(String inDate, String defaultDateFormat) {

        super();
        this.mDefaultFormat = defaultDateFormat;

        if (inDate == null) {
            throw new InvalidParameterException("The date could not be null");
        }

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.mDefaultFormat);

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            throw new InvalidParameterException("The date and format have diferent sizes");
        }

        dateFormat.setLenient(false);

        try {

            //parse the inDate parameter
            Date parsedDate = dateFormat.parse(inDate.trim());
            this.setTime(parsedDate);

        } catch (ParseException pe) {
            throw new InvalidParameterException("Invalid date");
        }
    }
    
    
    
    
    
    
    
    
  //--------------Public Methods ACTIONS-------------------------
    /**
     * The method add some minutes to this IZDate instance.
     * 
     * @param minutes 
     */
    public void addMinutes(int minutes) {

        this.add(Calendar.MINUTE, minutes);
    }
    
    /**
     * The method add some hours to this IZDate instance.
     * 
     * @param hours 
     */
    public void addHours(int hours) {

        this.add(Calendar.HOUR, hours);
    }

    /**
     * The method add some days to this IZDate instance.
     * 
     * @param days 
     */
    public void addDays(int days) {

        this.add(Calendar.DAY_OF_MONTH, days);
    }

    /**
     * The method add some months to this IZDate instance.
     * 
     * @param months 
     */
    public void addMonths(int months) {

        this.add(Calendar.MONDAY, months);
    }

    /**
     * The method add some years to this IZDate instance.
     * 
     * @param years 
     */
    public void addYears(int years) {

        this.add(Calendar.YEAR, years);
    }

    /**
     * The method subtract some minutes to this IZDate instance.
     * 
     * @param days 
     */
    public void subtractDays(int days) {

        this.subtractDays(days);
    }

    
    
    
    
    
    //--------------Public Methods GETS-------------------------
    /**
     * Return this date represented as String.
     * 
     * @return The date as string.
     */
    @Override
    public String toString() {

        return this.toString(this.mDefaultFormat);
    }

    /**
     * Return this date represented as String with some specific date format.
     * 
     * @param format The format. This must be one of the formats available in this class (static fields).
     * @return The date as String.
     */
    public String toString(String format) {


        SimpleDateFormat df = new SimpleDateFormat(format);


        String s = df.format(this.getTime());

        return s;
    }

    /**
     * This method return the age (difference years) between this date and the date passed as parameter.
     * @param untilIZDate the date to test the age.
     * @return The age between this date and the parameter date.
     */
    public int ageUntil(ZDDate untilIZDate) {

        
        int result = untilIZDate.get(Calendar.YEAR) - this.get(Calendar.YEAR);

        if ((this.get(Calendar.MONTH) > untilIZDate.get(Calendar.MONTH)) || (this.get(Calendar.MONTH) == untilIZDate.get(Calendar.MONTH) && this.get(Calendar.DAY_OF_MONTH) > untilIZDate.get(Calendar.DAY_OF_MONTH))) {

            result--;
        }
        
//        if (untilIZDate.get(Calendar.MONTH) > (this.get(Calendar.MONTH)) || (untilIZDate.get(Calendar.MONTH) == this.get(Calendar.MONTH) && untilIZDate.get(Calendar.DAY_OF_MONTH) > this.get(Calendar.DAY_OF_MONTH))) {
//
//            result--;
//        }
        
        
        if(result < 0) {
        
            return 0;
        }
        

        //LOG.info("AGE: " + String.valueOf(res));
        return result;
    }

    /**
     * This method calculate the days between dates
     * @param date  the referece date.
     * @return The number of days.
     */
    public long diffDaysWithIZDate(ZDDate date) {

        long result = 0;

        long milidiff = this.getTimeInMillis() - date.getTimeInMillis();
        result = milidiff / 86400000;

        return result;

    }
    
    /**
     * This method calculate the days between dates
     * @param date  the referece date.
     * @return The number of days.
     */
    public long diffDaysWithIZDate(ZDDate date, boolean onlyDate) {

        long result = 0;

        
        if(onlyDate) {
            
        
            GregorianCalendar gc2 = new GregorianCalendar();
            gc2.set(Calendar.HOUR_OF_DAY, 0);
            gc2.set(Calendar.MINUTE, 0);
            gc2.set(Calendar.SECOND, 0);
            gc2.set(Calendar.DAY_OF_MONTH, this.get(Calendar.DAY_OF_MONTH));
            gc2.set(Calendar.YEAR, this.get(Calendar.YEAR));
            gc2.set(Calendar.MONTH, this.get(Calendar.MONTH));
        
        
            GregorianCalendar gcX = new GregorianCalendar();
            gcX.set(Calendar.HOUR_OF_DAY, 0);
            gcX.set(Calendar.MINUTE, 0);
            gcX.set(Calendar.SECOND, 0);
            gcX.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
            gcX.set(Calendar.YEAR, date.get(Calendar.YEAR));
            gcX.set(Calendar.MONTH, date.get(Calendar.MONTH));
               
                

            long milidiffXXX = gcX.getTimeInMillis() - gc2.getTimeInMillis();
            result = milidiffXXX / 86400000;
    
        }
        else {
        
            result = this.diffDaysWithIZDate(date);
        }
        

        return result;

    }
    

    /**
     * This method test if the both dates are from same day.
     * 
     * @param date the reference date.
     * @return A boolean indicating if both dates are from the same day.
     */
    public boolean isSameDayAs(ZDDate date) {

        if (this.get(Calendar.YEAR) == date.get(Calendar.YEAR) && this.get(Calendar.MONTH) == date.get(Calendar.MONTH) && this.get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH)) {

            return true;
        } else {

            return false;
        }
    }

    	

    
    
    
    
    //-----------------PUBLIC Methods AUX----------------------
    /**
     * 
     * @param defaultFormat The date format.
     */
    public void setDefaultFormat(String defaultFormat) {

        this.mDefaultFormat = defaultFormat;
    }

    /**
     * 
     * @return The date format.
     */
    public String getDefaultFormat() {

        return mDefaultFormat;
    }
    
    /**
     * 
     * @return The date format.
     */
    public int getMonth() {

        return this.get(Calendar.MONTH) + 1;
    }
    
    public int getYear() {

        return this.get(Calendar.YEAR);
    }
    
    public int getDayOfMonth() {

        return this.get(Calendar.DAY_OF_MONTH);
    }
    
    
   
    
}
