package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaAuto extends Piazzola
{
	private Auto auto;

	//---------------------------------------------------------------------------------------------
	
	public PiazzolaAuto(int numeroParcheggio, SiNo occupato, int oraEntrata, int minutoEntrata, Auto auto) 
	{
		super(numeroParcheggio, occupato, oraEntrata, minutoEntrata);
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
		String zeriOra    = "";
		String zeriMinuto = "";
		if(super.getOraEntrata() < 10)
			zeriOra = "0";
		if(super.getMinutoEntrata() < 10)
			zeriMinuto = "0";
		return "[Numero piazzola = " + super.getNumeroParcheggio() + ", Piazzola occupata = " + super.getOccupato() 
		     + ", Targa auto occupante = " + auto.getTarga() + ", Ora d'ingresso auto occupante = " + zeriOra 
			 + super.getOraEntrata() + ":" + zeriMinuto + super.getMinutoEntrata() + "]";
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toCsvFormat()
	{
		return super.getNumeroParcheggio() + "," + super.getOccupato() + "," + auto.getTarga() 
		                                   + "," + super.getOraEntrata() + "," + super.getMinutoEntrata();
	}
}
