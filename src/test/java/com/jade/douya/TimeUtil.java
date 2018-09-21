package com.jade.douya;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TimeUtil
{

	public static Timestamp getNowTimeStamp()
	{
		return new Timestamp(new Date().getTime());
	}

	public static Timestamp getNowTimeStamp(String format)
	{
		return getTimeStamp(getDateFormat(format), format);
	}

	public static Timestamp getTimeStamp(long time)
	{
		return new Timestamp(time);
	}

	public static Timestamp getTimeStamp(String datestr, String format)
	{
		if (datestr == null)
		{
			return getNowTimeStamp();
		}
		if (datestr.equals(""))
		{
			return getNowTimeStamp();
		}
		return new Timestamp(getDateFormat(datestr, format));
	}

	public static String getDateFormat(long date, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getDateFormat(Long date, String format)
	{
		if (date == null)
		{
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
 
	public static String getDateFormat(Timestamp date, String format)
	{
		if (date == null)
		{
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getDateFormat(Date date, String format)
	{
		if (date == null)
		{
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getDateFormat(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static Long getDateFormat(String date, String format)
	{ 
		try
		{
			if (!StringUtils.isEmpty(date))
			{
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.parse(date).getTime();
			}
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return new Date().getTime();
	}
	
	public static Long getDateFormat(String date, String format,Long defalut)
	{ 
		try
		{
			if (!StringUtils.isEmpty(date))
			{
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.parse(date).getTime();
			}
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return defalut;
	}

	public static Date getDate(String date, String format)
	{
		if (date == null)
		{
			return new Date();
		}
		if (date.equals(""))
		{
			return new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try
		{
			return sdf.parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return new Date();
		}
	}

	public static Long getDayTime(int daynum,int mode)
	{
		Long dayTime=getNowDate();
		if(mode==0)
		{
			dayTime=dayTime-daynum*24L*3600L*1000L; 
		}
		if(mode==1)
		{
			dayTime=dayTime+daynum*24L*3600L*1000L; 
		} 
		return TimeUtil.getDateFormat(getDateFormat(dayTime, "yyyy-MM-dd"),"yyyy-MM-dd"); 
	}
	
	
	public static Long getNowDate()
	{
		return (new Date()).getTime();
	}

	public static Long getNowDate(int addday)
	{
		return (new Date()).getTime()-addday*24*3600*1000L;
	}
	
	public static Long getNowDateAdd(int addday)
	{
		return (new Date()).getTime()+addday*24*3600*1000L;
	}

	public static String formatTime(long size)
	{
		String s = "";
		if (size < 1000)
		{
			String msstr = size + "";
			if (size < 10)
			{
				msstr = "00" + msstr;
			} else if (size < 100)
			{
				msstr = "0" + msstr;
			}
			s = "00:00:00." + msstr;
		} else if (size < 1000 * 60)
		{
			long second = (size / 1000);
			long ms = size - second * 1000;

			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}

			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}

			s = "00:00:" + secondstr + "." + msstr;

		} else if (size < 1000 * 60 * 60)
		{
			long minute = (size / (1000 * 60));
			long second = (size - minute * 1000 * 60) / 1000;
			long ms = size - minute * 60 * 1000 - second * 1000;
			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}
			String minutestr = minute + "";
			if (minute < 10)
			{
				minutestr = "0" + minutestr;
			}
			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}

			s = "00:" + minutestr + ":" + secondstr + "." + msstr;
		} else
		{
			long hour = (size / (1000 * 60 * 60));
			long minute = (size - hour * (1000 * 60 * 60)) / (1000 * 60);
			long second = (size - hour * (1000 * 60 * 60) - minute * 1000 * 60) / 1000;
			long ms = (size - hour * (1000 * 60 * 60) - minute * 1000 * 60 - second * 1000);
			String hourstr = hour + "";
			if (hour < 10)
			{
				hourstr = "0" + hourstr;
			}
			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}
			String minutestr = minute + "";
			if (minute < 10)
			{
				minutestr = "0" + minutestr;
			}
			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}
			s = hourstr + ":" + secondstr + ":" + secondstr + "." + msstr;
		}
		return s;
	}
	
	public static String formatTvTime(long size)
	{
		String s = "";
		if (size < 1000)
		{
			String msstr = size + "";
			if (size < 10)
			{
				msstr = "00" + msstr;
			} else if (size < 100)
			{
				msstr = "0" + msstr;
			}
			s = "00:00:00:" + msstr;
		} else if (size < 1000 * 60)
		{
			long second = (size / 1000);
			long ms = size - second * 1000;

			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}

			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}

			s = "00:00:" + secondstr + ":" + msstr;

		} else if (size < 1000 * 60 * 60)
		{
			long minute = (size / (1000 * 60));
			long second = (size - minute * 1000 * 60) / 1000;
			long ms = size - minute * 60 * 1000 - second * 1000;
			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}
			String minutestr = minute + "";
			if (minute < 10)
			{
				minutestr = "0" + minutestr;
			}
			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}

			s = "00:" + minutestr + ":" + secondstr + ":" + msstr;
		} else
		{
			long hour = (size / (1000 * 60 * 60));
			long minute = (size - hour * (1000 * 60 * 60)) / (1000 * 60);
			long second = (size - hour * (1000 * 60 * 60) - minute * 1000 * 60) / 1000;
			long ms = (size - hour * (1000 * 60 * 60) - minute * 1000 * 60 - second * 1000);
			String hourstr = hour + "";
			if (hour < 10)
			{
				hourstr = "0" + hourstr;
			}
			String secondstr = second + "";
			if (second < 10)
			{
				secondstr = "0" + secondstr;
			}
			String minutestr = minute + "";
			if (minute < 10)
			{
				minutestr = "0" + minutestr;
			}
			String msstr = ms + "";
			if (ms < 10)
			{
				msstr = "00" + msstr;
			} else if (ms < 100)
			{
				msstr = "0" + msstr;
			}
			s = hourstr + ":" + secondstr + ":" + secondstr + ":" + msstr;
		}
		if(s.length()>0)
		{
			s=s.substring(0, s.length()-1);
		}
		return s;
	}

	public static Long parseTvTime(String time)
	{
		if(StringUtils.isEmpty(time))
		{
			return 0l;
		}
		String [] tarr=time.split("\\:");
	    long t=0;
	    t=t+new Long(tarr[0])*3600*1000;
	    t=t+new Long(tarr[1])*60*1000;
	    t=t+new Long(tarr[2])*1000;
	    t=t+new Long(tarr[3])*10; 
		return t;
	}
	
	public static List<String> getDayBetween(String start, String end)
	{
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			Date d1 = sdf.parse(start);
			Date d2 = sdf.parse(end);
			long daysBetween = (d2.getTime() - d1.getTime()) / (3600 * 24 * 1000);
			for (int i = 0; i < daysBetween; i++)
			{
				d1.setTime(d1.getTime() + 24 * 3600 * 1000L);
				list.add(sdf.format(d1));
			}

		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return list;

	}

	public static String getDateFormatC(Long date, String format)
	{
		if (date == null)
		{
			return "";
		}
		long diff=((new Date()).getTime()-date)/1000;
		if(diff<60)
		{
			return diff+"秒前";
		}
		if(diff<3600)
		{
			return (diff/60)+"分钟前";
		}
		if(diff<(3600*24))
		{
			return (diff/(60*60))+"小时前";
		}
		if(diff<(3600*24*7))
		{
			return (diff/(60*60*7))+"天前";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static void main(String args[])
	{
		System.out.println(TimeUtil.formatTvTime(12320L) );
		System.out.println(TimeUtil.parseTvTime("00:00:12:32") );
		System.out.println(TimeUtil.getDateFormat(0L, "yyyy-MM-dd"));
		Date date =  new Date();
		String thisDateStr = getDateFormat(date,"yyyyMMdd");
		System.out.println("====>"+thisDateStr);
		
		Long startThisDayTime = getDateFormat(thisDateStr,"yyyyMMdd");
		Long endThisDayTime = getDateFormat(thisDateStr,"yyyyMMdd")+24L*3600L*1000L;
		
		Long TEST = getDateFormat("20150201","yyyyMMdd");
		
		System.out.println("startThisDayTime====>"+startThisDayTime);
		System.out.println("endThisDayTime====>"+endThisDayTime);
		if(startThisDayTime.longValue()<= TEST && TEST < endThisDayTime.longValue()){
			System.out.println("TEST====>"+TEST);
		}
		// System.out.println(TimeUtil.getDateFormat(TimeUtil.getNowDate()+(1000*60*60*24*365),"yyyy-MM-dd"));
		// System.out.println(1000L*60L*60L*24L*365L);
		// Long date=TimeUtil.getNowDate();
  

	}

}
