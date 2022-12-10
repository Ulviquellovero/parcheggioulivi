package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.ZonedDateTime;
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
					if(!campi[1].equals("SI") && !campi[3].equals("SI"))
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
		PiazzolaAutoAffittabile piazzola = new PiazzolaAutoAffittabile(0, null, 0, 0, null, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		piazzola.setOraEntrata(Integer.parseInt(campi[3]));
		piazzola.setMinutoEntrata(Integer.parseInt(campi[4]));
		piazzola.setAffittato(SiNo.valueOf(campi[5]));
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
		PiazzolaScooter     piazzola = new PiazzolaScooter(0, null, 0, 0, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setScooter(new Scooter(campi[2]));
		piazzola.setOraEntrata(Integer.parseInt(campi[3]));
		piazzola.setMinutoEntrata(Integer.parseInt(campi[4]));
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
		PiazzolaAuto piazzola = new PiazzolaAuto(0, null, 0, 0, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		piazzola.setOraEntrata(Integer.parseInt(campi[3]));
		piazzola.setMinutoEntrata(Integer.parseInt(campi[4]));
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
		PiazzolaAuto piazzola = new PiazzolaAuto(0, null, 0, 0, null);
		piazzola.setNumeroParcheggio(Integer.parseInt(campi[0]));
		piazzola.setOccupato(SiNo.valueOf(campi[1]));
		piazzola.setAuto(new Auto(campi[2], Motore.values()[0]));
		piazzola.setOraEntrata(Integer.parseInt(campi[3]));
		piazzola.setMinutoEntrata(Integer.parseInt(campi[4]));
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
				if(campi[2].equals(targa) && campi[1].equals("SI"))
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
	
	public String cercaTargaAuto(String targa)
	{
		int ris = cercaTargaPianoAAuto(targa);
		if(ris != 0)
		{
			if(ris < 10)
			{
				return "Piano A numero 00" + ris;
			}
			else
			{
				if(ris > 10 && ris != 100)
					return "Piano A numero 0" + ris;
				else
					return "Piano A numero " + ris;
			}
		}
			
		ris = cercaTargaPianoB(targa);
		if(ris != 0)
			return "Piano B numero " + ris;
		ris = cercaTargaPianoBRicarica(targa);
		if(ris != 0)
			return "Piano B con ricarica numero " + ris;
		ris = cercaTargaPianoC(targa);
		if(ris != 0)
			return "Piano C numero " + ris;
		return "";
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
	
	public void parcheggiaAutoAffittuaria(Auto auto)
	{
		List<PiazzolaAutoAffittabile> list = new ArrayList<PiazzolaAutoAffittabile>();
		int                           pos  =     cercaTargaPianoAAuto(auto.getTarga());
		list = sovrascriviListaPiazzoleAffittabili(auto, pos);
		sovrascriviFIlePiazzoleAffittabili(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabili(Auto auto, int riga)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
				piazzola.setOraEntrata(ZonedDateTime.now().getHour());
				piazzola.setMinutoEntrata(ZonedDateTime.now().getMinute());
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFIlePiazzoleAffittabili(List<PiazzolaAutoAffittabile> list) 
	{
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoA.csv", false));
			writer.append(list.get(0).toCsvFormat() + "\n");
			writer.close();
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoA.csv", true));
			for(int idx = 1; idx < 100; ++idx)
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
	
	public boolean parcheggiaScooter(Scooter scooter)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(true);
		if(list.size() == 0)
			return false;
		list = sovrascriviListaPiazzoleScooter(scooter, list.get(0).getNumeroParcheggio());
		sovrascriviListaPiazzoleScooter(list);
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean uscitaScooter(Scooter scooter)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(true);
		if(list.size() == 0)
			return false;
		list = sovrascriviListaPiazzoleScooter(scooter, list.get(0).getNumeroParcheggio());
		sovrascriviListaPiazzoleScooter(list);
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaScooter> sovrascriviListaPiazzoleScooter(Scooter scooter, int riga)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(false);
		for(PiazzolaScooter piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setScooter(scooter);
				piazzola.setOccupato(SiNo.SI);
				piazzola.setOraEntrata(ZonedDateTime.now().getHour());
				piazzola.setMinutoEntrata(ZonedDateTime.now().getMinute());
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviListaPiazzoleScooter(List<PiazzolaScooter> list) 
	{
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoAScooter.csv", false));
			writer.append(list.get(0).toCsvFormat() + "\n");
			writer.close();
			writer = new BufferedWriter(new FileWriter("..\\parcheggioulivi\\pianoAScooter.csv", true));
			for(int idx = 1; idx < 50; ++idx)
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
	
	public boolean parcheggiaAutoOrdinaria(Auto auto)
	{
		List<PiazzolaAutoAffittabile> listAft = listaPiazzoleAffittabili(true);
		if(listAft.size() == 0)
		{
			List<PiazzolaAuto> list = listaPiazzoleOrdinarie(true, true);
			if(list.size() == 0)
			{
				list = listaPiazzoleOrdinarie(false, true);
				if(list.size() == 0)
					return false;
				list = sovrascriviListaPiazzoleOrd(auto, list.get(0).getNumeroParcheggio(), false);
				sovrascriviFilePiazzoleOrd(false, list);
			}
			else
			{
				list = sovrascriviListaPiazzoleOrd(auto, list.get(0).getNumeroParcheggio(), true);
				sovrascriviFilePiazzoleOrd(true, list);
			}
		}
		else
		{
			listAft = sovrascriviListaPiazzoleAffittabili(auto, listAft.get(0).getNumeroParcheggio());
			sovrascriviFIlePiazzoleAffittabili(listAft);
		}
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviListaPiazzoleOrd(Auto auto, int riga, boolean pianoB)
	{
		List<PiazzolaAuto> list = listaPiazzoleOrdinarie(pianoB, false);
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
				piazzola.setOraEntrata(ZonedDateTime.now().getHour());
				piazzola.setMinutoEntrata(ZonedDateTime.now().getMinute());
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFilePiazzoleOrd(boolean pianoB, List<PiazzolaAuto> list) 
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
	
	public boolean parcheggiaAutoElettrica(Auto auto)
	{
		List<PiazzolaAuto> list = listaPiazzoleRicarica(true);
		if(list.size() == 0)
			return false;
		list = sovrascriviListaPiazzoleRicarica(auto, list.get(0).getNumeroParcheggio());
		sovrascriviFilePiazzoleRicarica(list);
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviListaPiazzoleRicarica(Auto auto, int riga)
	{
		List<PiazzolaAuto> list = listaPiazzoleRicarica(false);
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
				piazzola.setOraEntrata(ZonedDateTime.now().getHour());
				piazzola.setMinutoEntrata(ZonedDateTime.now().getMinute());
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void sovrascriviFilePiazzoleRicarica(List<PiazzolaAuto> list) 
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