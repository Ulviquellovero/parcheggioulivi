package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaAutoAffittabile extends PiazzolaAuto
{
	private SiNo affittato;
	
	//---------------------------------------------------------------------------------------------
	
	public PiazzolaAutoAffittabile(int numeroParcheggio, SiNo occupato, int oraEntrata, int minutoEntrata, Auto auto, SiNo affittato) 
	{
		super(numeroParcheggio, occupato, oraEntrata, minutoEntrata, auto);
		this.affittato = affittato;
	}

	//---------------------------------------------------------------------------------------------
	
	public SiNo getAffittato() 
	{
		return affittato;
	}

	public void setAffittato(SiNo affittato) 
	{
		this.affittato = affittato;
	}

	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toString() 
	{
		String zeri = "";
		
		if(super.getNumeroParcheggio() != 100)
		{
			if(super.getNumeroParcheggio() > 9)
				zeri = "0";
			else
				zeri = "00";
		}
		
		return "PiazzolaAutoAffittabile [numeroParcheggio=" + zeri + super.getNumeroParcheggio() + ", occupato=" + super.getOccupato() 
		     + ", Targa=" + super.getAuto().getTarga() + ", oraIngresso=" + super.getOraEntrata() + ":" + super.getMinutoEntrata() 
		     + ", affittato=" + affittato + "]";
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toCsvFormat()
	{
		return super.toCsvFormat() + "," + affittato;
	}
}
