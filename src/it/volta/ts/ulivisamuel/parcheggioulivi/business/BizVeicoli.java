package it.volta.ts.ulivisamuel.parcheggioulivi.business;

public class BizVeicoli 
{
	public boolean verificaTargaAuto(String targa)
	{
		if(targa.length() != 7)
			return false;
		if((int) targa.charAt(0) < 65 || (int) targa.charAt(0) > 90)
			return false;
		if((int) targa.charAt(1) < 65 || (int) targa.charAt(1) > 90)
			return false;
		if((int) targa.charAt(2) < 48 || (int) targa.charAt(2) > 57)
			return false;
		if((int) targa.charAt(3) < 48 || (int) targa.charAt(3) > 57)
			return false;
		if((int) targa.charAt(4) < 48 || (int) targa.charAt(4) > 57)
			return false;
		if((int) targa.charAt(5) < 65 || (int) targa.charAt(5) > 90)
			return false;
		if((int) targa.charAt(6) < 65 || (int) targa.charAt(6) > 90)
			return false;
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean verificaTargaScooter(String targa)
	{
		if(targa.length() != 7)
			return false;
		if((int) targa.charAt(0) < 65 || (int) targa.charAt(0) > 90)
			return false;
		if((int) targa.charAt(1) < 65 || (int) targa.charAt(1) > 90)
			return false;
		if((int) targa.charAt(2) < 48 || (int) targa.charAt(2) > 57)
			return false;
		if((int) targa.charAt(3) < 48 || (int) targa.charAt(3) > 57)
			return false;
		if((int) targa.charAt(4) < 48 || (int) targa.charAt(4) > 57)
			return false;
		if((int) targa.charAt(5) < 48 || (int) targa.charAt(5) > 57)
			return false;
		if((int) targa.charAt(6) < 48 || (int) targa.charAt(6) > 57)
			return false;
		return true;
	}
}
