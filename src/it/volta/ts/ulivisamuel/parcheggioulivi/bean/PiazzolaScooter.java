package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaScooter extends Piazzola
{
	private Scooter scooter;

	//---------------------------------------------------------------------------------------------
	
	public PiazzolaScooter(int numeroParcheggio, SiNo occupato, Scooter scooter)
	{
		super(numeroParcheggio, occupato);
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
		       + ", Targa=" + scooter.getTarga() + "]";
	}
	
	@Override
	public String toCsvFormat() 
	{
		return super.toCsvFormat() + "," + scooter.getTarga();
	}
}
