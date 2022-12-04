package it.volta.ts.ulivisamuel.parcheggioulivi;

import java.util.List;
import java.util.Scanner;

import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAuto;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaAutoAffittabile;
import it.volta.ts.ulivisamuel.parcheggioulivi.bean.PiazzolaScooter;
import it.volta.ts.ulivisamuel.parcheggioulivi.business.BizDataBase;
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
		String  menu     = "\nMenu\n   1.Visualizza lo stato di ogni piazzola\n   2.Visualizza lo stato delle piazzole libere"
				         + "\n   0.Esci";
		
		int     scelta   = 0;
		boolean continua = true;
		
		while(continua)
		{
			scelta = Util.leggiInt(scanner, menu, 0, 2, false, -1);
			
			switch(scelta)
			{
			case 1:
				statoParcheggio();
				break;
				
			case 2:
				statoParcheggiLiberi();
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
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoAScooter(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano A - Piazzole ordinarie libere per scooter\n"
						     		  : "\nPiano A - Piazzole ordinarie per scooter\n");
		List<PiazzolaScooter> mess = bizDataBase.listaPiazzoleScooter(soloLibere);
		for(PiazzolaScooter piazzola : mess)
			System.out.println(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoB(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano B - Piazzole ordinarie libere per auto\n"
								      : "\nPiano B - Piazzole ordinarie per auto\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleOrdinarie(true, soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoBRcarica(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano B - Piazzole con ricarica libere per auto elettriche\n"
									  : "\nPiano B - Piazzole con ricarica per auto elettriche\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleRicarica(soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoC(boolean soloLibere)
	{
		System.out.println(soloLibere ? "\nPiano C - Piazzole ordinarie libere per auto\n"
									  : "\nPiano C - Piazzole ordinarie per auto\n");
		List<PiazzolaAuto> mess = bizDataBase.listaPiazzoleOrdinarie(false, soloLibere);
		for(PiazzolaAuto piazzola : mess)
			System.out.println(piazzola);
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*private void statoPianoParcheggiLiberi(String percorso)
	{
		System.out.println();
		List<String[]> mess = bizDataBase.listaPianoPiazzoleLibere(percorso);
		visualizzaLista(mess);
	}*/
	
	//---------------------------------------------------------------------------------------------
	
	/*private void statoParcheggiAffittabili()
	{
		System.out.println();
		System.out.print("\nPiano A - Piazzole affittabili per auto\n");
		List<String[]> mess = bizDataBase.listaPianoPiazzoleAffittabili();
	}*/
}
