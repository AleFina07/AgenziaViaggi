/**
 * La classe nodo rappresenta un  determinato nodo. Il nodo è costituito da 2 attributi:
 * un info e un link. Info è la componente informativa, contiene un reference a un oggetto presente nella lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Finazzi Alessandro
 * @version 1.0
 */
public class Nodo 
{

	private Iscrizione info;
	private Nodo link;
	
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede una prenotazione, che rappresenta l'attributo info della classe nodo.
	 * 
	 * @param persona è un oggetto di tipo Iscrizione
	 */
	
	public Nodo (Iscrizione persona)
	{
		setInfo(persona);
		link=null;
	}
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia un'Iscrizione
	 * @return info che rappresenta un oggetto Iscrizione
	 */
	public Iscrizione getInfo() 
	{
		return info;
	}
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta l'iscrizione che rappresenterà la componente informativa del nodo
	 */
	public void setInfo(Iscrizione info) 
	{
		this.info = info;
	}
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */
	public Nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	public void setLink(Nodo link)
	{
		this.link = link;
	}
}
