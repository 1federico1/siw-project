package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time24HoursValidator{

	private Pattern pattern;
	private Matcher matcher;
	private  DateFormat formatter;

	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public Time24HoursValidator(){
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		formatter= new SimpleDateFormat("hh:mm");
	}

	/**
	 * Convalida dell'orario in formato 24 ore
	 * @param l'orario da convalidare
	 * @return true se l'orario � in formato 24 ore, false altrimenti
	 */
	public Date validate(String time){
		Date hour=null;
		if(time!=null){
			matcher = pattern.matcher(time);
			if (matcher.matches())
				try {
					hour= formatter.parse(time);
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		return hour;



	}
}