
public class Iscrizione 
{
	private String nome;
	private String cognome;
	private int id;
	private String dataPartenza;
	private String destinazione;
	
	
	
	public Iscrizione(String nome, String cognome, int id,String dataPartenza, String destinazione)
	{
		setNome(nome);
		setCognome(cognome);
		setId(id);
		setDataPartenza(dataPartenza);
		setDestinazione(destinazione);
	}
	
	public Iscrizione(Iscrizione persona)
	{
		setNome(persona.getNome());
		setCognome(persona.getCognome());
		setId(persona.getId());
		setDataPartenza(persona.getDataPartenza());
		setDestinazione(persona.getDestinazione());
	}

	

	public String getNome()
	{
		return nome;
	}


	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}


	public int getId() 
	{
		return id;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public String getDataPartenza() 
	{
		return dataPartenza;
	}


	public void setDataPartenza(String dataPartenza)
	{
		this.dataPartenza = dataPartenza;
	}


	public String getDestinazione() 
	{
		return destinazione;
	}

	public void setDestinazione(String destinazione) 
	{
		this.destinazione = destinazione;
	}
	
	public String toString()
	{
		return (getId()+" "+getNome()+" "+getCognome()+" "+getDataPartenza()+" "+getDestinazione()+" ");
	}
	
}


