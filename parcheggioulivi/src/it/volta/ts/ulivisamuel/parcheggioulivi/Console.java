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
		String  menu     = "\nMenu\n   1.Visualizza lo stato di ogni parcheggio\n   0.Esci";
		int     scelta   = 0;
		boolean continua = true;
		
		while(continua)
		{
			scelta = Util.leggiInt(scanner, menu, 0, 1, false, -1);
			
			switch(scelta)
			{
			case 1:
				statoParcheggio();
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
		System.out.println();
		statoPianoA();
		statoPianoAScooter();
		statoPianoB();
		statoPianoBRicarica();
		statoPianoC();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoA()
	{
		System.out.println("Piano A - Piazzole auto affittabili\n");
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPianoA();
			
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
		
		System.out.println();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoAScooter()
	{
		System.out.println("Piano A - Piazzole scooter affittabili\n");
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPianoAScooter();
			
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
		
		System.out.println();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoB()
	{
		System.out.println("Piano B - Piazzole auto ordinarie\n");
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPianoB();
			
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
		
		System.out.println();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoBRicarica()
	{
		System.out.println("Piano B - Piazzole auto elettriche con ricarica\n");
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPianoB();
			
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
		
		System.out.println();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void statoPianoC()
	{
		System.out.println("Piano C - Piazzole auto ordinarie\n");
		
		try 
		{
			List<String[]> mess = bizDataBase.listaPianoC();
			
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
		
		System.out.println();
	}
}
