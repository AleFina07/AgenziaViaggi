import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
/**
 * La classe rappresenta un'agenzia viaggi e le relative iscrizioni,questa è solo una lista di iscrizioni
 * gli attributi sono: il puntatore head di tipo nodo e il numero di elementi(iscrizioni) della nostra agenzia
 * La classe ci permette di gestire l'agenzia viaggi
 *  
 * @author Finazzi Alessandro
 * @version 1.0
 */
public class Agenzia
{
	private Nodo head;
	private int elementi;
	/**
	 *Costruttore della lista,ci permette di creare una lista(di iscrizioni) vuota
	 *ovvero senza alcuna iscrizione registrata
	 */
	public Agenzia()
	{
		head=null;
		elementi=0;
	}
	/**
	 * Metodo getter che restituisce il numero di elementi di cui è composta l'Agenzia viaggi,
	 * ovvero il numero di iscrizioni presenti nella lista
	 * @return elementi, rappresenta il numero di iscrizioni presenti nella lista
	 */
	public int getElementi()
	{
		return elementi;
	}
	
	//crea un nuovo nodo della lista che punta al nodo "link"
	/**
	 * Classe che ci consente di creare un nuovo nodo nella nostra lista
	 * 
	 * @param iscritto è un oggetto di tipo Iscrizione
	 * @param link è un oggetto di tipo nodo
	 * @return nodo è un nodo istanziato nel metodo
	 */
	private Nodo creaNodo(Iscrizione iscritto, Nodo link)
	{
		Nodo nodo= new Nodo(iscritto);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Metodo privato che restituisce un oggetto di tipo nodo in una detrminata posizione
	 * @param posizione che rappresenta la posizione nella quale è presente il nodo da estrarre
	 * @return p che rappresenta il nodo cercato
	 * @throws IscrizioneException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
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
	/**
	 * Metodo che restituisce una stringa con i dati relativi alle iscrizioni
	 * presenti nella lista
	 */
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
	
	/**
	 * Metodo che permette di inserire una determinata prenotazione in testa alla lista
	 * @param p rappresenta l'iscriziione da inserire in testa
	 */
	public void inserisciInTesta(Iscrizione persona)
	{
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	/**
	 * Metodo che permette di inserire una determinata iscrizione in coda alla lista
	 * @param p rappresenta l'iscrizione da inserire in coda
	 * @throws IscrizioneException eccezione che si verifica quando la lista è vuota
	 */
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
	/**
	 * Metodo che permette di inserire una determinata iscrizione in una determinata posizione della lista
	 * @param persona rappresenta l'iscrizione da inserire in coda
	 * @param posizione rappresenta la posizione nella quale inserire l'iscrizione
	 * @throws IscrizioneException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
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
	/**
	 * Metodo che permette di eliminare l'iscrizione in testa alla lista
	 */
	public void eliminaInTesta() throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");	
		head=head.getLink();
		elementi--;
	}
	/**
	 * Metodo che permette di eliminare l'iscrizione in coda alla lista
	 */
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
	/**
	 * Metodo che permette di eliminare l'iscrizione presente in una posizione della lista
	 * @param posizione rappresenta la posizione nella quale è presente l'iscrizione da eliminare
	 * @throws IscrizioneException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
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
	/**
	 * Metodo che permette di estrarre i dati di un'iscrizione presente in una posizione della lista
	 * @param posizione rappresenta la posizione nella quale è presente l'iscrizione con i dati necessari
	 * @throws IscrizioneException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public String visita(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return (p.getInfo().toString());
	}
	/**
	 * Metodo che permette di recuperare i dati di un'iscrizione in una determinata posizione
	 * @param posizione rappresenta la posizione nella quale sono presenti i dati
	 * @return p.getInfo() dati dell'iscrizione nella posizione desiderata
	 * @throws IscrizioneException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	public Iscrizione getIscritto(int posizione) throws IscrizioneException
	{
		if (elementi==0)
			throw new IscrizioneException("Lista vuota");
		if (posizione<=0 || posizione>elementi)
			throw new IscrizioneException("Posizione non valida");
		
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo() ;
	}
	/**
	 *Metodo che consente l'esportazione di una lista su un file CSV
	 * @param nomeFile rappresenta il file su cui andremo a salvare lee nostre iscrizioni
	 * @throws IOException eccezione che si verifica quando vi si verificano errori di input o di output
	 * @throws IscrizioneException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 * @throws FileException eccezione che si verifica quando non viene trovato il file 
	 */
	
	public void esportaCSV (String nomeFile) throws IOException, IscrizioneException, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String iscrittoCSV;
		Iscrizione iscritto;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			iscritto=getIscritto(i);
			iscrittoCSV=iscritto.getId()+";"+iscritto.getNome()+";"+iscritto.getCognome()+";"+iscritto.getData()+";"+ iscritto.getDestinazione()+ ";";
			file.toFile(iscrittoCSV);
		}
		file.closeFile();
		
	}
