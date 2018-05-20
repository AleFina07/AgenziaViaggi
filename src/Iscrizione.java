import java.time.LocalDate;
import java.time.LocalDateTime;

public class Iscrizione 
{
	private static String nome;
	private static String cognome;
	private static int id;
	private static LocalDate data;
	private static String destinazione;
	
	
	//CORTUTTORI
	
	public Iscrizione(String nome, String cognome, int id,LocalDate dataPartenza, String destinazione)
	{
		setNome(nome);
		setCognome(cognome);
		setId(id);
		setData(dataPartenza);
		setDestinazione(destinazione);
	}
	
	

	public Iscrizione()
	{
		setNome(Iscrizione.getNome());
		setCognome(Iscrizione.getCognome());
		setId(Iscrizione.getId());
		setData(Iscrizione.getData());
		setDestinazione(Iscrizione.getDestinazione());
	}

	
	//GETTER E SETTER

	public static String getNome()
	{
		return nome;
	}


	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public static String getCognome()
	{
		return cognome;
	}


	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}


	public static int getId() 
	{
		return id;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public static String getDestinazione() 
	{
		return destinazione;
	}

	
	public void setDestinazione(String destinazione) 
	{
		this.destinazione = destinazione;
	}


	public static LocalDate getData() 
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
		return (getId()+";"+getNome()+";"+getCognome()+";"+getData()+";"+getDestinazione()+";");
	}

	
	
	
}


