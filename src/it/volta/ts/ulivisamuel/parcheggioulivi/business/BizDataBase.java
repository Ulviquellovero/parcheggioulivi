package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Auto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAutoAffittabile;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAuto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaScooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Scooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.Motore;
import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.SiNo;

public class BizDataBase
{
	public List<PiazzolaAutoAffittabile> listaPiazzoleAffittabili(boolean soloLibere)
	{
		BufferedReader                reader = null;
		String                        riga   = "";
		List<PiazzolaAutoAffittabile> mess   = new ArrayList<PiazzolaAutoAffittabile>();
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoA.csv"));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(soloLibere)
				{
					if(!campi[1].equals("SI"))
						aggiungiPiazzolaAffittabile(campi, mess);
				}
				else
				{
					aggiungiPiazzolaAffittabile(campi, mess);
				}
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFile(reader);
		}
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void aggiungiPiazzolaAffittabile(String[] campi, List<PiazzolaAutoAffittabile> mess)
	{
		PiazzolaAutoAffittabile piazzola = new PiazzolaAutoAffittabile(0, null, null, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		piazzola.setAffittato(SiNo.valueOf(campi[3]));
		mess.add(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<PiazzolaScooter> listaPiazzoleScooter(boolean soloLibere)
	{
		BufferedReader        reader = null;
		String                riga   = "";
		List<PiazzolaScooter> mess   = new ArrayList<PiazzolaScooter>();
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoAScooter.csv"));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(soloLibere)
				{
					if(!campi[1].equals("SI"))
						aggiungiPiazzolaScooter(campi, mess);
				}
				else
				{
					aggiungiPiazzolaScooter(campi, mess);
				}
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFile(reader);
		}
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void aggiungiPiazzolaScooter(String[] campi, List<PiazzolaScooter> mess)
	{
		PiazzolaScooter     piazzola = new PiazzolaScooter(0, null, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setScooter(new Scooter(campi[2]));
		mess.add(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<PiazzolaAuto> listaPiazzoleRicarica(boolean soloLibere)
	{
		BufferedReader     reader = null;
		String             riga   = "";
		List<PiazzolaAuto> mess = new ArrayList<PiazzolaAuto>();
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoBRicarica.csv"));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(soloLibere)
				{
					if(!campi[1].equals("SI"))
						aggiungiPiazzolaRicarica(campi, mess);
				}
				else
				{
					aggiungiPiazzolaRicarica(campi, mess);
				}
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFile(reader);
		}
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void aggiungiPiazzolaRicarica(String[] campi, List<PiazzolaAuto> mess)
	{
		PiazzolaAuto piazzola = new PiazzolaAuto(0, null, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		mess.add(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<PiazzolaAuto> listaPiazzoleOrdinarie(boolean pianoB, boolean soloLibere)
	{
		BufferedReader     reader = null;
		String             riga   = "";
		List<PiazzolaAuto> mess   = new ArrayList<PiazzolaAuto>();
		try
		{
			if(pianoB)
				reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoB.csv"));
			else
				reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoC.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(soloLibere)
				{
					if(!campi[1].equals("SI"))
						aggiungiPiazzolaOrdinaria(campi, mess);
				}
				else
				{
					aggiungiPiazzolaOrdinaria(campi, mess);
				}
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFile(reader);
		}
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void aggiungiPiazzolaOrdinaria(String[] campi, List<PiazzolaAuto> mess)
	{
		PiazzolaAuto piazzola = new PiazzolaAuto(0, null, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		mess.add(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void chiudiFile(BufferedReader reader)
	{
		try 
		{
			reader.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
	    }
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*public List<String[]> listaPianoPiazzoleLibere(String percorso)
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		try
		{
			reader = new BufferedReader(new FileReader(percorso));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[1].equals("NO") || campi[1].equals("Occupato"))
					mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
		    }
		}
		return mess;
	}*/
	
	//---------------------------------------------------------------------------------------------
	
	/*public List<String[]> listaPianoPiazzoleAffittabili()
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoA.csv"));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[5].equals("NO") || campi[1].equals("Affittato"))
					mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
		    }
		}
		return mess;
	}*/
}