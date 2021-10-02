package com.ProjectModule5.Module5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	final String NEW_FORMAT = "dd/MM/yyyy";
	final String OLD_FORMAT = "yyyy/MM/dd";

    static public String getFormattedDate(String date, String oldFormat, String newFormat) {
    	try {
    	SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
    	Date d = sdf.parse(date);
    	sdf.applyPattern(newFormat);
    	String newDateString = sdf.format(d);
    	return newDateString;
    	} catch (Exception x) {
    		return date;
    	}
    }

}
