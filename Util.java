package utilitario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Util {
	static SimpleDateFormat data_simples = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static NumberFormat dinheiro_formato = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")) ); 
	static DateTimeFormatter data_formato_localDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static String DateParaString(Date d) {
		return Util.data_simples.format(d);
	}
	
	public static String doubleParaDinheiro (Double d) {
		return Util.dinheiro_formato.format(d);
	}
	
	public static Double StringParaDouble(String s) {
		try {
			return (Double)Util.dinheiro_formato.parse(s);
		}catch(ParseException e) {
			return null;
		}
	}
	
	public static String LocalDateParaString(LocalDate d) {
		return d.format(data_formato_localDate);
	}
	
	public static void Pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		}catch (InterruptedException e) {
			System.out.println("N�o foi poss�vel pausar por " + segundos);
		}
	}	
}
