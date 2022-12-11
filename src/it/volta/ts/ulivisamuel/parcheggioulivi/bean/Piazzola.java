package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public abstract class Piazzola
{
	private int  numeroParcheggio;
	private SiNo occupato;
	private int  oraEntrata;
	private int  minutoEntrata;
	
	//---------------------------------------------------------------------------------------------
	
	public Piazzola(int  numeroParcheggio, SiNo occupato, int oraEntrata, int minutoEntrata)
	{
		this.numeroParcheggio = numeroParcheggio;
		this.occupato         = occupato;
		this.oraEntrata       = oraEntrata;
		this.minutoEntrata    = minutoEntrata;
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
	
	public int getOraEntrata() 
	{
		return oraEntrata;
	}
	
	public int getMinutoEntrata()
	{
		return minutoEntrata;
	}

	
	
	public void setNumeroParcheggio(int numeroParcheggio) 
	{
		this.numeroParcheggio = numeroParcheggio;
	}
	
	public void setOccupato(SiNo occupato)
	{
		this.occupato = occupato;
	}
	
	public void setOraEntrata(int oraEntrata) 
	{
		this.oraEntrata = oraEntrata;
	}
	
	public void setMinutoEntrata(int minutoEntrata) 
	{
		this.minutoEntrata = minutoEntrata;
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public String toString() 
	{
		return "[Numero piazzola = " + numeroParcheggio + ", Piazzola occupata = " + occupato 
		     + ", Ora d'ingresso veicolo occupante = " + oraEntrata + ":" + minutoEntrata + "]";
	}
	
	//---------------------------------------------------------------------------------------------
	
	public String toCsvFormat()
	{
		return numeroParcheggio + "," + occupato + "," + oraEntrata + "," + minutoEntrata;
	}
}
