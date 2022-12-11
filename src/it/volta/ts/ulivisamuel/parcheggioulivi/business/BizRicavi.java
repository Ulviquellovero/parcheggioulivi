package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.time.ZonedDateTime;

public class BizRicavi 
{
	private float ricaviGiorn;
	
	//---------------------------------------------------------------------------------------------
	
	public BizRicavi()
	{
		ricaviGiorn = 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public float getRicaviGiorn()
	{
		return ricaviGiorn;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public float aggiungiRicavi(int ora, int minuto, float pedaggioSing)
	{
		ora            = calcolaOre(ora, minuto);
		float pedaggio = ora * pedaggioSing;
		ricaviGiorn = ricaviGiorn + pedaggio;
		return pedaggio;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int calcolaOre(int ora, int minuto)
	{
		minuto = Math.abs(ZonedDateTime.now().getMinute() - minuto);
		ora    = Math.abs(ZonedDateTime.now().getHour() - ora);
		if(minuto != 0)
			ora = ora + 1;
		return ora;
	}
}
