package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.Motore;

public class Auto extends Veicolo
{
	private Motore motore;
	
	//---------------------------------------------------------------------------------------------
	
	public Auto(String targa, Motore motore) 
	{
		super(targa);
		this.setMotore(motore);
	}
	
	//---------------------------------------------------------------------------------------------

	public Motore getMotore() 
	{
		return motore;
	}

	public void setMotore(Motore motore) 
	{
		this.motore = motore;
	}	
}
