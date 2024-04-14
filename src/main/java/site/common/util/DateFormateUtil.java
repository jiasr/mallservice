package site.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * add by bzh 2008.11.19 
 * 格式化日期用
 * @author Administrator
 *
 */
public class DateFormateUtil {

	public static final String TIMESTAMP_TYPE ="yyyy-MM-dd HH:mm:ss:SSS";
	/**
	 * 含毫秒的日期
	 * @return
	 */
	public static String dateFormatToString(){
		Calendar  cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat(TIMESTAMP_TYPE);
		String  dateFormat = sdf1.format(cal.getTime());
		//System.out.println(dateFormat);
		return dateFormat;
	}
	
	/**
	 * 根据 日期格式返回相应的日期
	 * add by ymz
	 * @param format "yyyy-MM-dd HH:mm:ss:SSS"
	 * @return
	 */
	public static String formatDateByFormat(String format){
		Calendar  cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		String  dateFormat = sdf1.format(cal.getTime());
		return dateFormat;
	}
	
	
}
