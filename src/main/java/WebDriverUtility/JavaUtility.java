package WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
				
	}
	
	public String getSystemDateyyyyMMdd(){
		
		Date dateObj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
		
	}

	public String getTodayDayOfMonth() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		return sdf.format(dateObj);
	}


	public String getRequiredDateyyyyMMdd(int days) {
			
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateObj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}

}
