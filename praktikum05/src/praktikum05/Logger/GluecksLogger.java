/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum05.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.*;

/**
 * Logger Klasse für den einarmigen Banditen
 * @author Leon
 */
public class GluecksLogger 
{
	private static Logger lg = null; 
	/**
	 * Privater Konstruktor, damit Singleton Konzept funktioniert
	 */
	private GluecksLogger(){ //Private weil wir nicht wollen, dass jemand einen Logger macht
	}
	/**
	 * Gibt den Logger zurück
	 * @return Logger
	 */
	public static Logger getLogger(){
		if(lg==null){ //Das hier ist das Singleton Konzept
			lg = Logger.getLogger("GluecksLogger");
      initLogger();
		}
		return lg;
	}
	/**
	 * Initialisiert den Logger
	 */
	private static void initLogger(){
    ConsoleHandler ch = new ConsoleHandler();
		//FileHandler fh = new FileHandler();
  lg.setUseParentHandlers(false);
		ch.setFormatter(new GluecksspielFormatter());
		lg.addHandler(ch);
	}
}

/**
 * Formatter Klasse für den Logger
 */
class GluecksspielFormatter extends SimpleFormatter{
	/**
	 * Formatiert den LogRecord in eine Zeile
	 * @param record LogRecord
	 * @return String
	 */
  @Override
	public String format(LogRecord record){
		String logline = "| ";
		LocalDateTime ldt = LocalDateTime.now();
    ldt = ldt.truncatedTo(ChronoUnit.SECONDS);
		logline += ldt.toString();
    logline += " | ";
    logline += record.getLevel();
    logline += " | ";
    logline += record.getSourceClassName();
    logline += " | ";
		logline += record.getMessage() + " |";
		logline += "\n";
		return logline;
	}
}
