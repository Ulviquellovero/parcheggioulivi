package it.volta.ts.ulivisamuel.parcheggioulivi.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BizDataBase
{
	
	public BizDataBase()
	{
		
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoA() throws Exception
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		  
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoA.csv"));
			
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			throw new Exception("Impossibile leggere/aprire il file");
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				throw new Exception("Impossibile chiudere il file");
		    }
		}
		
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoAScooter() throws Exception
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		  
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoAScooter.csv"));
			
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			throw new Exception("Impossibile leggere/aprire il file");
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				throw new Exception("Impossibile chiudere il file");
		    }
		}
		
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoB() throws Exception
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		  
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoB.csv"));
			
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			throw new Exception("Impossibile leggere/aprire il file");
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				throw new Exception("Impossibile chiudere il file");
		    }
		}
		
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoBRicarica() throws Exception
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		  
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoBRicarica.csv"));
			
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			throw new Exception("Impossibile leggere/aprire il file");
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				throw new Exception("Impossibile chiudere il file");
		    }
		}
		
		return mess;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<String[]> listaPianoC() throws Exception
	{
		BufferedReader reader = null;
		String         riga   = "";
		List<String[]> mess   = new ArrayList<String[]>();
		  
		try
		{
			reader = new BufferedReader(new FileReader("..\\parcheggioulivi\\pianoC.csv"));
			
			while((riga = reader.readLine()) != null) 
			{
				String[] campi = riga.split(",");
				mess.add(campi);
			}
		}
		catch(Exception e) 
		{
			throw new Exception("Impossibile leggere/aprire il file");
		}
		finally 
		{
			try 
			{
				reader.close();
			} 
			catch (Exception e) 
			{
				throw new Exception("Impossibile chiudere il file");
		    }
		}
		
		return mess;
	}
}