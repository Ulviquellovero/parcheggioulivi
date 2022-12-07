package it.volta.ts.ulivisamuel.parcheggioulivi;

import java.util.List;
import java.util.Scanner;

import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Auto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAuto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAutoAffittabile;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaScooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizDataBase;
import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.Motore;
import it.volta.ts.ulivisamuel.parcheggioulivi.util.Util;

public class Console
{
	private Scanner     scanner;
	private BizDataBase bizDataBase;
	
	public Console()
	{
		bizDataBase = new BizDataBase();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void esegui()
	{
		scanner = new Scanner(System.in);
		menu();
		scanner.close();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void menu()
	{
		String  menu     = "\nInserisci il numero indicato per\n   1.Visualizzare lo stato di tutte le piazzole nel parcheggio"
						 + "\n   2.Visualizzare solo lo stato delle piazzole non occupate nel parcheggio"
						 + "\n   3.Visualizzare solo lo stato delle piazzole affittabili nel parcheggio\n   4.Checkin veicolo"
						 + "\n   0.Uscire dal programma";
		
		int     scelta   = 0;
		boolean continua = true;
		
		while(continua)
		{
			scelta = Util.leggiInt(scanner, menu, 0, 4, false, -1);
			
			switch(scelta)
			{
			case 1:
				statoParcheggio();
				break;
				
			case 2:
				statoParcheggiLiberi();
				break;
				
			case 3:
				statoPianoAAuto(true);
				break;
				
			case 4:
				checkInVeicolo();
				break;
				
			case -1:
				break;
				
			case 0:
				continua = false;
				break;
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoParcheggio()
	{
		statoPianoAAuto(false);
		statoPianoAScooter(false);
		statoPianoB(false);
		statoPianoBRcarica(false);
		statoPianoC(false);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoParcheggiLiberi()
	{
		statoPianoAAuto(true);
		statoPianoAScooter(true);
		statoPianoB(true);
		statoPianoBRcarica(true);
		statoPianoC(true);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoAAuto(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano A - Piazzole affittabili libere per auto\n" 
						              : "\nPiano A - Piazzole affittabili per auto\n");
		List<PiazzolaAutoAffittabile> mess = bizDataBase.listaPiazzoleAffittabili(soloLibere);
		for(PiazzolaAutoAffittabile piazzola : mess)
			System.out.println(piazzola);
		
		if(mess.size() == 0)
			System.out.println("Non ci sono piazzole libere");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoAScooter(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano A - Piazzole ordinarie libere per scooter\n"
						     		  : "\nPiano A - Piazzole ordinarie per scooter\n");
		List<PiazzolaScooter> mess = bizDataBase.listaPiazzoleScooter(soloLibere);
		for(PiazzolaScooter piazzola : mess)
			System.out.println(piazzola);
		
		if(mess.size() == 0)
			System.out.println("Non ci sono piazzole libere");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoB(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano B - Piazzole ordinarie libere per auto\n"
								      : "\nPiano B - Piazzole ordinarie per auto\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleOrdinarie(true, soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);
		
		if(mess.size() == 0)
			System.out.println("Non ci sono piazzole libere");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoBRcarica(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano B - Piazzole con ricarica libere per auto elettriche\n"
									  : "\nPiano B - Piazzole con ricarica per auto elettriche\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleRicarica(soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);

		if(mess.size() == 0)
			System.out.println("Non ci sono piazzole libere");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoC(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano C - Piazzole ordinarie libere per auto\n"
									  : "\nPiano C - Piazzole ordinarie per auto\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleOrdinarie(false, soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);
		
		if(mess.size() == 0)
			System.out.println("Non ci sono piazzole libere");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInVeicolo()
	{
		String menuTipoVeicolo = "\nInserisci il numero indicato in base al veicolo arrivato\n   1.Un'auto"
				               + "\n   2.Uno scooter\n   0.Per annullare l'operazione";

		int tipoVeicolo = -1;
		
		while(tipoVeicolo == -1)
			tipoVeicolo = Util.leggiInt(scanner, menuTipoVeicolo, 0, 2, false, -1);
		
		if(tipoVeicolo == 1)
			inserisciDatiAuto();
		
		if(tipoVeicolo == 2)
			inserisciDatiScooter();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void inserisciDatiAuto()
	{
		String menuTipoMotore = "\nInserisci il numero indicato in base al tipo di motore dell'auto arrivata"
				              + "\n   1.Motore non elettrico\n   2.Motore elettrico\n   0.Per annullare l'operazione";
		
		Auto    auto      = new Auto(null, null);
		String  targa     = "";  
		int     motore    = -1;
		
		while(!verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto arrivata oppure invio per annullare l'operazione"
					+ " es.AA999AA", false, null);
		}
			
		if(targa != null)
		{
			auto.setTarga(targa);
			
			while(motore == -1)
				motore = Util.leggiInt(scanner, menuTipoMotore, 0, 2, false, -1);
			
			if(motore != 0)
			{
				auto.setMotore(Motore.values()[motore - 1]);
				
				if(auto.getMotore() == Motore.values()[0])
					inserisciAutoElettrica();
				else
					inserisciAutoTermica();
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private boolean verificaTargaAuto(String targa)
	{
		if(targa == null)
			return true;
		
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
	
	private void inserisciAutoElettrica()
	{
		String menuRicarica = "\nInserisci il numero indicato per\n   1.Ricaricare l'auto\n   2.Parcheggiare l'auto"
				            + "\n   0.Uscire dal programma";
		
		int scelta = -1;
		
		while(scelta == -1)
			scelta = Util.leggiInt(scanner, menuRicarica, 0, 2, false, -1);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void inserisciAutoTermica()
	{
		
	}
		
	//---------------------------------------------------------------------------------------------
	
	private void inserisciDatiScooter()
	{
		Auto    auto      = new Auto(null, null);
		String  targa     = "";  
		
		while(!verificaTargaScooter(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter arrivato oppure invio per annullare l'operazione"
					+ " es.AA99999", false, null);
		}
		
		if(targa != null)
		{
			auto.setTarga(targa);
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private boolean verificaTargaScooter(String targa)
	{
		if(targa == null)
			return true;
		
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
