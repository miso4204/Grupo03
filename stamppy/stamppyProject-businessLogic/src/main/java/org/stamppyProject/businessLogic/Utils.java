package org.stamppyProject.businessLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static Date convertToDate(String stringDate) throws ParseException{	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(stringDate);
		return date;
		
	}

}
