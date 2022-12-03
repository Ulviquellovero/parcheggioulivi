package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BizDataBase
{
	public List<String[]> listaPiano(String percorso)
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
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoPiazzoleLibere(String percorso)
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
	}
}