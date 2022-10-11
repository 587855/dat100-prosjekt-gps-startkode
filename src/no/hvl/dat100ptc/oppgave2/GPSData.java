package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		gpspoints = new GPSPoint[n]; //- Start på OPPGAVE 2 b)
		antall = 0;
		
		//throw new UnsupportedOperationException(TODO.construtor("GPSData"));

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if (gpspoints.length > antall) {
			gpspoints[antall] = gpspoint;
			this.antall+=1;
			inserted = true;
			}

		return inserted;
		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		//input: gps i stringformat

		// TODO - START
		//kjører metoden med input string og output peker
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		//kjører metoden insertgps på pekeren?
		boolean sattInn = insertGPS(gpspoint);
		
		return sattInn;
		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		//løkke som printer ut toString() per indeks i tabell
		for (int i=0; i<gpspoints.length; i++ ) {
			System.out.println(gpspoints[i].toString());
		}
		

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
