package it.uniroma3.project.services.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time24HoursValidator{

	private Pattern pattern;
	private Matcher matcher;
	private  DateFormat formatter;


	// gestione orario di lavolo ristorante
	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
	// orario lavorativo dalle 11:00 alle 22:59
	private static final String ORARIORISTORANTE_PATTERN = "(19|2[01]):[0-5][0-9]";

	public Time24HoursValidator(){
	}

	/**
	 * Convalida dell'orario in formato 24 ore
	 * @param l'orario da convalidare
	 * @return l'ora nel formato 24 ore
	 */
	public Date validate(String time){
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		formatter= new SimpleDateFormat("hh:mm");
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
	public String ConvertDateToString(Date data){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String format = formatter.format(data);
		return format;
	}

	public boolean isCena(String time){
		pattern = Pattern.compile(ORARIORISTORANTE_PATTERN);
		if(time!=null){
			matcher = pattern.matcher(time);
			if (matcher.matches())
				return true;
		}
		return false;
	}

	/**
	 * Confronta la data passata come parametro con quella corrente
	 * @param data
	 * @return true se coincidono, false altrimenti
	 */

	public boolean isToday(Date data){
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		date1.setTime(data);
		date2.setTime(new Date());
		int day1= date1.get(Calendar.DAY_OF_MONTH);
		int month1= date1.get(Calendar.MONTH);
		int day2= date2.get(Calendar.DAY_OF_MONTH);
		int month2= date2.get(Calendar.MONTH);
		return (day1==day2 && month1==month2);
	}

	/**
	 * Confronta tra loro due date
	 * @param data1
	 * @param data2
	 * @return true se data1 e data2 coincidono, false altrimenti
	 */
	public boolean SameDate(Date data1 , Date data2){
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		date1.setTime(data1);
		date2.setTime(data2);
		int day1= date1.get(Calendar.DAY_OF_MONTH);
		int month1= date1.get(Calendar.MONTH);
		int day2= date2.get(Calendar.DAY_OF_MONTH);
		int month2= date2.get(Calendar.MONTH);
		return (day1==day2 && month1==month2);
	}
}