/**
 * Metodo che consente l'importazione di una lista da un file CSV
 * @param nomeFile
 * @return agenzia ritorna la mia lista che era precedentemente stata salvata in un file CSV
 * @throws IOException eccezione che si verifica quando vi si verificano errori di input o di output
 * @throws IscrizioneException eccezione che si verifica quando la lista è vuota o la posizione non è valida
 * @throws FileException eccezione che si verifica quando non viene trovato il file 
 * @throws EccezioneTextFileEOF 
 */
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
		/**
		 * Metodo che consente di salvare la nostra lista di iscrizioni all'interno di un file 
		 */
	}
	public void salvaAgenzia(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Metodo che ci consente di esportare i dati di una 
	 * @param nomeFile
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Agenzia caricaAgenzia (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Agenzia agenzia;
		
		agenzia=(Agenzia)(reader.readObject());
		file.close();
		return agenzia;
	}

	/**
	 * Metodo che consente di cercare una determinata posizione di un iscritto di un determinato id
	 * @param IdDaEliminare id che passeremo per indicare l'iscritto con quell'id
	 * @return posizione che ha l'iscrizione con il determinato id 
	 */
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
	/**
	 * Metodo che consente di controllare se l'inserimento avvenuto tramite tastiera
	 * dall'utente è corretto oppure no
	 * @return controollo che verifica la correttezza dei parametri passati come input
	 */
	public static int controlloInputInt()
	{
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		do
		{
		try 
		{
			controllo  = tastiera.nextInt();
			break;
		} 
		catch (java.util.InputMismatchException e) 
		{
			System.out.println("Inserimento sbagliato... RIPROVA");
			tastiera.nextLine();
		}	
		}while(true);
		
		return controllo;
	}
	/**
	 * Metodo che permette di scambiare due iscrizioni presenti nell'array
	 * @param array rappresenta l'array di iscrizioni nel quale si desidera eseguire lo scambio
	 * @param pos1 rappresenta la posizione di un'iscrizione che si deve scambiare
	 * @param pos2 rappresenta la posizione di un'iscrizione che si deve scambiare
	 */
	public static int scambia(Iscrizione[] array, int pos1, int pos2)
	{
		Iscrizione p;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		p=new Iscrizione(array[pos1]);
		array[pos1]=new Iscrizione(array[pos2]);
		array[pos2]=new Iscrizione(p);
		return 0;
	}
	/**
	 * Metodo che permette di copiare un array di iscrizioni
	 * @param array rappresenta l'array che si desidera copiare
	 * @return arraycopia è l'array di copia
	 */
	public static Iscrizione[] copia(Iscrizione[] array)
	{
		Iscrizione[] arrayCopia=new Iscrizione[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
			arrayCopia[i]=array[i];	
		}
		return arrayCopia;
	}
	/**
	 * Metodo che consente di trasformare una lista in un array per facilitarne l'uso
	 * @return arrayp che rappresenta l'array di iscrizioni ricavato dalla lista
	 * @throws IscrizioneException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public Iscrizione[] arrayIscrizioni() throws IscrizioneException
	{
		Iscrizione[] arrayp=new Iscrizione[elementi];
		for (int i = 0; i < arrayp.length; i++) 
		{
			Nodo p1=getLinkPosizione(i+1);
			arrayp[i]=p1.getInfo();
		}
		return arrayp;
	}
	/**
	 * Metodo che permette di ordinare un array in ordine crescente in base al nome
	 * @param a rappresenta la lista(ovvero l'agenzia)
	 * @return arrayordinato è l'array ordinato in base al nome
	 * * @throws IscrizioneException eccezione che si verifica quando la lista è vuota
	 */
	public Iscrizione[] selectionSortCrescenteNome(Agenzia a) throws IscrizioneException
	{
		if (elementi==0)
		{
			throw new IscrizioneException("Nessuna iscrizione presente");
		}
		Iscrizione[] array;
		array=a.arrayIscrizioni();
		Iscrizione[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if (arrayOrdinato[j].getNome().compareTo(arrayOrdinato[i].getNome())<0)
				{
					scambia(arrayOrdinato, i , j);
				}
			}
		}
		return arrayOrdinato;
	}
	
	/**
	 * Metodo che consente di salvare una lista di iscrizioni in un file binario
	 * @param nomeFile rappresenta il nome del file sul quale si vuole salvare l'iscrizione
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 */
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Metodo che consente di caricare un'oggetto di tipo iscrizione effettuandone la deserializzazione da un file binario
	 * @param nomeFile rappresenta il nome del file binario da deserializzare
	 * @return a rappresenta la lista di iscrizioni deserializzata
	 * @throws IOException eccezione che si verifica per errori durante il caricamento dell'iscrizione
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare l'iscrizione
	 */
	public Agenzia caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Agenzia a;
		a=(Agenzia)(reader.readObject());
		file.close();
		return a;
	}
	
	/**
	 * Metodo che permette di aggiungere un'iscrizione alla nostra lista
	 * @param p rappresenta l'iscrizione che si vuole aggiungere alla lista
	 * @throws IscrizioneException eccezione che si verifica quando la lista è vuota oppure la posizione non è valida 
	 */
	public void registraIscrizione(Iscrizione p) throws IscrizioneException
	{
		if (elementi==0)
		{
			this.inserisciInTesta(p);
			return;
		}
		else
		{
			Iscrizione[] arrayp;
			arrayp=this.arrayIscrizioni();

			
			
			this.inserisciInCoda(p);
			System.out.println("Salvataggio dell'iscrizione effettuata");
			return;
		}
	}
	
	
}
	
	/*
	public void ordinaAlfabeto(Agenzia iscritto) throws IscrizioneException
	{
		boolean controllo = true;
		int elementi = iscritto.getElementi()+1;
		Agenzia iscritto1 = new Agenzia();
		for (int i = 1; i < elementi; i++) 
		{
			iscritto1.inserisciInposizione(iscritto.getLinkPosizione(i).getInfo(), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (iscritto1.getLinkPosizione(i).getInfo().getNome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getNome())<0)
			{
				
			}
			else if (iscritto1.getLinkPosizione(i).getInfo().getNome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getNome())>0)
			{
				iscritto1.inserisciInposizione(iscritto1.getLinkPosizione(i+1).getInfo(), i);
				iscritto1.eliminaInPosizione(i+2);
				controllo = false;
			}
			else if (iscritto1.getLinkPosizione(i).getInfo().getNome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getNome())==0)
			{
				if (iscritto1.getLinkPosizione(i).getInfo().getCognome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getCognome())==0)
				{
				}
				else if (iscritto1.getLinkPosizione(i).getInfo().getCognome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getCognome())>0)
				{
					iscritto1.inserisciInposizione(iscritto1.getLinkPosizione(i+1).getInfo(), i);
					iscritto1.eliminaInPosizione(i+2);
					controllo = false;
				}
				else if (iscritto1.getLinkPosizione(i).getInfo().getCognome().compareTo(iscritto1.getLinkPosizione(i+1).getInfo().getCognome())<0)
				{
				}
			}
			
			}
		}while(controllo == false);			
		elementi++;
		for (int i = 1; i < elementi; i++) 
		{
			iscritto1.getLinkPosizione(i).getInfo().toString();
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
}

*/

