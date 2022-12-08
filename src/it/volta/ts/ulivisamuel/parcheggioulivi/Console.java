package it.volta.ts.ulivisamuel.parcheggioulivi;

import java.util.List;
import java.util.Scanner;

import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Auto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAuto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAutoAffittabile;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaScooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Scooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizDataBase;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizVeicoli;
import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.Motore;
import it.volta.ts.ulivisamuel.parcheggioulivi.util.Util;

public class Console
{
	private Scanner     scanner;
	private BizDataBase bizDataBase;
	private BizVeicoli  bizVeicoli;
	
	//---------------------------------------------------------------------------------------------
	
	public Console()
	{
		bizDataBase = new BizDataBase();
		bizVeicoli  = new BizVeicoli();
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
						 + "\n   5.Cerca targa nel parcheggio\n   0.Uscire dal programma";
		
		int     scelta   = 0;
		boolean continua = true;
		
		while(continua)
		{
			scelta = Util.leggiInt(scanner, menu, 0, 5, false, -1);
			
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
				
			case 5:
				cercaVeicolo();
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
				              + "\n   1.Motore elettrico\n   2.Motore non elettrico\n   0.Per annullare l'operazione";
		
		Auto    auto      = new Auto(null, null);
		String  targa     = "";  
		int     motore    = -1;
		
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto arrivata oppure invio per annullare l'operazione"
					                        + " es.AA999AA", false, null);
			
			if(bizDataBase.cercaTargaAuto(targa) != "")
			{
				System.out.println("\nQuesta targa appartiene già ad un auto presente nel parcheggio");
				targa = "";
			}
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
					inserisciAutoElettrica(auto);
				else
					inserisciAutoTermica(auto);
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void inserisciAutoElettrica(Auto auto)
	{
		String menuRicarica = "\nInserisci il numero indicato per\n   1.Ricaricare l'auto\n   2.Parcheggiare l'auto"
				            + "\n   0.Uscire dal programma";
		
		int scelta = -1;
		
		while(scelta == -1) 
			scelta = Util.leggiInt(scanner, menuRicarica, 0, 2, false, -1);
		
		if(scelta == 1)
		{
			boolean result = bizDataBase.nuovaAutoElettrica(auto);
			
			if(result)
				System.out.println("\nOperazione andata a buon fine!");
			else
				System.out.println("\nParcheggio pieno!");
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void inserisciAutoTermica(Auto auto)
	{
		boolean result = bizDataBase.nuovaAutoOrd(auto);
		
		if(result)
			System.out.println("\nOperazione andata a buon fine!");
		else
			System.out.println("\nParcheggio pieno!");
	}
		
	//---------------------------------------------------------------------------------------------
	
	private void inserisciDatiScooter()
	{
		Scooter scooter   = new Scooter(null);
		String  targa     = "";  
		
		while(!bizVeicoli.verificaTargaScooter(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter arrivato oppure invio per annullare l'operazione"
					+ " es.AA99999", false, null);
			
			if(bizDataBase.cercaTargaPianoAScooter(targa) != 0)
			{
				System.out.println("\nQuesta targa appartiene già ad uno scooter presente nel parcheggio");
				targa = "";
			}
		}
		
		if(targa != null)
		{
			scooter.setTarga(targa);
			inserisciScooter(scooter);
		}
		else
		{
			System.out.println("\nOperazione annullata");
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void inserisciScooter(Scooter scooter)
	{
		boolean result = bizDataBase.nuovaScooter(scooter);
		
		if(result)
			System.out.println("\nOperazione andata a buon fine!");
		else
			System.out.println("\nParcheggio pieno!");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void cercaVeicolo()
	{
		String targa = "";
		while(!bizVeicoli.verificaTargaScooter(targa) && !bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter arrivato oppure invio per annullare l'operazione"
					+ " es.AA99999", false, null);
		}
		if(targa != null)
		{
			if(bizVeicoli.verificaTargaScooter(targa))
			{
				int num = bizDataBase.cercaTargaPianoAScooter(targa);
				if(num != 0)
					System.out.println("\nScooter con targa corrispondente trovato nella zona --> Piano A parcheggi scooter numero " + num);
				else
					System.out.println("\nNon è presente alcuno scooter con questa targa nel parcheggio");
			}
			else
			{
				String zona = bizDataBase.cercaTargaAuto(targa);
				if(zona != "")
					System.out.println("\nAuto con targa corrispondente trovata nella zona --> " + zona);
				else
					System.out.println("\nNon è presente alcuna auto con questa targa nel parcheggio");
			}
		}
		else
		{
			System.out.println("\nOperazione annullata");
		}
	}
}
