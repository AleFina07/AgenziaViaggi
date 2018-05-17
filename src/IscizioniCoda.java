public class IscizioniCoda
{
	private Nodo head;
	private int elementi;
	
	public void IscrizioniCoda()
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
			throw new IscrizioneException("Lista vuota");
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
	
	
	public void enqueue(Iscrizione persona)
	{
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	
	public Iscrizione dequeue() throws Exception
	{
		Iscrizione iscritto;
		if (elementi==0)
			throw new Exception("Lista vuota");
		if(elementi==1)
		{
			iscritto=new Iscrizione(head.getInfo());
			head=head.getLink();
			elementi--;
			return iscritto;
		}
		Nodo p=getLinkPosizione(elementi);
		iscritto=new Iscrizione(p.getInfo());
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
		return iscritto;
	}
}
