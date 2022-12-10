package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaScooter extends Piazzola
{
	private Scooter scooter;

	//---------------------------------------------------------------------------------------------
	
	public PiazzolaScooter(int numeroParcheggio, SiNo occupato, int oraEntrata, int minutoEntrata, Scooter scooter)
	{
		super(numeroParcheggio, occupato, oraEntrata, minutoEntrata);
		this.scooter = scooter;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public Scooter getScooter() 
	{
		return scooter;
	}

	public void setScooter(Scooter scooter) 
	{
		this.scooter = scooter;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toString() 
	{
		return "PiazzolaScooter [numeroParcheggio=" + super.getNumeroParcheggio() + ", occupato=" + super.getOccupato() 
		       + ", Targa=" + scooter.getTarga() + ", oraIngresso=" + super.getOraEntrata() + ":" + super.getMinutoEntrata() + "]";
	}
	
	@Override
	public String toCsvFormat() 
	{
		return super.getNumeroParcheggio() + "," + super.getOccupato() + "," + scooter.getTarga()
										   + "," + super.getOraEntrata() + "," + super.getMinutoEntrata();
		
	}
}
