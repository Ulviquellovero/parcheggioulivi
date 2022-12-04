package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class PiazzolaAutoAffittabile extends PiazzolaAuto
{
	private SiNo affittato;
	
	//---------------------------------------------------------------------------------------------
	
	public PiazzolaAutoAffittabile(int numeroParcheggio, SiNo occupato, Auto auto, SiNo affittato) 
	{
		super(numeroParcheggio, occupato, auto);
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
		return "PiazzolaAutoAffittabile [numeroParcheggio=00" + super.getNumeroParcheggio() + ", occupato=" + super.getOccupato() 
		       + ", Targa=" + super.getAuto().getTarga() + ", affittato=" + affittato + "]";
	}
}
