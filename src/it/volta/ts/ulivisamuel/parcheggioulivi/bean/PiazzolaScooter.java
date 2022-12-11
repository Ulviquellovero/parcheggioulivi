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
		String zeriOra    = "";
		String zeriMinuto = "";
		if(super.getOraEntrata() < 10)
			zeriOra = "0";
		if(super.getMinutoEntrata() < 10)
			zeriMinuto = "0";
		return "[Numero piazzola = " + super.getNumeroParcheggio() + ", Piazzola occupata = " + super.getOccupato() 
		       + ", Targa scooter occupante = " + scooter.getTarga() + ", Ora d'ingresso scooter occupante = " + super.getOraEntrata()
		       + zeriOra + ":" + zeriMinuto + super.getMinutoEntrata() + "]";
	}
	
	@Override
	public String toCsvFormat() 
	{
		return super.getNumeroParcheggio() + "," + super.getOccupato() + "," + scooter.getTarga()
										   + "," + super.getOraEntrata() + "," + super.getMinutoEntrata();
		
	}
}
