package utilitario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	static SimpleDateFormat data_formato = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat dinheiro_formato = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")) ); 
	
	public static String DateParaString(Date d) {
		return Util.data_formato.format(d);
	}
	
	public static String doubleParaString (Double d) {
		return Util.dinheiro_formato.format(d);
	}
	
	public static Double StringParaDouble(String s) {
		try {
			return (Double)Util.dinheiro_formato.parse(s);
		}catch(ParseException e) {
			return null;
		}
	}
}
