package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) { // Samme som findMax, bare at vi skal finne den minste

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		
		//throw new UnsupportedOperationException(TODO.method());
		}
		return min;
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) { //Oppgave 3 b)

		// TODO - START
		double [] latitudes = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length; i++) {
			
			latitudes[i] = gpspoints[i].getLatitude();
			
		}
		return latitudes;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double [] longitudes = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length; i++) {
			
			longitudes[i] = gpspoints[i].getLongitude();
			
		}
		return longitudes;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		Double latDistance = toRadians(latitude1-latitude2);
		Double lonDistance = toRadians(longitude2-longitude1);
		
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
		Math.cos(toRadians(latitude1)) * Math.cos(toRadians(latitude2)) * 
		Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		d = R * c;
		
		return d;
		 
		//throw new UnsupportedOperationException(TODO.method());
		

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		double time1 = gpspoint1.getTime();
		double time2 = gpspoint2.getTime();

		double hr = (time2-time1)/3600;
		double km = distance(gpspoint1, gpspoint2)/1000;
		speed = km/hr;
		
		return speed;
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - SLUTT
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		
		int hh = secs / 3600;
		int mm = (secs % 3600) / 60;
		int ss = secs % 60;

		timestr = String.format("  %02d:%02d:%02d", hh, mm, ss);
		
		return timestr;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		// TODO - START
		double round = Math.round(d*100.0)/100.0;
		str = "" + round;
		int count = str.length();
		String spaces = "";
		while (count < TEXTWIDTH) {
			spaces += " ";
			count ++;
		}
		return spaces + str;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
