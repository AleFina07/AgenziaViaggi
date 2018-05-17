import java.time.LocalDate;
import java.time.LocalDateTime;

public class Iscrizione 
{
	private String nome;
	private String cognome;
	private int id;
	private LocalDate data;
	private String destinazione;
	
	
	//CORTUTTORI
	
	public Iscrizione(String nome, String cognome, int id,LocalDate dataPartenza, String destinazione)
	{
		setNome(nome);
		setCognome(cognome);
		setId(id);
		setData(dataPartenza);
		setDestinazione(destinazione);
	}
	
	

	public Iscrizione(Iscrizione persona)
	{
		setNome(persona.getNome());
		setCognome(persona.getCognome());
		setId(persona.getId());
		setData(persona.getData());
		setDestinazione(persona.getDestinazione());
	}

	
	//GETTER E SETTER

	public String getNome()
	{
		return nome;
	}


	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome()
	{
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


	public String getDestinazione() 
	{
		return destinazione;
	}

	
	public void setDestinazione(String destinazione) 
	{
		this.destinazione = destinazione;
	}


	public LocalDate getData() 
	{
		return data;
	}

	public void setData(LocalDate dataPartenza) 
	{
		this.data = dataPartenza;
	}
	
	//METODI VARI
	public String toString()
	{
		return (getId()+" "+getNome()+" "+getCognome()+" "+getData()+" "+getDestinazione()+" ");
	}
	
	
	
	
}


