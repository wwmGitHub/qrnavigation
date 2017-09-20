package com.jy.qrcodemake.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GlobalFunc {
	private static String configfile = "Config";
	private static String endline = "------�ָ���------";
	/**
	 * 获取文件扩展名 
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	} 
	/**
	 * 获取不带扩展名的文件名
	 * @param filename
	 * @return
	 */
	public static String getFileNameNoEx(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()))) {   
                return filename.substring(0, dot);   
            }   
        }   
        return filename;   
    } 
	
	public static List<String> getStringBetween(List<String> rList,String str,String begin_str,String end_str){
		int index1 = -1,index2=-1;
		while((index1=str.indexOf(begin_str))>=0){
			str = str.substring(index1+1);
			while((index2=str.indexOf(end_str))>=0){
				rList.add(str.substring(0,index2));
				return getStringBetween(rList,str.substring(index2),begin_str,end_str);
			}
		}
		return rList;
	}

	public static long datetime2long(String datetime) {
		if (datetime.indexOf(':') < 0)
			datetime = datetime + " 00:00:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = format.parse(datetime);
			return date.getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	public static String toEngNumber(String number) {
		if (!number.isEmpty()) {
			StringBuffer sb = new StringBuffer(number); // 创建一个变量存储字符串num
			for (int i = sb.length() - 3; i > 0; i = i - 3) {
				sb.insert(i, ",");
				sb.insert(1, "**"); // 插入字符串
			}
			return sb.toString();
		} else
			return number;
	}

	public static int celling(int a, int b) {
		try {
			int c = a / b;
			if (a != b * c)
				++c;
			return c;
		} catch (Exception e) {
		}
		return 0;
	}

	public static String nullToStr(String s) {
		if ((s == null) || (s.trim().length() < 0))
			return "";

		return s;
	}

	public static String replace(String source, char str1, String str2) {
		return replace(source, String.valueOf(str1), str2);
	}

	public static String replace(String source, String str1, String str2) {
		if (source == null)
			return "";
		String desc = "";
		int posstart = 0;
		int posend = source.indexOf(str1, 0);
		int len = source.length();
		while ((posend >= 0) && (posstart < len)) {
			desc = desc + source.substring(posstart, posend) + str2;
			posstart = posend + str1.length();
			posend = source.indexOf(str1, posstart);
		}
		if (posstart < len)
			desc = desc + source.substring(posstart, len);
		return desc;
	}

	public static String encodeGB(String source, String charset) {
		if (source == null)
			return "";
		try {
			return new String(source.getBytes("GBK"));
		} catch (Exception e) {
		}
		return source;
	}

	public static String replaceAllWord(String source, String str1, String str2) {
		if (source == null)
			return "";
		String desc = "";
		String tmp_source = source.toUpperCase();
		String tmp_str1 = str1.toUpperCase();
		int posstart = 0;
		int posend = tmp_source.indexOf(tmp_str1, 0);
		int len = source.length();
		String tmp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
		while ((posend >= 0) && (posstart < len)) {
			String before_str = source.substring(posend - 1, posend);
			String after_str = source.substring(posend + str1.length(), posend
					+ str1.length() + 1);

			if (("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_".indexOf(before_str
					.toUpperCase()) > -1)
					|| ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_"
							.indexOf(after_str.toUpperCase()) > -1))
				desc = desc
						+ source.substring(posstart, posend + str1.length());
			else
				desc = desc + source.substring(posstart, posend) + str2;
			posstart = posend + str1.length();
			posend = tmp_source.indexOf(tmp_str1, posstart);
		}
		if (posstart < len)
			desc = desc + source.substring(posstart, len);
		return desc;
	}

	public static String replaceAll(String str) {
		str = replace(str, "%0A", "");
		str = replace(str, "%0D", "");
		str = replace(str, "'", "\\'");
		str = replace(str, "\"", "\\\"");
		str = replace(str, "\\r\\n", "");
		str = replace(str, "\\n", "");
		str = replace(str, "/script", "\\/script");
		str = replace(str, "/SCRIPT", "\\/SCRIPT");
		return str;
	}

	public static String toSqlStr(String source) {
		if (source == null || source.equals(""))
			return " ";
		return replace(source, '\'', "''");
	}

	public static String formateDate(String date) {
		if (date == null || date.equals(""))
			return "";
		return date.substring(0, 10);
	}

	public static String toUtf8(String str) {
		if (str.equals(""))
			return "";
		else {
			byte[] bytes = str.getBytes();
			String result;
			try {
				result = new String(bytes, "utf-8");
				return result;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	public static int parseInt(String s) {
		try {
			if (s == null || s.equals(""))
				return 0;

			return Integer.parseInt(s.trim());
		} catch (Exception e) {
		}
		return 0;
	}

	public static double parseDouble(Object s) {
		try {
			if (s == null)
				return 0.0D;

			return Double.parseDouble(((String) s).trim());
		} catch (Exception e) {
		}
		return 0.0D;
	}

	public static double parseDouble(int i) {
		return parseDouble(String.valueOf(i));
	}

	public static double parseDouble(long i) {
		return parseDouble(String.valueOf(i));
	}

	public static String doubleToStr(double f) {
		return String.valueOf(parseDouble(Math.round(f * 100.0D)) / 100.0D);
	}

	public static int parseInt(Object s) {
		return parseInt(s, 0);
	}

	public static int parseInt(Object s, int def) {
		try {
			if (s == null)
				return def;

			return Integer.parseInt((s.toString()).trim());
		} catch (Exception e) {

		}
		return def;
	}

	public static float parseFloat(Object s) {
		try {
			if ((s == null) || (s.equals("")))
				return Float.parseFloat("0");

			return Float.parseFloat(s.toString().trim());
		} catch (Exception e) {
		}
		return Float.parseFloat("0");
	}

	public static String toString(Object s) {
		try {
			if (s == null)
				return "";

			// return String.valueOf(s).replace("null", "");'
			// //��ʹ�ø÷���.��?�еľ��д���
			return String.valueOf(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static Calendar getCal(String s) {
		Calendar cal = Calendar.getInstance();
		cal.set(getYear(s), getMonth(s) - 1, getDay(s), getHour(s),
				getMinute(s), getSecond(s));
		return cal;
	}

	public static int getHour(String s) {
		try {
			return Integer.parseInt(s.substring(11, 13));
		} catch (Exception e) {
		}
		return 0;
	}

	public static int getMinute(String s) {
		try {
			return Integer.parseInt(s.substring(14, 16));
		} catch (Exception e) {
		}
		return 0;
	}

	public static int getSecond(String s) {
		try {
			return Integer.parseInt(s.substring(17, 19));
		} catch (Exception e) {
		}
		return 0;
	}

	public static long getTime(Object time) {
		return getCal(toString(time)).getTime().getTime();
	}

	public static String getYear(Calendar cal) {
		return String.valueOf(cal.get(1));
	}

	public static boolean isNullStr(String s) {
		return ((s == null) || (s.trim().length() <= 0));
	}

	public static String strLen(String s, int len) {
		if (isNullStr(s))
			s = "";
		for (int i = 0; i < len - s.length(); ++i) {
			s = "0" + s;
		}
		return s;
	}

	public static String getMonth(Calendar cal) {
		return strLen(String.valueOf(cal.get(2) + 1), 2);
	}

	public static String getDay(Calendar cal) {
		return strLen(String.valueOf(cal.get(5)), 2);
	}

	public static String getHour(Calendar cal) {
		return strLen(String.valueOf(cal.get(11)), 2);
	}

	public static String getMinute(Calendar cal) {
		return strLen(String.valueOf(cal.get(12)), 2);
	}

	public static String getSecond(Calendar cal) {
		return strLen(String.valueOf(cal.get(13)), 2);
	}

	public static String getDateStr(Calendar cal) {
		return getYear(cal) + "/" + getMonth(cal) + "/" + getDay(cal);
	}

	public static String getDateStr(String date) {
		if (getDateStr(getCal(date)).equals("1970/01/01"))
			return "";
		if (getDateStr(getCal(date)).equals("1900/01/01"))
			return "";
		return getDateStr(getCal(date));
	}

	public static String getTimeStr(Calendar cal) {
		return getHour(cal) + ":" + getMinute(cal) + ":" + getSecond(cal);
	}

	public static String getTimeStr(String date) {
		return getTimeStr(getCal(date));
	}

	public static String getDate(Calendar cal) {
		return getDateStr(cal) + " " + getTimeStr(cal);
	}

	public static String getDate(Date dat) {
		if (dat == null)
			return "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(dat);
		return getDateStr(cal) + " " + getTimeStr(cal);
	}

	/**
	 * @see ��ȡ��� params string, ����int����
	 */
	public static int getYear(String s) {
		try {
			return Integer.parseInt(s.substring(0, 4));
		} catch (Exception e) {
		}
		return 1970;
	}

	/**
	 * @see ��ȡ�·� params string, ����int����
	 */
	public static int getMonth(String s) {
		try {
			return Integer.parseInt(s.substring(5, 7));
		} catch (Exception e) {
		}
		return 1;
	}

	/**
	 * @see ��ȡ���� params string ����int����
	 */
	public static int getDay(String s) {
		try {
			return Integer.parseInt(s.substring(8, 10));
		} catch (Exception e) {
		}
		return 1;
	}

	public static String getYearMonth(String s) {
		try {
			return s.substring(0, 7);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * @see ��ʾ�ĸ�ʽ�� 1900/01/01 00:00:00
	 */
	public static String getNow() {
		Calendar now = Calendar.getInstance();
		return getDateStr(now) + " " + getTimeStr(now);
	}

	/**
	 * @see ��ʾ�ĸ�ʽ�� 1900/01/01
	 */
	public static String getNowDate() {
		Calendar now = Calendar.getInstance();
		return getDateStr(now);
	}

	public static String getNowTime() {
		Calendar now = Calendar.getInstance();
		return getTimeStr(now);
	}

	public static String getThisWeek() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getThisWeekend() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 8);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	static String getThisWeek(String date) {
		Calendar now = getCal(date);
		now.set(5, now.get(5) - now.get(7) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextWeek() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 1 + 7);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextWeek(String date) {
		Calendar now = getCal(date);
		now.set(5, now.get(5) - now.get(7) + 1 + 7);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextMonth() {
		Calendar now = Calendar.getInstance();
		now.set(2, now.get(2) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextMonth(String date) {
		Calendar now = getCal(date);
		now.set(2, now.get(2) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getChnDate(String computerDate) {
		String out = String.valueOf(getYear(computerDate)) + "��"
				+ String.valueOf(getMonth(computerDate)) + "��"
				+ String.valueOf(getDay(computerDate)) + "��";
		return out;
	}

	public static String getMonthLastDay(Calendar cal) {
		cal.add(cal.MONTH, 1);
		cal.set(cal.DATE, 1);
		cal.add(cal.DATE, -1);
		return getDateStr(cal);
	}

	public static String getMonthFristDay(Calendar cal) {
		cal.set(cal.DATE, 1);
		return getDateStr(cal);
	}

	public static String getYearAndMonth(String dateStr) {
		if (dateStr == null)
			return "";
		return dateStr.replace("��", "/").replace("��", "");
	}

	/** ��ȡ��һ���� */
	public static String getLastMonth(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ȡ����һ����ʱ��
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth;
	}

	/** ��ȡ��һ���� */
	public static String getFirstMonth(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ȡ����һ����ʱ��
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth;
	}

	/** ��ȡ��һ���� */
	public static String getNextMonthFormat(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ȡ����һ����ʱ��
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth;
	}

	// ��ȡ�ϴ��ļ�������
	public static String getFileName(String filePathName) {
		int pos = 0;
		pos = filePathName.lastIndexOf(47);
		if (pos != -1)
			return filePathName.substring(pos + 1, filePathName.length());
		pos = filePathName.lastIndexOf(92);
		if (pos != -1)
			return filePathName.substring(pos + 1, filePathName.length());

		return filePathName;
	}

	// �����ɽ�汾 �ӵ�
	public static String getChinaDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());

		return date;
	}

	// ��ǰ���ڼӼ���������
	public static String getAfterDate(Integer days) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date d = c.getTime();
		String afterDates = new SimpleDateFormat("yyyy-MM-dd").format(d);

		return afterDates;
	}

	/**
	 * ��ȡȫ�������ڣ��磺2014-10-23 ��ȡΪ�� ����һ����ʮ�¶�ʮ���գ�
	 * 
	 * @param date
	 *            ָ������
	 * @return ���ڵ�ȫ���ĸ�ʽ
	 */
	public static String getChineseDate(Date date) {
		StringBuffer sbDate = new StringBuffer();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		String[] dateArray = dateStr.split("-");
		String year = dateArray[0];
		for (int i = 0; i < year.length(); i++) {
			char n = year.charAt(i);
			switch (n) {
			case '0':
				sbDate.append("��");
				break;
			case '1':
				sbDate.append("һ");
				break;
			case '2':
				sbDate.append("��");
				break;
			case '3':
				sbDate.append("��");
				break;
			case '4':
				sbDate.append("��");
				break;
			case '5':
				sbDate.append("��");
				break;
			case '6':
				sbDate.append("��");
				break;
			case '7':
				sbDate.append("��");
				break;
			case '8':
				sbDate.append("��");
				break;
			case '9':
				sbDate.append("��");
				break;
			}
		}
		sbDate.append("��");
		String month = dateArray[1];
		for (int i = 0; i < month.length(); i++) {
			char n = month.charAt(i);
			if (i == 0 && n == '0') {

			} else if (i == 0 && n == '1') {
				sbDate.append("ʮ");
			} else if (i == 0) {
				switch (n) {
				case '2':
					sbDate.append("��ʮ");
					break;
				case '3':
					sbDate.append("��ʮ");
					break;
				case '4':
					sbDate.append("��ʮ");
					break;
				case '5':
					sbDate.append("��ʮ");
					break;
				case '6':
					sbDate.append("��ʮ");
					break;
				case '7':
					sbDate.append("��ʮ");
					break;
				case '8':
					sbDate.append("��ʮ");
					break;
				case '9':
					sbDate.append("��ʮ");
					break;
				}
			}
			if (i == 1 && n == '0') {

			} else if (i == 1) {
				switch (n) {
				case '1':
					sbDate.append("һ");
					break;
				case '2':
					sbDate.append("��");
					break;
				case '3':
					sbDate.append("��");
					break;
				case '4':
					sbDate.append("��");
					break;
				case '5':
					sbDate.append("��");
					break;
				case '6':
					sbDate.append("��");
					break;
				case '7':
					sbDate.append("��");
					break;
				case '8':
					sbDate.append("��");
					break;
				case '9':
					sbDate.append("��");
					break;
				}
			}
		}
		sbDate.append("��");
		String dates = dateArray[2];
		for (int i = 0; i < dates.length(); i++) {
			char n = dates.charAt(i);
			if (i == 0 && n == '0') {

			} else if (i == 0 && n == '1') {
				sbDate.append("ʮ");
			} else if (i == 0) {
				switch (n) {
				case '2':
					sbDate.append("��ʮ");
					break;
				case '3':
					sbDate.append("��ʮ");
					break;
				case '4':
					sbDate.append("��ʮ");
					break;
				case '5':
					sbDate.append("��ʮ");
					break;
				case '6':
					sbDate.append("��ʮ");
					break;
				case '7':
					sbDate.append("��ʮ");
					break;
				case '8':
					sbDate.append("��ʮ");
					break;
				case '9':
					sbDate.append("��ʮ");
					break;
				}
			}
			if (i == 1 && n == '0') {

			} else if (i == 1) {
				switch (n) {
				case '1':
					sbDate.append("һ");
					break;
				case '2':
					sbDate.append("��");
					break;
				case '3':
					sbDate.append("��");
					break;
				case '4':
					sbDate.append("��");
					break;
				case '5':
					sbDate.append("��");
					break;
				case '6':
					sbDate.append("��");
					break;
				case '7':
					sbDate.append("��");
					break;
				case '8':
					sbDate.append("��");
					break;
				case '9':
					sbDate.append("��");
					break;
				}
			}
		}
		sbDate.append("��");
		return sbDate.toString();

		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 * String date1 = dateFormat.format(date); String finalDate = "";
		 * for(int i =0;i<4;i++){ switch(date1.charAt(i)){ case
		 * '0':finalDate+="��";break; case '1':finalDate+="һ";break; case
		 * '2':finalDate+="��";break; case '3':finalDate+="��";break; case
		 * '4':finalDate+="��";break; case '5':finalDate+="��";break; case
		 * '6':finalDate+="��";break; case '7':finalDate+="��";break; case
		 * '8':finalDate+="��";break; case '9':finalDate+="��";break; } }
		 * finalDate+="��"; if(date1.charAt(5)=='1'){ finalDate+="ʮ"; }
		 * if(date1.charAt(6)!='0'){ switch(date1.charAt(6)){ case
		 * '1':finalDate+="һ��";break; case '2':finalDate+="����";break; case
		 * '3':finalDate+="����";break; case '4':finalDate+="����";break; case
		 * '5':finalDate+="����";break; case '6':finalDate+="����";break; case
		 * '7':finalDate+="����";break; case '8':finalDate+="����";break; case
		 * '9':finalDate+="����";break; } } if(date1.charAt(8)=='1'){
		 * finalDate+="ʮ��"; }else if(date1.charAt(8)=='2'){ finalDate+="��ʮ��";
		 * }else if(date1.charAt(8)=='3'){ finalDate+="��ʮ��"; }
		 * switch(date1.charAt(9)){ case '1':finalDate+="һ��";break; case
		 * '2':finalDate+="����";break; case '3':finalDate+="����";break; case
		 * '4':finalDate+="����";break; case '5':finalDate+="����";break; case
		 * '6':finalDate+="����";break; case '7':finalDate+="����";break; case
		 * '8':finalDate+="����";break; case '9':finalDate+="����";break; }
		 * 
		 * return finalDate;
		 */
	}

	/**
	 * ��ʾ�ϸ�������
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getLastDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr.substring(0, 8)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ȡ����һ����ʱ��
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth + "-" + dateStr.substring(8, 10);
	}

	/**
	 * �������ĳ������ڼ�������
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String getAgeByBirthDay(String strDate) throws ParseException {
		String age = "0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		date = sdf.parse(strDate);
		// ʹ��calendar���м���
		Calendar calendar = Calendar.getInstance();
		// ��ȡ��ǰʱ�����ֵ
		long now = (new Date()).getTime();
		long Birthdate = date.getTime();
		long time = now - Birthdate;
		int count = 0;
		// ʱ�任��
		long days = time / 1000 / 60 / 60 / 24;
		// �ж�����
		int birthYear = Integer.parseInt((strDate.substring(0, 4)));
		for (int i = calendar.get(Calendar.YEAR); i >= birthYear; i--) {
			if ((i % 4 == 0 && !(i % 100 == 0)) || (i % 400 == 0)) {
				count++;
			}
			// �����������ؽ������?��
			age = (((int) days - count) / 365) + "";
		}
		return age;
	}

	/**
	 * �õ�������ʱ��
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static String getDateAfter(Date d, int day) {

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		Date after = now.getTime();
		String afterDates = new SimpleDateFormat("yyyy-MM-dd").format(after);

		return afterDates;
	}

	/**
	 * d1是需要比较的日期，d2为当前日期
	 * 
	 * @param d1
	 * @param d2
	 * @param exipreDays
	 * @return
	 */
	public static boolean isExpire(Date d1, Date d2, long exipreDays) {
		if (d1 == null)
			return false;
		long l = d2.getTime() - d1.getTime();
		if (l > 0) {
			return true;
		} else {
			long day = Math.abs(l) / (24 * 60 * 60 * 1000);
			if (day <= exipreDays)
				return true;
			else
				return false;
		}
	}
	
	
	public static String province2code(String name){
		switch(name.trim()){
		case "北京":
			return "110000";
		case "天津":
			return "120000";
		case "河北":
			return "130000";
		case "山西":
			return "140000";
		case "太原":
			return "140000";
		case "内蒙古":
			return "150000";
		case "呼和浩特":
			return "150000";
		case "辽宁":
			return "210000";
		case "沈阳":
			return "210000";
		case "吉林":
			return "220000";
		case "长春":
			return "220000";
		case "黑龙江":
			return "230000";
		case "哈尔滨":
			return "230000";
		case "上海":
			return "310000";
		case "江苏":
			return "320000";
		case "南京":
			return "320000";
		case "浙江":
			return "330000";
		case "杭州":
			return "330000";
		case "安徽":
			return "340000";
		case "合肥":
			return "340000";
		case "福建":
			return "350000";
		case "福州":
			return "350000";
		case "江西":
			return "360000";
		case "南昌":
			return "360000";
		case "河南":
			return "410000";
		case "郑州":
			return "410000";
		case "湖北":
			return "420000";
		case "武汉":
			return "420000";
		case "湖南":
			return "430000";
		case "长沙":
			return "430000";
		case "广东":
			return "440000";
		case "广州":
			return "440000";
		case "广西":
			return "450000";
		case "海南":
			return "460000";
		case "海口":
			return "460000";
		case "四川":
			return "510000";
		case "成都":
			return "510000";
		case "贵州":
			return "520000";
		case "贵阳":
			return "520000";
		case "云南":
			return "530000";
		case "昆明":
			return "530000";
		case "西藏":
			return "540000";
		case "陕西":
			return "610000";
		case "西安":
			return "610000";
		case "甘肃":
			return "620000";
		case "兰州":
			return "620000";
		case "青海":
			return "630000";
		case "西宁":
			return "630000";
		case "宁夏":
			return "640000";
		case "银川":
			return "640000";
		case "新疆":
			return "650000";
		case "乌鲁木齐":
			return "650000";
		case "台湾":
			return "710000";
		case "香港":
			return "810000";
		case "澳门":
			return "820000";
		default:
			return "";
		}
	}
}