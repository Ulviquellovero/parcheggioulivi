package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
			chiudiFileReader(reader);
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
			chiudiFileReader(reader);
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
			chiudiFileReader(reader);
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
			chiudiFileReader(reader);
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
	
	public int cercaTargaPianoAAuto(String targa)
	{
		BufferedReader reader = null;
		String         riga   = "";
		
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoA.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[2].equals(targa))
					return Integer.parseInt(campi[0]);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileReader(reader);
		}
		
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int cercaTargaPianoAScooter(String targa)
	{
		BufferedReader reader = null;
		String         riga   = "";
		
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoAScooter.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[2].equals(targa))
					return Integer.parseInt(campi[0]);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileReader(reader);
		}
		
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int cercaTargaPianoB(String targa)
	{
		BufferedReader reader = null;
		String         riga   = "";
		
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoB.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[2].equals(targa))
					return Integer.parseInt(campi[0]);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileReader(reader);
		}
		
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int cercaTargaPianoBRicarica(String targa)
	{
		BufferedReader reader = null;
		String         riga   = "";
		
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoBRicarica.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[2].equals(targa))
					return Integer.parseInt(campi[0]);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileReader(reader);
		}
		
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int cercaTargaPianoC(String targa)
	{
		BufferedReader reader = null;
		String         riga   = "";
		
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoC.csv"));
				
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(campi[2].equals(targa))
					return Integer.parseInt(campi[0]);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileReader(reader);
		}
		
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean cercaTargaAuto(String targa)
	{
		int ris = cercaTargaPianoAAuto(targa);
		if(ris != 0)
			return true;
		
		ris = cercaTargaPianoB(targa);
		if(ris != 0)
			return true;
		
		ris = cercaTargaPianoBRicarica(targa);
		if(ris != 0)
			return true;
		
		ris = cercaTargaPianoC(targa);
		if(ris != 0)
			return true;
		
		return false;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void chiudiFileReader(BufferedReader reader)
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
	
	public boolean nuovaAutoOrd(Auto auto)
	{
		List<PiazzolaAuto> list = listaPiazzoleOrdinarie(true, true);
		
		if(list.size() == 0)
		{
			list = listaPiazzoleOrdinarie(false, true);
			if(list.size() == 0)
				return false;
			
			list = sovrascriviLista(auto, list.get(0).getNumeroParcheggio(), false);
			sovrascriviFile(false, list);
		}
		else
		{
			list = sovrascriviLista(auto, list.get(0).getNumeroParcheggio(), true);
			sovrascriviFile(true, list);
		}
		
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviLista(Auto auto, int riga, boolean pianoB)
	{
		List<PiazzolaAuto> list = listaPiazzoleOrdinarie(pianoB, false);
		
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
			}
		}
		
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFile(boolean pianoB, List<PiazzolaAuto> list) 
	{
		BufferedWriter writer = null;
		int            nVolte;
		try 
		{
			if(pianoB)
				writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoB.csv", false));
			else
				writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoC.csv", false));
			writer.append(list.get(0).toCsvFormat() + "\n");
			writer.close();
			if(pianoB)
				writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoB.csv", true));
			else
				writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoC.csv", true));
			nVolte = pianoB ? 90 : 100;
			
			for(int idx = 1; idx < nVolte; ++idx)
				writer.append(list.get(idx).toCsvFormat() + "\n");
			
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileWriter(writer);
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean nuovaAutoElettrica(Auto auto)
	{
		List<PiazzolaAuto> list = listaPiazzoleRicarica(true);
		
		if(list.size() == 0)
			return false;
		
		list = sovrascriviListaRicarica(auto, list.get(0).getNumeroParcheggio());
		sovrascriviFileRicarica(list);
		
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviListaRicarica(Auto auto, int riga)
	{
		List<PiazzolaAuto> list = listaPiazzoleRicarica(false);
		
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
			}
		}
		
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFileRicarica(List<PiazzolaAuto> list) 
	{
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoBRicarica.csv", false));
			writer.append(list.get(0).toCsvFormat() + "\n");
			writer.close();
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoBRicarica.csv", true));
			
			for(int idx = 1; idx < 10; ++idx)
				writer.append(list.get(idx).toCsvFormat() + "\n");
			
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileWriter(writer);
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean nuovaScooter(Scooter scooter)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(true);
		
		if(list.size() == 0)
			return false;
		
		list = sovrascriviListaScooter(scooter, list.get(0).getNumeroParcheggio());
		sovrascriviFileScooter(list);
		
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaScooter> sovrascriviListaScooter(Scooter scooter, int riga)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(false);
		
		for(PiazzolaScooter piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setScooter(scooter);
				piazzola.setOccupato(SiNo.SI);
			}
		}
		
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFileScooter(List<PiazzolaScooter> list) 
	{
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoAScooter.csv", false));
			writer.append(list.get(0).toCsvFormat() + "\n");
			writer.close();
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoAScooter.csv", true));
			
			for(int idx = 1; idx < 10; ++idx)
				writer.append(list.get(idx).toCsvFormat() + "\n");
			
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			chiudiFileWriter(writer);
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void chiudiFileWriter(BufferedWriter writer)
	{
		try 
		{
			writer.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
	    }
	}
}