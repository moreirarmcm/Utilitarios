package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

import javax.swing.text.DateFormatter;

import org.apache.tomcat.jni.Local;
import org.springframework.format.Formatter;

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
	
	public static String DataAtual() {
		LocalDate dt = LocalDate.now();		
		return dt.getDayOfMonth() + "/" + dt.getMonthValue() + "/" + dt.getYear();
	}
	/**
	 * Pausa a execução do programa por um tempo definido.
	 * 
	 * @param segundos - tempo de pausa;
	 */
	public static void Pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		}catch (InterruptedException e) {
			System.out.println("N�o foi poss�vel pausar por " + segundos);
		}
	}
	
	/**
	 * Cria uma conexão com banco de dados MySQL.
	 * 
	 * @param bd - nome do banco de dados;
	 * @param login - login de acesso ao banco;
	 * @param senha - senha de acesso ao banco;
	 * 
	 * @return conexão feita.
	 */
	public Connection ConectandoMySQL(String bd, String login, String senha) {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String x = "jdbc:mysql://localhost:3306/" + bd;
			conexao = DriverManager.getConnection(x, login, senha);
			System.out.println("Banco de dados '" + bd+ "' conectado.");
		}catch (ClassNotFoundException e) {
			System.out.println("Não foi possível LOCALIZAR o driver de banco de dados.");
		}catch (Exception e) {
			System.out.println("Não foi possível se conectar ao banco de dados: " + bd);
		}
		return conexao;
	}
}
