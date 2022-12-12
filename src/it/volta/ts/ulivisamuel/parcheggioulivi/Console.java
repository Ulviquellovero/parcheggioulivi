package it.volta.ts.ulivisamuel.parcheggioulivi;

import java.util.List;
import java.util.Scanner;

import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Auto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAuto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAutoAffittabile;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaScooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.Scooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizDataBase;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizRicavi;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizVeicoli;
import it.volta.ts.ulivisamuel.parcheggioulivi.enumerations.Motore;
import it.volta.ts.ulivisamuel.parcheggioulivi.util.Util;

public class Console
{
	private Scanner     scanner;
	private BizDataBase bizDataBase;
	private BizVeicoli  bizVeicoli;
	private BizRicavi   bizRicavi;
	
	//---------------------------------------------------------------------------------------------
	
	public Console()
	{
		bizDataBase = new BizDataBase();
		bizVeicoli  = new BizVeicoli();
		bizRicavi   = new BizRicavi();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void esegui()
	{
		scanner = new Scanner(System.in);
		System.out.println("Benvenuto!");
		menu();
		System.out.println("\nArrivederci e buon lavoro!");
		scanner.close();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void menu()
	{
		String  menu     = "\nInserisci il numero indicato per\n   1.Eseguire il check-in di un veicolo"
				         + "\n   2.Visualizzare lo stato di tutte le piazzole nel parcheggio"
				         + "\n   3.Visualizzare lo stato delle piazzole libere nel parcheggio"
						 + "\n   4.Visualizzare lo stato delle piazzole affittabili nel parcheggio"
				         + "\n   5.Cercare la posizione di un veicolo nel parcheggio\n   6.Affittare una piazzola"
				         + "\n   7.Annullare il contratto di affitto con un auto\n   8.Eseguire il check-out di un veicolo"
				         + "\n   9.Visualizzare i ricavi della giornata\n   0.Uscire dal programma";
		int     scelta   = 0;
		boolean continua = true;
		while(continua)
		{
			scelta = Util.leggiInt(scanner, menu, 0, 9, false, -1);
			switch(scelta)
			{
			case 1:
				checkInVeicolo();
				break;
			case 2:
				statoParcheggio();
				break;
			case 3:
				statoParcheggiLiberi();
				break;
			case 4:
				statoPianoAAuto(true);
				break;
			case 5:
				cercaVeicolo();
				break;
			case 6:
				affittaPosto();
				break;
			case 7:
				disaffittaPosto();
				break;
			case 8:
				checkOutVeicolo();
				break;
			case 9:
				ricaviGiornaglieri();
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
		List<PiazzolaAutoAffittabile> mess = bizDataBase.listaPiazzoleAffittabili(soloLibere, false);
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
		String menuTipoVeicolo = "\nInserisci il numero indicato in base al tipo di veicolo da assegnare a una piazzola\n   1.Un'auto"
				               + "\n   2.Uno scooter\n   0.Per annullare l'operazione";
		int tipoVeicolo        = -1;
		while(tipoVeicolo == -1)
			tipoVeicolo = Util.leggiInt(scanner, menuTipoVeicolo, 0, 2, false, -1);
		if(tipoVeicolo == 1)
			checkInAutoTarga();
		if(tipoVeicolo == 2)
			checkInScooterTarga();
		if(tipoVeicolo == 0)
			System.out.println("\nOperazione annullata");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInAutoTarga()
	{
		Auto    auto          = new Auto(null, null);
		String  targa         = ""; 
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto da assegnare a una piazzola (es.AA999AA)"
					                        + " oppure premi INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				int res = verificheTarga(targa, auto);
				if(res == 1)
				{
					return;
				}
				else
				{
					if(res == 2)
						targa = "";
				}
			}
			else
			{
				System.out.println("\nOperazione annullata");
				return;
			}
		}
		checkInAutoMotore(auto, targa);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int verificheTarga(String targa, Auto auto)
	{
		if(bizVeicoli.verificaTargaAuto(targa))
		{
			int pos = 0;
			pos = bizDataBase.cercaTargaPianoAAuto(targa, true);
			if(pos != 0)
			{
				auto.setTarga(targa);
				bizDataBase.parcheggiaAutoAffittuaria(auto, pos);
				System.out.println("\nOperazione andata a buon fine");
				return 1;
			}
			else
			{
				String mess = "";
				mess = bizDataBase.cercaTargaAutoNoAft(targa);
				if(mess != "")
				{
					System.out.println("\nQuesta targa appartiene già ad un auto presente nel parcheggio");
					return 2;
				}
			}
		}
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInAutoMotore(Auto auto, String targa)
	{
		String menuTipoMotore = "\nInserisci il numero indicato in base al tipo di motore del veicolo da assegnare a una piazzola"
                + "\n   1.Motore elettrico\n   2.Motore non elettrico\n   0.Per annullare l'operazione";
		int     motore        = -1;
		auto.setTarga(targa);
		while(motore == -1)
			motore = Util.leggiInt(scanner, menuTipoMotore, 0, 2, false, -1);
		if(motore != 0)
		{
			auto.setMotore(Motore.values()[motore - 1]);
			if(auto.getMotore() == Motore.values()[0])
				checkInAutoElettrica(auto);
			else
				checkInAutoTermica(auto);
		}
		else
		{
			System.out.println("\nOperazione annullata");
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInAutoElettrica(Auto auto)
	{
		String menuRicarica = "\nInserisci il numero indicato per\n   1.Ricaricare l'auto\n   2.Parcheggiare l'auto"
				            + "\n   0.Annullare l'operazione";
		int scelta = -1;
		while(scelta == -1) 
			scelta = Util.leggiInt(scanner, menuRicarica, 0, 2, false, -1);
		if(scelta == 1)
		{
			int result = bizDataBase.parcheggiaAutoElettrica(auto);
			if(result != 0)
				System.out.println("\nOperazione andata a buon fine, all'auto è stata assegnata la piazzola nella zona "
						         + "--> Piano B parcheggi con ricarica, piazzola numero: " + result);
			else
				System.out.println("\nParcheggio pieno!");
		}
		else
		{
			if(scelta == 2)
				checkInAutoTermica(auto);
			else
				System.out.println("\nOperazione annullata");
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInAutoTermica(Auto auto)
	{
		String result = bizDataBase.parcheggiaAutoOrdinaria(auto);
		if(result != "")
			System.out.println("\nOperazione andata a buon fine, all'auto è stata assegnata la piazzola nella zona --> " + result);
		else
			System.out.println("\nNon ci sono piazzole ordinarie libere!");
	}
		
	//---------------------------------------------------------------------------------------------
	
	private void checkInScooterTarga()
	{
		Scooter scooter   = new Scooter(null);
		String  targa     = "";  
		while(!bizVeicoli.verificaTargaScooter(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter da assegnare a una piazzola (es.AA99999)"
					                        + " oppure premi INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				if(bizVeicoli.verificaTargaScooter(targa))
				{
					if(bizDataBase.cercaTargaPianoAScooter(targa) != 0)
					{
						System.out.println("\nQuesta targa appartiene già ad uno scooter presente nel parcheggio");
						targa = "";
					}
				}
			}
			else
			{
				System.out.println("\nOperazione annullata");
				return;
			}
		}
		scooter.setTarga(targa);
		checkInScooter(scooter);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkInScooter(Scooter scooter)
	{
		int result = bizDataBase.parcheggiaScooter(scooter);
		if(result != 0)
			System.out.println("\nOperazione andata a buon fine, allo scooter è stata assegnata la piazzola nella zona "
				             + "--> Piano A parcheggi scooter, piazzola numero: " + result);
		else
			System.out.println("\nParcheggio scooter pieno!");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void cercaVeicolo()
	{
		String menuTipoVeicolo = "\nInserisci il numero indicato in base al tipo di veicolo da ricercare\n   1.Un'auto"
	               + "\n   2.Uno scooter\n   0.Per annullare l'operazione";
		int tipoVeicolo        = -1;
		while(tipoVeicolo == -1)
			tipoVeicolo = Util.leggiInt(scanner, menuTipoVeicolo, 0, 2, false, -1);
		if(tipoVeicolo == 1)
			cercaAuto();
		if(tipoVeicolo == 2)
			cercaScooter();
		if(tipoVeicolo == 0)
			System.out.println("\nOperazione annullata");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void cercaAuto()
	{
		String targa = "";
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto da ricercare (es.AA999AA) oppure premi"
											+ "  INVIO per annullare l'operazione", false, null);
			if(targa == null)
			{
				System.out.println("\nOperazione annullata");
				return;
			}
			else
			{
				if(bizVeicoli.verificaTargaAuto(targa))
				{
					String zona = bizDataBase.cercaTargaAutoAft(targa);
					if(zona != "")
					{
						System.out.println("\nAuto con targa corrispondente trovata nella zona --> " + zona);
						return;
					}
					else
					{
						System.out.println("\nNon è presente alcuna auto con questa targa nel parcheggio");
						targa = "";
					}
				}
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void cercaScooter()
	{
		String targa = "";
		while(!bizVeicoli.verificaTargaScooter(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter da ricercare (es.AA99999) oppure premi"
											+ " INVIO per annullare l'operazione", false, null);
			if(targa == null)
			{
				System.out.println("\nOperazione annullata");
				return;
			}
			else
			{
				if(bizVeicoli.verificaTargaScooter(targa))
				{
					int num = bizDataBase.cercaTargaPianoAScooter(targa);
					if(num != 0)
					{
						System.out.println("\nScooter con targa corrispondente trovato nella zona --> Piano A parcheggi scooter numero " + num);
						return;
					}
					else
					{
						System.out.println("\nNon è presente alcuno scooter con questa targa nel parcheggio");
						targa = "";
					}
				}
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkOutVeicolo()
	{
		String menuTipoVeicolo = "\nInserisci il numero indicato in base al veicolo da far uscire dal parcheggio\n   1.Un'auto"
	               + "\n   2.Uno scooter\n   0.Per annullare l'operazione";
		int tipoVeicolo        = -1;
		while(tipoVeicolo == -1)
			tipoVeicolo = Util.leggiInt(scanner, menuTipoVeicolo, 0, 2, false, -1);
		if(tipoVeicolo == 1)
			checkOutAuto();
		if(tipoVeicolo == 2)
			checkOutScooterTarga();
		if(tipoVeicolo == 0)
			System.out.println("\nOperazione annullata");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkOutAuto()
	{
		Auto    auto          = new Auto(null, null);
		String  targa         = ""; 
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto da far uscire dal parcheggio (es.AA999AA)"
					                        + " oppure premi INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				int res = verificheTargaOut(targa, auto);
				if(res == 1)
				{
					return;
				}
				else
				{
					if(res == 2)
						targa = "";
				}
			}
			else
			{
				System.out.println("\nOperazione annullata");
				return;
			}
		}
		auto.setTarga(targa);
		bizDataBase.uscitaAuto(auto);
		float ricavo = bizRicavi.aggiungiRicaviNorm(bizDataBase.getBufferOra(), bizDataBase.getBufferMinuto()
																		  , bizDataBase.getBufferPedaggio());
		System.out.println("\nOperazione andata a buon fine! Il cliente deve pagare un pedaggio di --> " + ricavo + "€");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int verificheTargaOut(String targa, Auto auto)
	{
		if(bizVeicoli.verificaTargaAuto(targa))
		{
			int pos = 0;
			pos = bizDataBase.cercaTargaPianoAAuto(targa, true);
			if(pos != 0)
			{
				auto.setTarga(targa);
				bizDataBase.uscitaAutoAffittuaria(auto, true);
				System.out.println("\nOperazione andata a buon fine");
				return 1;
			}
			else
			{
				String mess = "";
				mess = bizDataBase.cercaTargaAutoNoAft(targa);
				if(mess == "")
				{
					System.out.println("\nQuesta targa non appartiene a nessuna auto presente nel parcheggio");
					return 2;
				}
			}
		}
		return 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkOutScooterTarga()
	{
		Scooter scooter   = new Scooter(null);
		String  targa     = "";  
		while(!bizVeicoli.verificaTargaScooter(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dello scooter da far uscire dal parcheggio (es.AA99999) oppure premi"
					                        + " INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				if(bizVeicoli.verificaTargaScooter(targa))
				{
					if(bizDataBase.cercaTargaPianoAScooter(targa) == 0)
					{
						System.out.println("\nQuesta targa non appartiene a nessuno scooter nel parcheggio");
						targa = "";
					}
				}
			}
			else
			{
				System.out.println("\nOperazione annullata");
				return;
			}
		}
		scooter.setTarga(targa);
		checkOutScooter(scooter);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void checkOutScooter(Scooter scooter)
	{
		bizDataBase.uscitaScooter(scooter);
		float ricavo = bizRicavi.aggiungiRicaviNorm(bizDataBase.getBufferOra(), bizDataBase.getBufferMinuto()
				  , bizDataBase.getBufferPedaggio());
		System.out.println("\nOperazione andata a buon fine! Il cliente deve pagare un pedaggio di --> " + ricavo + "€");
	}

	//---------------------------------------------------------------------------------------------
	
	private void affittaPosto()
	{
		Auto    auto  = new Auto(null, null);
		String  targa = ""; 
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto a cui verrà assegnata una piazzola affittabile"
                                            + " (es.AA999AA) oppure premi INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				if(bizVeicoli.verificaTargaAuto(targa))
				{
					int riga = bizDataBase.cercaTargaPianoAAuto(targa, false);
					auto.setTarga(targa);
					if(riga == 0)
					{
						if(bizDataBase.cercaTargaAutoNoAft(targa) == "")
						{
							boolean ris = bizDataBase.affittaPiazzola(auto);
							if(ris)
								System.out.println("\nOperazione andata a buon fine");
							else
								System.out.println("\nNon c'è nessuna piazzola affittabile libera!");
						}
						else
						{
							System.out.println("\nQuesta targa appartiene già ad un auto presente nel parcheggio");
							targa = "";
						}
					}
					else
					{
						bizDataBase.affittaPiazzolaEsistente(riga);
						float ricavo = bizRicavi.aggiungiRicaviNorm(bizDataBase.getBufferOra(), bizDataBase.getBufferMinuto()
								  , bizDataBase.getBufferPedaggio());
						System.out.println("\nPiazzola affittata! Pedaggio da pagare per le ore passate fino ad ora --> " + ricavo + "€");
					}
				}
			}
			else
			{
				System.out.println("\nOperazione annullata");
				return;
			}
		}
	}

	//---------------------------------------------------------------------------------------------
	
	private void disaffittaPosto()
	{
		Auto    auto  = new Auto(null, null);
		String  targa = ""; 
		while(!bizVeicoli.verificaTargaAuto(targa))
		{
			targa = Util.leggiString(scanner, "\nInserisci la targa dell'auto a cui verrà disdetto l'affitto"
                    + " di una piazzola (es.AA999AA) oppure premi INVIO per annullare l'operazione", false, null);
			if(targa != null)
			{
				if(bizVeicoli.verificaTargaAuto(targa))
				{
					int riga = bizDataBase.cercaTargaPianoAAuto(targa, true);
					auto.setTarga(targa);
					if(riga == 0)
					{
						System.out.println("\nNessuna piazzola ha un affitto associato a questa targa");
						targa = "";
					}
					else
					{
						bizDataBase.disaffittaPiazzola(riga);
						System.out.println("\nOperazione andata a buon fine");
					}
				}
			}
			else
			{
				System.out.println("\nOperazione anullata");
				return;
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void ricaviGiornaglieri()
	{
		bizRicavi.aggiungiRicaviAft(bizDataBase.listaPiazzoleAffittabili(false, true).size());
		System.out.println("\nRicavi giornaglieri --> " + bizRicavi.getRicaviGiorn() + "€");
		bizRicavi.rimuoviRicaviAft(bizDataBase.listaPiazzoleAffittabili(false, true).size());
	}
}
