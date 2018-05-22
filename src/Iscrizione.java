import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * La classe Iscrizione rappresenta una determinata iscrizione inserita dall'agente dell'agenzia.
 * Una Prenotazione è costituita dai seguenti attributi:
 * Un codice identificativo che rappresenta il codice che differenzia ciascuna iscrizione dall'altra
 * un nome che rappresenta il nome di colui che vuole eseguire l'iscrizione
 * un cognome che rappresenta il cognome di colui che vuole eseguire l'iscrizione
 * una data che rappresenta la data nella quale si ha programmato il viaggio
 * una destinazione che indica la meta del viaggio
 * 
 * @author Finazzi Alessandro
 * @version 1.0
 */
public class Iscrizione 
{
	private static String nome;
	private static String cognome;
	private static int id;
	private static LocalDate data;
	private static String destinazione;
	
	
	//CORTUTTORI
	/**
	 * Costruttore della classe Iscrizione. Instanzia una nuova Iscrizione.
	 * richiede un codice identificativo,un nome, un cognome,
	 * una determinata data (LocalDate) e la destinazione
	 * @param nome rappresenta il nome dell'iscritto
	 * @param cognome rappresenta il cognome dell'iscritto
	 * @param id rappresenta il codice identificativo che avrà ogni singolo iscritto
	 * @param dataPartenza data che indica il giorno di partenza per il viaggio
	 * @param destinazione rappresenta la meta dell'iscritto
	 */
	
	public Iscrizione(String nome, String cognome, int id,LocalDate dataPartenza, String destinazione)
	{
		setNome(nome);
		setCognome(cognome);
		setId(id);
		setData(dataPartenza);
		setDestinazione(destinazione);
	}
	/**
	 * Costruttore di copia della classe Iscrizione. Istanzia una nuova Iscrizione
	 * @param i rappresenta l'iscrizione che si vuole copiare
	 */
	public Iscrizione(Iscrizione i)
	{
		this.setNome(i.getNome());
		this.setCognome(i.getCognome());
		this.setId(i.getId());
		this.setData(i.getData());
		this.setDestinazione(i.getDestinazione());
	}
	
	/**
	 * Costruttore di default della classe Iscrizione. Istanzia un'iscrizione
	 * vuota
	 */
	public Iscrizione()
	{
		setNome(Iscrizione.getNome());
		setCognome(Iscrizione.getCognome());
		setId(Iscrizione.getId());
		setData(Iscrizione.getData());
		setDestinazione(Iscrizione.getDestinazione());
	}

	
	//GETTER E SETTER
	/**
	 * Metodo di tipo getter che restituisce il nome dell'iscrizione
	 * @return nome che rappresenta il nome attribuito a un'iscrizione
	 */
	public static String getNome()
	{
		return nome;
	}

	/**
	 * Metodo di tipo setter che permette di settare il nome che si vuole attribuire all'iscrizione
	 * @param nome che rappresenta il nuovo nome che si vuole attribuire all'iscrizione
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * Metodo di tipo getter che restituisce il cognome dell'iscrizione
	 * @return cognome che rappresenta il cogome attribuito a un'iscrizione
	 */
	public static String getCognome()
	{
		return cognome;
	}
	/**
	 * Metodo di tipo setter che permette di settare il cognome che si vuole attribuire all'iscrizione
	 * @param cognome che rappresenta il nuovo cognome che si vuole attribuire all'iscrizone
	 */

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	/**
	 * Metodo di tipo getter che restituisce il codice identificativo dell'iscrizione
	 * @return id che rappresenta il codice identificativo dell'iscrizione
	 */
	public static int getId() 
	{
		return id;
	}

	/**
	 * Metodo di tipo setter che permette di settare il codice identificativo dell'iscrizione
	 * @param codiceidentificativo che rappresenta il nuovo valore che si vuole attribuire
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la destinazione del viaggio
	 * @return destinazione che rappresenta la destinazione del viaggio
	 */
	public static String getDestinazione() 
	{
		return destinazione;
	}

	/**
	 * Metodoo di tipo settter che permette di settare la dstinazione dell'iscrizione
	 * @param destinazione che rappresenta la destinazione del viaggio
	 */
	public void setDestinazione(String destinazione) 
	{
		this.destinazione = destinazione;
	}

	
	/**
	 * Metodo di tipo getter che restituisce la data del viaggio dell'iscrizione
	 * @return data che rappresenta la data del viaggio
	 */
	public static LocalDate getData() 
	{
		return data;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la destinazione del viaggio
	 * @param dataPartenza rappresenta la data di partenza del viaggio
	 */
	public void setData(LocalDate dataPartenza) 
	{
		this.data = dataPartenza;
	}
	
	//METODI VARI

	/**
	 * Metodo toString che restituisce una stringa composta
	 * dal codice, il nome, il cognome, una data e la destinazione del viaggio
	 */
	public String toString()
	{
		return (getId()+";"+getNome()+";"+getCognome()+";"+getData()+";"+getDestinazione()+";");
	}

	
	
	
}


