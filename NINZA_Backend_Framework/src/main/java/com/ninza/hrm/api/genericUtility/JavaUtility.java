package com.ninza.hrm.api.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(5000);
		return ranNum;
	}
	
	public String getSystemDataYYYYDDMM() {
		
		Date dateObj = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(dateObj);
		return date;
		}
	public String getRequriedDateYYYYMMDD(int days) {
		//SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}

}
