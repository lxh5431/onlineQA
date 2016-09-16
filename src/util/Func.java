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
	 * 鏍煎紡鍖栨牱寮�
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
	 * 灏嗘棩鏈熸牸寮忓寲涓簓yyy-MM-dd鏍煎紡鐨勫瓧绗︿覆
	 * @param date 鏃ユ湡
	 * @return yyyy-MM-dd鏍煎紡鐨勫瓧绗︿覆
	 */
	public static String formatString(Date date){
		String datestr = null;
		datestr = formatDate.format(date);
		return datestr;
	}
	
	/**
	   * 鑾峰彇褰撳墠鏃ユ湡
	   * @param format 鏍煎紡鍖栨ā鏉�
	   * @return 鏍煎紡鍖栦箣鍚庣殑鏃ユ湡瀛楃涓�
	   */
	  public static String getCurrDate(String format)
	  {
	    SimpleDateFormat sdfDate = new SimpleDateFormat(format);
	    return sdfDate.format(Calendar.getInstance().getTime());
	  }
	  
	  /**
	   * 鑾峰彇褰撳墠鏃ユ湡
	   * @return 褰撳墠鏃ユ湡瀛楃涓�
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
	   * 濡傛灉浼犲叆鐨勫瓧绗︿覆鍙傛暟涓簄ull鎴栬��""锛岄偅涔堣繑鍥�" "锛屽惁鍒欒繑鍥炰紶鍏ョ殑瀛楃涓�
	   * @param s 浼犲叆鐨勫瓧绗︿覆
	   * @return 澶勭悊鍚庡瓧绗︿覆
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
	   * 濡傛灉浼犲叆鐨勫瓧绗︿覆鍙傛暟涓簄ull锛岄偅涔堣繑鍥�""锛屽惁鍒欒繑鍥炰紶鍏ョ殑瀛楃涓�
	   * @param o 浼犲叆鐨勫瓧绗︿覆瀵硅薄
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
	    * 灏嗘暣鏁版暟缁勮В鏋愭垚[ a,b ]杩斿洖锛岃嫢鏁扮粍鐨勯暱搴︿负0锛岄偅涔堣繑鍥�""
	    * @param a
	    * @return
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
	   
	   /**
	    * 鑾峰彇鍥哄畾闀垮害鐨勮嚜澧為暱搴忓彿
	    * @param curr 褰撳墠宸蹭娇鐢ㄧ殑搴忓彿鏁板��
	    * @param digit 闀垮害
	    * @return 鑷闀垮簭鍙�
	    * @throws Exception
	    */
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
	    * 鍒ゆ柇鏃ユ湡鍚堟硶鎬�
	    * @param dateStr 鏃ユ湡瀛楃涓� 8浣嶆暟瀛�(yyyyMMdd)
	    * @return 濡傛灉鏄纭殑鏃ユ湡杩斿洖true锛屽惁鍒欒繑鍥瀎alse
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
	   
	   /**
	    * 璁＄畻瀛楃涓查暱搴� 涓�涓腑鏂囧瓧绗︾殑闀垮害涓�2
	    * @param str 瀛楃涓�
	    * @return 瀛楃涓查暱搴�
	    * @throws Exception
	    */
	   public static int getStringLength(String str) throws Exception
	   {
	     String s = getString(str);
	     int length = 0;
	     length = s.getBytes("GBK").length;
	     return length;
	   }
	   
	   /**
	    * 瀛楃涓叉槸鍚︽槸鍥哄畾闀垮害鐨勬暟瀛�
	    * @param str 瀛楃涓�
	    * @param length 闀垮害
	    * @return 濡傛灉鏄繑鍥瀟rue 鍚﹀垯杩斿洖false
	    * @throws Exception
	    */
	   public static boolean isFixLengthNum(String str,int length) throws Exception
	   {
	     String regexNum = "\\d{"+length+"}"; // 姣旇緝鐢ㄦ鍒欒〃杈惧紡
	     Pattern patternNum = Pattern.compile(regexNum); // 鏍煎紡鍖栨瘮杈冭鍒�
	     Matcher isNum = patternNum.matcher(str);
	     return isNum.matches();
	   }
	   
	  
	  /**
	   * 灏唈ava.util.date杞崲涓簀ava.sql.date
	   * @param date java.util.date
	   * @return 杞崲鍚庣殑java.sql.date
	   */
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
	  
	  /**
	   * 璁＄畻2涓棩鏈熶箣闂撮棿闅旂殑骞存暟
	   * @param startDate 鏃ユ湡1
	   * @param endDate 鏃ユ湡2
	   * @return 闂撮殧鐨勫勾鏁�
	   * @throws Exception
	   */
	  public static long getYearsBetween(Date startDate,Date endDate) throws Exception
	  {
	    if(startDate == null || endDate == null) return 0;
	    long years = 0;
	    long passtime = endDate.getTime() - startDate.getTime();
	    years = passtime / (24 * 60 * 60 * 1000)/365;
	    return years;
	  }
	  
	  /**
	   * 淇濈暀灏忔暟
	   * @param value 鏁板��
	   * @param scale 灏忔暟浣嶆暟
	   * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉鍊�
	   * @throws Exception
	   */
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
	
	/**
	 * 鑾峰彇鐢ㄦ埛鐪熷疄IP
	 * @param request
	 * @return
	 */
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
