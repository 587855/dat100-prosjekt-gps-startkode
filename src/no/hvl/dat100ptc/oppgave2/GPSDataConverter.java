package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		//fullført 2a)
		
		int secs;
		int hr, min, sec;

		hr = (Integer.parseInt(timestr.substring(11,13)))*3600;
		min = Integer.parseInt(timestr.substring(14,16))*60;
		sec = Integer.parseInt(timestr.substring(17,19));
		
		secs = hr + min + sec;
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		// metodekall: convert("2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9")

		// TODO - START ;
		//les string og gjør om til int,double,double,double
		int time = toSeconds(timeStr);		
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		//lager nytt objekt med konduktør
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		//returnerer peker
		return gpspoint;

		// OPPGAVE - SLUTT ;
	    
	}
	
}
