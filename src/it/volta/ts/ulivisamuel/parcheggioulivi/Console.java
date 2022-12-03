package it.volta.ts.ulivisamuel.parcheggioulivi;

import java.util.List;
import java.util.Scanner;

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
		System.out.print("\nPiano A - Piazzole affittabili per auto\n");
		statoPiano("..\\parcheggioulivi\\pianoA.csv");
		System.out.print("\nPiano A - Piazzole ordinarie per scooter\n");
		statoPiano("..\\parcheggioulivi\\pianoAScooter.csv");
		System.out.print("\nPiano B - Piazzole ordinarie per auto\n");
		statoPiano("..\\parcheggioulivi\\pianoB.csv");
		System.out.print("\nPiano B - Piazzole con ricarica per auto elettriche\n");
		statoPiano("..\\parcheggioulivi\\pianoBRicarica.csv");
		System.out.print("\nPiano C - Piazzole ordinarie per auto\n");
		statoPiano("..\\parcheggioulivi\\pianoC.csv");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoParcheggiLiberi()
	{
		System.out.print("\nPiano A - Piazzole affittabili per auto\n");
		statoPianoParcheggiLiberi("..\\parcheggioulivi\\pianoA.csv");
		System.out.print("\nPiano A - Piazzole ordinarie per scooter\n");
		statoPianoParcheggiLiberi("..\\parcheggioulivi\\pianoAScooter.csv");
		System.out.print("\nPiano B - Piazzole ordinarie per auto\n");
		statoPianoParcheggiLiberi("..\\parcheggioulivi\\pianoB.csv");
		System.out.print("\nPiano B - Piazzole con ricarica per auto elettriche\n");
		statoPianoParcheggiLiberi("..\\parcheggioulivi\\pianoBRicarica.csv");
		System.out.print("\nPiano C - Piazzole ordinarie per auto\n");
		statoPianoParcheggiLiberi("..\\parcheggioulivi\\pianoC.csv");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPiano(String percorso)
	{
		System.out.println();
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPiano(percorso);
			
			for(String[] riga : mess)
			{
				for(String campo : riga)
					System.out.printf("%-20s", campo);
				System.out.println();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoParcheggiLiberi(String percorso)
	{
		System.out.println();
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPiano(percorso);
			
			for(String[] riga : mess)
			{
				for(int idx = 0; idx < riga.length; ++idx)
				{
					if(!riga[1].equals("NO") && !riga[1].equals("Occupato"))
						break;
					
					System.out.printf("%-20s", riga[idx]);
				}
				if(!riga[1].equals("SI"))
					System.out.println();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
