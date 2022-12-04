package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaAuto extends Piazzola
{
	private Auto auto;

	//---------------------------------------------------------------------------------------------
	
	public PiazzolaAuto(int numeroParcheggio, SiNo occupato, Auto auto) 
	{
		super(numeroParcheggio, occupato);
		this.auto = auto;
	}
	
	//---------------------------------------------------------------------------------------------
	public Auto getAuto() 
	{
		return auto;
	}
	
	public void setAuto(Auto auto) 
	{
		this.auto = auto;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toString() 
	{
		return "PiazzolaAuto [numeroParcheggio=" + super.getNumeroParcheggio() + ", occupato=" + super.getOccupato() 
		       + ", Targa=" + auto.getTarga() + "]";
	}
}
