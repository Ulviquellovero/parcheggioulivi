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
	private int   bufferOra;
	private int   bufferMinuto;
	private float bufferPedaggio;
	
	//---------------------------------------------------------------------------------------------
	
	public BizDataBase()
	{
		bufferOra      = 0;
		bufferMinuto   = 0;
		bufferPedaggio = 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int getBufferOra()
	{
		return bufferOra;
	}

	public int getBufferMinuto()
	{
		return bufferMinuto;
	}
	
	public float getBufferPedaggio()
	{
		return bufferPedaggio;
	}
	
	//---------------------------------------------------------------------------------------------
	
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
					if(!campi[1].equals("SI") && !campi[5].equals("SI"))
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
	
	public int cercaTargaPianoAAuto(String targa, boolean soloAft)
	{
		BufferedReader reader = null;
		String         riga   = "";
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoA.csv"));
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				if(soloAft)
				{
					if(campi[2].equals(targa) && campi[5].equals("SI"))
						return Integer.parseInt(campi[0]);
				}
				else
				{
					if(campi[2].equals(targa) && campi[1].equals("SI"))
						return Integer.parseInt(campi[0]);
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
	
	public String cercaTargaAutoNoAft(String targa)
	{
		int ris = cercaTargaPianoAAuto(targa, false);
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
	
	public String cercaTargaAutoAft(String targa)
	{
		String res = cercaPianoA(targa);
		if(res != "")
			return res;
		int ris = cercaTargaPianoB(targa);
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
	
	private String cercaPianoA(String targa)
	{
		int ris = cercaTargaPianoAAuto(targa, false);
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
		ris = cercaTargaPianoAAuto(targa, true);
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
	
	public void uscitaAuto(Auto auto)
	{
		int ris = cercaTargaPianoAAuto(auto.getTarga(), false);
		if(ris != 0)
		{
			uscitaAutoAffittuaria(auto, false);
			return;
		}
		ris = cercaTargaPianoB(auto.getTarga());
		if(ris != 0)
		{
			uscitaAutoOrdinaria(auto, true);
			return;
		}
		ris = cercaTargaPianoBRicarica(auto.getTarga());
		if(ris != 0)
		{
			uscitaAutoElettrica(auto);
			return;
		}
		ris = cercaTargaPianoC(auto.getTarga());
		if(ris != 0)
		{
			uscitaAutoOrdinaria(auto, false);
			return;
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void parcheggiaAutoAffittuaria(Auto auto, int pos)
	{
		List<PiazzolaAutoAffittabile> list = new ArrayList<PiazzolaAutoAffittabile>();
		list = sovrascriviListaPiazzoleAffittabili(auto, pos, 0, 0);
		sovrascriviFIlePiazzoleAffittabili(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabili(Auto auto, int riga, int ora, int minuto)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setOccupato(SiNo.SI);
				piazzola.setOraEntrata(ora);
				piazzola.setMinutoEntrata(minuto);
				return list;
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void uscitaAutoAffittuaria(Auto auto, boolean afittuaria)
	{
		List<PiazzolaAutoAffittabile> list = new ArrayList<PiazzolaAutoAffittabile>();
		list = sovrascriviListaPiazzoleAffittabiliCancella(auto, afittuaria);
		sovrascriviFIlePiazzoleAffittabili(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabiliCancella(Auto auto, boolean afittuaria)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getAuto().getTarga().equals(auto.getTarga()))
			{
				if(!afittuaria)
				{
					piazzola.setAuto(new Auto("NESSUNA", Motore.NON_ELETTRICO));
					bufferOra      = piazzola.getOraEntrata();
					bufferMinuto   = piazzola.getMinutoEntrata();
					bufferPedaggio = 2;
					piazzola.setMinutoEntrata(0);
					piazzola.setOraEntrata(0);
				}
				piazzola.setOccupato(SiNo.NO);
				return list;
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
				return list;
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void uscitaScooter(Scooter scooter)
	{
		List<PiazzolaScooter> list = new ArrayList<PiazzolaScooter>();
		list = sovrascriviListaPiazzoleScooterCancella(scooter);
		sovrascriviListaPiazzoleScooter(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaScooter> sovrascriviListaPiazzoleScooterCancella(Scooter scooter)
	{
		List<PiazzolaScooter> list = listaPiazzoleScooter(false);
		for(PiazzolaScooter piazzola : list)
		{
			if(piazzola.getScooter().getTarga().equals(scooter.getTarga()))
			{
				piazzola.setScooter(new Scooter("NESSUNA"));
				piazzola.setOccupato(SiNo.NO);
				bufferOra      = piazzola.getOraEntrata();
				bufferMinuto   = piazzola.getMinutoEntrata();
				bufferPedaggio = 1.5f;
				piazzola.setOraEntrata(0);
				piazzola.setMinutoEntrata(0);
				return list;
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
			listAft = sovrascriviListaPiazzoleAffittabili(auto, listAft.get(0).getNumeroParcheggio()
					                                          , ZonedDateTime.now().getHour(), ZonedDateTime.now().getMinute());
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
				return list;
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void uscitaAutoOrdinaria(Auto auto, boolean pianoB)
	{
		List<PiazzolaAuto> list = new ArrayList<PiazzolaAuto>();
		list = sovrascriviListaPiazzoleOrdCancella(auto, pianoB);
		sovrascriviFilePiazzoleOrd(pianoB, list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviListaPiazzoleOrdCancella(Auto auto, boolean pianoB)
	{
		List<PiazzolaAuto> list = listaPiazzoleOrdinarie(pianoB, false);
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getAuto().getTarga().equals(auto.getTarga()))
			{
				piazzola.setAuto(new Auto("NESSUNA", Motore.NON_ELETTRICO));
				piazzola.setOccupato(SiNo.NO);
				bufferOra      = piazzola.getOraEntrata();
				bufferMinuto   = piazzola.getMinutoEntrata();
				bufferPedaggio = 2;
				piazzola.setOraEntrata(0);
				piazzola.setMinutoEntrata(0);
				return list;
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
				return list;
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void uscitaAutoElettrica(Auto auto)
	{
		List<PiazzolaAuto> list = new ArrayList<PiazzolaAuto>();
		list = sovrascriviListaPiazzoleRicaricaCancella(auto);
		sovrascriviFilePiazzoleRicarica(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAuto> sovrascriviListaPiazzoleRicaricaCancella(Auto auto)
	{
		List<PiazzolaAuto> list = listaPiazzoleRicarica(false);
		for(PiazzolaAuto piazzola : list)
		{
			if(piazzola.getAuto().getTarga().equals(auto.getTarga()))
			{
				piazzola.setAuto(new Auto("NESSUNA", Motore.NON_ELETTRICO));
				piazzola.setOccupato(SiNo.NO);
				bufferOra      = piazzola.getOraEntrata();
				bufferMinuto   = piazzola.getMinutoEntrata();
				bufferPedaggio = 3;
				piazzola.setOraEntrata(0);
				piazzola.setMinutoEntrata(0);
				return list;
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

	//---------------------------------------------------------------------------------------------
	
	public boolean affittaPiazzola(Auto auto)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(true);
		if(list.size() == 0)
			return false;
		list = sovrascriviListaPiazzoleAffittabileAffitta(auto, list.get(0).getNumeroParcheggio());
		sovrascriviFIlePiazzoleAffittabili(list);
		return true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabileAffitta(Auto auto, int riga)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				piazzola.setAuto(auto);
				piazzola.setAffittato(SiNo.SI);
				return list;
			}
		}
		return list;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void affittaPiazzolaEsistente(int riga)
	{
		List<PiazzolaAutoAffittabile> list = new ArrayList<PiazzolaAutoAffittabile>();
		list = sovrascriviListaPiazzoleAffittabileAffittaEs(riga);
		sovrascriviFIlePiazzoleAffittabili(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabileAffittaEs(int riga)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				bufferOra      = piazzola.getOraEntrata();
				bufferMinuto   = piazzola.getMinutoEntrata();
				bufferPedaggio = 2;
				piazzola.setMinutoEntrata(0);
				piazzola.setOraEntrata(0);
				piazzola.setAffittato(SiNo.SI);
				return list;
			}
		}
		return list;
	}

	//---------------------------------------------------------------------------------------------
	
	public void disaffittaPiazzola(int riga)
	{
		List<PiazzolaAutoAffittabile> list = new ArrayList<PiazzolaAutoAffittabile>();
		list = sovrascriviListaPiazzoleAffittabileDisaffitta(riga);
		sovrascriviFIlePiazzoleAffittabili(list);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<PiazzolaAutoAffittabile> sovrascriviListaPiazzoleAffittabileDisaffitta(int riga)
	{
		List<PiazzolaAutoAffittabile> list = listaPiazzoleAffittabili(false);
		for(PiazzolaAutoAffittabile piazzola : list)
		{
			if(piazzola.getNumeroParcheggio() == riga)
			{
				if(piazzola.getOccupato() == SiNo.NO)
				{
					piazzola.setAuto(new Auto("NESSUNA", Motore.NON_ELETTRICO));
					piazzola.setMinutoEntrata(0);
					piazzola.setOraEntrata(0);
				}
				else
				{
					piazzola.setOraEntrata(ZonedDateTime.now().getHour());
					piazzola.setMinutoEntrata(ZonedDateTime.now().getMinute());
				}
				piazzola.setAffittato(SiNo.NO);
				return list;
			}
		}
		return list;
	}
}