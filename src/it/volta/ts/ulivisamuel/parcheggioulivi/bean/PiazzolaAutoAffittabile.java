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
		String zeriOra    = "";
		String zeriMinuto = "";
		String zeri       = "";
		if(super.getNumeroParcheggio() != 100)
		{
			if(super.getNumeroParcheggio() > 9)
				zeri = "0";
			else
				zeri = "00";
		}
		if(super.getOraEntrata() < 10)
			zeriOra = "0";
		if(super.getMinutoEntrata() < 10)
			zeriMinuto = "0";
		return "[Numero piazzola = " + zeri + super.getNumeroParcheggio() + ", Piazzola occupata = " + super.getOccupato() 
		     + ", Targa auto occupante = " + super.getAuto().getTarga() + ", Ora d'ingresso auto occupante = " + zeriOra 
		     + super.getOraEntrata() + ":" + zeriMinuto + super.getMinutoEntrata() + ", Piazzola affittata = " + affittato + "]";
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public String toCsvFormat()
	{
		return super.toCsvFormat() + "," + affittato;
	}
}
