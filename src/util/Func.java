package util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Func {
	
	/**
	 * 
	 */
	private static String formatPattern = "yyyy-MM-dd";
	
	private static SimpleDateFormat formatDate = new SimpleDateFormat(formatPattern);
	
	/**
	 * 鏍煎紡鍖栨棩鏈� 灏嗗瓧绗︿覆杞崲涓烘棩鏈�
	 * @param datestr 鏃ユ湡瀛楃涓�
	 * @return 鏍煎紡鍖栧悗鐨勬棩鏈�
	 */
	public static Date formatDate(String datestr){
		Date date = null;
		try {
			date = formatDate.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 *格式化日期 将字符串转换为日期
	 * @param datestr 日期字符串
	 * @return 格式化后的日期

	 */
	public static String formatString(Date date){
		String datestr = null;
		datestr = formatDate.format(date);
		return datestr;
	}
	
	/**
	   将日期格式化为yyyy-MM-dd格式的字符串
	 * @param date 日期
	 * @return yyyy-MM-dd格式的字符串

	   */
	  public static String getCurrDate(String format)
	  {
	    SimpleDateFormat sdfDate = new SimpleDateFormat(format);
	    return sdfDate.format(Calendar.getInstance().getTime());
	  }
	  
	  /**
	   * * 获取当前日期
	   * @param format 格式化模板
	   * @return 格式化之后的日期字符串

	   */
	  public static String getCurrDate()
	  {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy骞碝M骞磀d鏃�");
	    return sdfDate.format(Calendar.getInstance().getTime());
	  }
	  
	  /**
	   * 鑾峰彇褰撳墠骞翠唤
	   * @return 褰撳墠骞翠唤瀛楃涓�
	   */
	  public static String getCurrYear()
	  {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy");
	    return sdfDate.format(Calendar.getInstance().getTime());
	  }
	
	  /**
	   如果传入的字符串参数为null或者""，那么返回" "，否则返回传入的字符串
	   * @param s 传入的字符串
	   * @return 处理后字符串
	   * @throws Exception

	   */
	   public static String getBlankSpaceString(String s) 
	   {
	     if(s==null)
	       return " ";
	     else if(s.equals(""))
	       return " ";
	     else
	       return s;
	   }  
	  
	  /**
	    * 如果传入的字符串参数为null，那么返回""，否则返回传入的字符串
	   * @param o 传入的字符串对象
	   * @return String
	   * @throws Exception

	   */
	   public static String getString(Object o) 
	   {
	     if(o==null)
	       return "";
	     else
	       return String.valueOf(o);
	   }
	   
	   /**
	    * 濡傛灉浼犲叆鐨勬暟瀛楀弬鏁颁负0锛岄偅涔堣繑鍥�""锛屽惁鍒欒繑鍥炰紶鍏ョ殑鏁板瓧
	    * @param d
	    * @return
	    */
	   public static String getString(Double d) 
	   {
	     if(d==0)
	       return "";
	     else if(String.valueOf(d).indexOf(".0")>-1)
	     {
	    	 return String.valueOf(d).substring(0,String.valueOf(d).indexOf(".0"));
	     }
	     else
	       return String.valueOf(d);
	   }
	   
	   /**
	    * 灏嗗瓧绗︿覆鏁扮粍瑙ｆ瀽鎴怺 'a','b' ]杩斿洖锛岃嫢瀛楃涓叉暟缁勭殑闀垮害涓�0锛岄偅涔堣繑鍥�""
	    * @param a
	    * @return [ 'a','b' ]褰㈠紡鐨勫瓧绗︿覆
	    */
	   public static String arrayToSqlIn(String[] a) 
	   {
	     String sR = "";
	     if(a.length==0)
	       sR = "";
	     else
	     {
	       for(int i=0;i<a.length;i++)
	       {
	         sR += "'" + a[i]+"',";
	       }
	       sR = sR.substring(0, sR.length()-1);
	     }
	     
	     return sR;
	   }  
	   
	   /**
	    
	    */
	   public static String arrayToSqlIn(int[] a) 
	   {
	     String sR = "";
	     if(a.length==0)
	       sR = "";
	     else
	     {
	       for(int i=0;i<a.length;i++)
	       {
	         sR += a[i]+",";
	       }
	       sR = sR.substring(0, sR.length()-1);
	     }
	     return sR;
	   } 
	 
	   public static String getNewIndex(long curr, int digit) throws Exception
	   {
	     long idx = curr + 1;
	     long s = 1;
	     for (int i = 0; i < digit; i++)
	       s = s * 10;
	     if(idx>=s)
	       throw new Exception("鑷闀跨殑椤哄簭鍙疯秴鍑鸿寖鍥碵"+s+"]");
	     
	     String sIdx = String.valueOf(s + idx).substring(1);

	     return sIdx;
	   }
	   
	   /**
	    * 
	    */
	   public  static boolean checkDate(String dateStr) throws Exception
	   {
	     if(!isFixLengthNum(dateStr,8)) return false;
	     dateStr = dateStr.substring(0, 4)+"-"+dateStr.substring(4, 6)+"-"+dateStr.substring(6, 8);
	     DateFormat df = DateFormat.getDateInstance();
	     df.setLenient(false);
	     try
	     {
	       Date date = df.parse(dateStr);
	       return (date != null);
	     }
	     catch (Exception e)
	     {
	       return false;
	     }
	   }
	   
	 
	   public static int getStringLength(String str) throws Exception
	   {
	     String s = getString(str);
	     int length = 0;
	     length = s.getBytes("GBK").length;
	     return length;
	   }
	   
	 
	   public static boolean isFixLengthNum(String str,int length) throws Exception
	   {
	     String regexNum = "\\d{"+length+"}"; // 姣旇緝鐢ㄦ鍒欒〃杈惧紡
	     Pattern patternNum = Pattern.compile(regexNum); // 鏍煎紡鍖栨瘮杈冭鍒�
	     Matcher isNum = patternNum.matcher(str);
	     return isNum.matches();
	   }
	   
	  
	 
	  public static java.sql.Date toSQLDate(Date date) 
	  {
	    if(date==null) return null;
	    java.sql.Date sqlDate = null;
	    try
	    {
	      sqlDate = new java.sql.Date(date.getTime());
	    }
	    catch(Exception ex)
	    {
	      ;
	    }
	    return sqlDate;
	  }
	  
	
	  public static long getYearsBetween(Date startDate,Date endDate) throws Exception
	  {
	    if(startDate == null || endDate == null) return 0;
	    long years = 0;
	    long passtime = endDate.getTime() - startDate.getTime();
	    years = passtime / (24 * 60 * 60 * 1000)/365;
	    return years;
	  }
	  
	
	  public static double changeDecimal(double value, int scale) throws Exception
	  {
	    if(scale < 0)
	    {
	      throw new IllegalArgumentException("The scale must be a positive integer or zero");
	    }
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);//鍥涜垗浜斿叆澶勭悊
	    double num = bd.doubleValue();
	    return num;
	  }	
	
	
	public static String getIpAddr(HttpServletRequest request) { 
	     String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("Proxy-Client-IP"); 
	     } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("WL-Proxy-Client-IP"); 
	     } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	          ip = request.getRemoteAddr(); 
	      } 
	     return ip; 
	  }


}
