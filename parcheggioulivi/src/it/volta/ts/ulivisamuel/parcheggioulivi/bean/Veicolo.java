package it.volta.ts.ulivisamuel.parcheggioulivi.bean;

public abstract class Veicolo
{
	private String targa;
	
	//---------------------------------------------------------------------------------------------
	
	public Veicolo(String targa)
	{
		this.targa = targa;
	}
	
	//---------------------------------------------------------------------------------------------

	public String getTarga() 
	{
		return targa;
	}

	public void setTarga(String targa) 
	{
		this.targa = targa;
	}
}
