
public class ListaIscrizioni 
{
	private Nodo head;
	private int elementi;
	
	public ListaIscrizioni()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	//crea un nuovo nodo della lista che punta al nodo "link"
	private Nodo creaNodo(Iscrizione persona, Nodo link)
	{
		Nodo nodo=new Nodo(persona);
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
	
	public Iscrizione getInfo(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		
		Nodo p=getLinkPosizione(posizione);
		Iscrizione i=new Iscrizione(p.getInfo());
		return (i);
	}
}
