package site.nebulas.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public final static String FORMAT_DATE = "yyyy-MM-dd";  
    public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";  

    public final static String FORMAT_DATE_ZH = "yyyy年MM月dd日";  
    public final static String FORMAT_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";  

    public final static String TYPE_DATE = "date";  
    public final static String TYPE_DATETIME = "datetime"; 
	
	/** 
     * 得到系统日期 
     * @return YYYY-MM-DD 
     */  
    public static String getSysdate(String formatType) {  
            java.sql.Timestamp timeNow = new java.sql.Timestamp(System.currentTimeMillis());  
            return format(timeNow, formatType);  
    }
    
    /** 
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date 
     * @dateType 格式化的类型,date和datetime 
     */  
    public static String format(Object dateValue, String dateType) {  
            if (dateValue == null)  
                    return "";  
            if (dateValue instanceof java.sql.Date) {  
                    return dateValue.toString();  
            } else if (dateValue instanceof java.util.Date) {  
                    if (dateType.equals(TYPE_DATE)) {  
                            java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE);  
                            return sfdate.format(dateValue);  
                    } else if (dateType.equals(TYPE_DATETIME)) {  
                            java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME);  
                            return sftime.format(dateValue);  
                    } else {  
                            return "非法日期格式[" + dateType + "]";  
                    }  
            } else {  
                    return "非日期类型";  
            }  
    }
    
    
    /** 
     * 转换日期对象为中文化日期 
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date 
     * @dateType 格式化的类型,date和datetime 
     */  
    public static String formatZh(Date dateValue, String dateType) {  
            if (dateValue == null)  
                    return "";  
            if (dateValue instanceof java.sql.Date) {  
                    return dateValue.toString();  
            } else if (dateValue instanceof java.util.Date) {  
                    if (dateType.equals(TYPE_DATE)) {  
                            java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE_ZH);  
                            return sfdate.format(dateValue);  
                    } else if (dateType.equals(TYPE_DATETIME)) {  
                            java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME_ZH);  
                            return sftime.format(dateValue);  
                    } else {  
                            return "非法日期格式[" + dateType + "]";  
                    }  
            } else {  
                    return "非日期类型";  
            }   
    }  

    
    public static void main(String[] args) {
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println(sdf.format(System.currentTimeMillis()));
    	//获取当前时间戳
    	System.out.println("获取当前时间戳:" + System.currentTimeMillis());
    	//new Date()
		System.out.println("new Date():" + new Date());
		
		System.out.println("获取当前时间戳:" + date.getTime());
		
		
	}
    
}
