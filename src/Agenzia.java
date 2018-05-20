import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Agenzia
{
	private Nodo head;
	private int elementi;
	
	public Agenzia()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	//crea un nuovo nodo della lista che punta al nodo "link"
	
	private Nodo creaNodo(Iscrizione iscritto, Nodo link)
	{
		Nodo nodo= new Nodo(iscritto);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws IscrizioneException
	{
		
		if (elementi==0)
			throw new IscrizioneException("Lista delle Iscrizioni vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		Nodo p=head;
		int n=1;
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();
			n++;
		}
		return p;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato;
		Nodo p=head;
		while(p!=null)
		{
			risultato+="-->"+p.getInfo().getNome();
			p=p.getLink();
		}
		
		return risultato;
		
	}
	
	
	public void inserisciInTesta(Iscrizione persona)
	{
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	
	public void inserisciInCoda(Iscrizione persona) throws IscrizioneException
	{
		if(elementi==0)
		{
			inserisciInTesta(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;
	}
	
	void inserisciInposizione(Iscrizione persona, int posizione) throws IscrizioneException
	{	
		if(posizione==1)
		{
			inserisciInTesta(persona);
			return;
		}
		if (posizione<=0 || posizione>elementi+1)
			throw new IscrizioneException("Posizione non valida");
		
		if (posizione==elementi+1)
		{
			inserisciInCoda(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;	
	}
	
	public void eliminaInTesta() throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");	
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if(elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		Nodo p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
	}
	
	public String visita(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return (p.getInfo().toString());
	}
	
	public Iscrizione getIscritto(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo() ;
	}
	public void esportaCSV (String nomeFile) throws IOException, IscrizioneException, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String iscrittoCSV;
		Iscrizione iscritto;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			iscritto=getIscritto(i);
			iscrittoCSV=iscritto.getNome()+";"+iscritto.getCognome()+";"+iscritto.getData()+";"+ iscritto.getDestinazione()+ ";";
			file.toFile(iscrittoCSV);
		}
		file.closeFile();
		
	}

	public Agenzia importaCSV (String nomeFile) throws IOException, FileException, IscrizioneException, EccezioneTextFileEOF
	{
		Agenzia agenzia=new Agenzia();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiIscrizione;
		Iscrizione iscrizione;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiIscrizione=rigaLetta.split(";");
					iscrizione=new Iscrizione();
					agenzia.inserisciInCoda(iscrizione);
				}
				
			} 
			catch (FileException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new FileException(e.toString());
			}
		
			return agenzia;		
			
	}
	public void salvaAgenzia(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Agenzia caricaAgenzia (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Agenzia agenzia;
		
		agenzia=(Agenzia)(reader.readObject());
		file.close();
		return agenzia;
	}

	
	public int cercaPosizione(int IdDaEliminare) 
	{
		
		Nodo p=head;
		
		int posizioneDaEliminare=0;
		for (int i = 1; i < elementi; i++) 
		{
			if (p.getInfo().getId()==IdDaEliminare)
			{
				posizioneDaEliminare=i;
			}
		}
		return posizioneDaEliminare;
	}
}

