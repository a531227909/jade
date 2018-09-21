package com.jade.uitil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class tesst {
	
	
	public static void main(String[] args) throws ParseException {
		
		String str = "2017-12-31 23:59:59";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.parse(str).getTime());
		
	}
	
	  private static void setMinTime(Calendar calendar){  
	        calendar.set(Calendar.HOUR_OF_DAY, 0);  
	        calendar.set(Calendar.MINUTE, 0);  
	        calendar.set(Calendar.SECOND, 0);  
	        calendar.set(Calendar.MILLISECOND, 0);  
	    }  
	  
	  private static void setMaxTime(Calendar calendar){  
	        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));  
	        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));  
	        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));  
	        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));  
	    }  
	
	}


