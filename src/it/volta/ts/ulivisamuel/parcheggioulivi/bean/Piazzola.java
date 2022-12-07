package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public abstract class Piazzola
{
	private int  numeroParcheggio;
	private SiNo occupato;
	
	//---------------------------------------------------------------------------------------------
	
	public Piazzola(int  numeroParcheggio, SiNo occupato)
	{
		this.numeroParcheggio = numeroParcheggio;
		this.occupato = occupato;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int getNumeroParcheggio() 
	{
		return numeroParcheggio;
	}
	
	public SiNo getOccupato() 
	{
		return occupato;
	}
	
	public void setNumeroParcheggio(int numeroParcheggio) 
	{
		this.numeroParcheggio = numeroParcheggio;
	}
	
	public void setOccupato(SiNo occupato)
	{
		this.occupato = occupato;
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public String toString() 
	{
		return "Piazzola [numeroParcheggio=" + numeroParcheggio + ", occupato=" + occupato + "]";
	}
	
	//---------------------------------------------------------------------------------------------
	
	public String toCsvFormat()
	{
		return numeroParcheggio + "," + occupato;
	}
}
