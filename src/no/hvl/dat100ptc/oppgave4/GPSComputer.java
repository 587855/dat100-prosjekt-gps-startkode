package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		//løkke som starter på 0 og til <lengden-1
		for (int i=0; i< gpspoints.length-1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);			
			
		}
		return distance;



	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		//løkke som starter på 0 og til <lengden-1
		for (int i=0; i< gpspoints.length-1; i++) {
			double temp_1 = gpspoints[i].getElevation();
			double temp_2 = gpspoints[i+1].getElevation();
			if (temp_1 < temp_2) {
				elevation += (temp_2-temp_1);
			}
		}
		return elevation;

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		int time = 0;

//		//løkke som starter på 0 og til <lengden-1
//		for (int i=0; i< gpspoints.length-1; i++) {
//			double temp_1 = gpspoints[i].getTime();
//			double temp_2 = gpspoints[i+1].getTime();
//			if (temp_1 < temp_2) {
//				time += (temp_2-temp_1);
//			}
//		}
		//tid på siste tall i ruten minus tid på første tall i ruten
		time = gpspoints[gpspoints.length-1].getTime() - gpspoints[0].getTime() ;
		
		return time;
	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		//lage en ny og like stor tabell
		double [] fart_tab = new double [gpspoints.length-1];
		
		//løkke igjennom gammel løkke og putte ønsker vedi i ny på samme plass
		for (int i=0; i< gpspoints.length-1; i++) {
			double temp = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			fart_tab[i] = temp;
			//System.out.println("GG speed\t\t" + temp);

		}
		return fart_tab;
	}
	
	public double maxSpeed() {
		
		double maxspeed = GPSUtils.findMax(speeds());
		return maxspeed;
	}

	public double averageSpeed() {

		double average = 0;
		
		double time = totalTime();
		double distance = totalDistance();
		
		average = (distance/time)*3.6; //regne om fra m/s til km/t
		
		return average; //retur i km/t
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO - START
		//met varierer på fart
		//met regnes ut i fra mph

		// TODO - SLUTT
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTTs
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START
		//printer ikke ut de faktiske verdiene enda

		System.out.println("Total time\t:" + GPSUtils.formatTime(totalTime()));
		System.out.println("Total distance\t:  " + String.format("%.2f",totalDistance()/1000) + " km");
		System.out.println("Total elevation\t:  " + totalElevation() + " m");
		System.out.println("Max speed\t:  " + String.format("%.2f",maxSpeed()) + " km/t");
		System.out.println("Average speed\t:  " + String.format("%.2f",averageSpeed()) + " km/t");
		System.out.println("Energy\t\t:  " + " kcal");
		
		// TODO - SLUTT
		System.out.println("==============================================");
		
	}

}
