import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) 
	{
		/*
		LocalDate dataPartenza1=LocalDate.of(2018 , 5, 31);
		LocalDate dataPartenza2=LocalDate.of(2018 , 7, 6);
		LocalDate dataPartenza3=LocalDate.of(2018 , 8, 13);
		Iscrizione i1=new Iscrizione("Alessandro", "Finazzi"+" ", 1, dataPartenza1,"Maldive");
		Iscrizione i2=new Iscrizione("Alessandra", "Finazzo"+" ", 1, dataPartenza2,"Caraibi");
		Iscrizione i3=new Iscrizione("Alessandru", "Finassi"+" ", 1, dataPartenza3, "Egitto");
		*/
		
		int controllo = 0;
		int variabile = 0;
		int id=0;
		
		Agenzia a1=new Agenzia();
		
		
		
			String [] elenco= 
				{
					"BENVENUTO NEL GESTIONALE DELL'AGENZIA VIAGGI PARADISO",
					"1 --> Aggiungi un'iscrizione",
					"2 --> Cancella iscrizione",
					"3 --> Visualizza tutte le iscrizioni in ordine alfabetico verso una certa destinazione ",
					"4 --> Visualizza tutte le isccrizioni in base all'ordine cronologico della partenza",
				};
			
			ConsoleInput tastiera= new ConsoleInput();
			Menu menu= new Menu(null, elenco);
			String nomefile= "iscrizione.bin";
				
			int continuare=1;
		do {
			
			switch (menu.scelta()) 
			{
			
			case 1:			//AGGIUNGI ISCRITTO
				{
				
				System.out.println("Inserisci i campi del nuovo iscritto");
				
					
				String nome;
				String cognome;
				LocalDate dataPartenza;
				String destinazione;
				Iscrizione iscritto= new Iscrizione();
				try 
				{
					System.out.println("Id dell'utente sarà:"+ id);
					id++;
					
					System.out.println("Inserire il nome:   ");
					nome =tastiera.readString();
					
					System.out.println("Inserire il cognome:   ");
					cognome = tastiera.readString();
					
					System.out.println("Inserire la data di partenza:   ");
					Date data=tastiera.readDate();
					dataPartenza = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					
					System.out.println("Inserire la destinazione:   ");
					destinazione = tastiera.readString();
					
					
					iscritto= new Iscrizione(nome, cognome, id, dataPartenza, destinazione);
					
				 
					
					a1.inserisciInTesta(iscritto);
					
					a1.esportaCSV("iscrizioni.csv");
					
					
					/*
					a1.inserisciInTesta(iscritto);
					TextFile file=new TextFile("iscrizioni.txt", 'W');
					file.toFile(iscritto.toString());
					file.closeFile();
					System.out.println("Scrittura effettuata correttamente");  
					*/                       
				} 
				catch (Exception e) 
				{
					System.out.println("Errore nel salvataggio dei dati");
				}
				
				System.out.println("Se vuoi procedere all'uso del software premere '1'");
				try 
				{
					controllo=tastiera.readInt();
				}
				catch (NumberFormatException e) 
				{
				
				} 
				catch (IOException e) 
				{
					
				}
				break;
				}
				
				
			case 2:			//CANCELLA ISCRITTO
			{
				{
				System.out.println("Inserire l'id dell'iscrizione da eliminare");
				try 
				{
					int IdDaEliminare = tastiera.readInt();
					IdDaEliminare = a1.cercaPosizione(IdDaEliminare);
					
					Agenzia i1= new Agenzia();
					try 
					{
						i1=a1.caricaAgenzia("iscrizioni.csv");
						System.out.println("caricamento ok");
					} 
					catch (IOException e) 
					{
						System.out.println("impossibile leggere da file");
					} catch (ClassNotFoundException e) 
					{
						System.out.println("Classe non trovata");
					}
					
					
					
					System.out.println(a1.toString());
				} 
				catch (NumberFormatException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				System.out.println("Se vuoi procedere all'uso del software premere '1'");
				try 
				{
					controllo=tastiera.readInt();
				}
				catch (NumberFormatException e) 
				{
				
				} 
				catch (IOException e) 
				{
					
				}
				
				
				break;
				}	
			}
			case 3:
			{
				
				try
					{
						a1.ordinaAlfabeto(a1);
					}
					catch (IscrizioneException e) 
					{
						e.printStackTrace();
					}
				
					
					System.out.println("Se vuoi procedere all'uso del software premere '1'");
					try 
					{
						controllo=tastiera.readInt();
					}
					catch (NumberFormatException e) 
					{
					
					} 
					catch (IOException e) 
					{
						
					}
				break;
			}
				
				
			case 4:
			{
								break;
			}
			
		}
			
		}while(controllo == 1);
		System.out.println(a1.toString());
		
				/*//***************scrittura*********************
				try 
				{
					TextFile file=new TextFile("iscrizioni.txt", 'W');
					file.toFile("Iscrizione1");
					file.toFile("Iscrizione2");
					file.toFile("Prova3");
					file.closeFile();
					System.out.println("Scrittura effettuata correttamente");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile aprire il file in scrittura");
				} catch (FileException e) 
				{
					System.out.println(e.toString());
				}
				
			
				//***************lettura*********************
				String rigaLetta;

				TextFile file2 = null;
				
				try 
				{
					file2=new TextFile("iscrizioni.txt", 'R');
					while(true)
					{
						rigaLetta=file2.fromFile();
						System.out.println(rigaLetta);
					}
					
				} 
				catch (IOException e) 
				{
					System.out.println("impossibile aprire il file in lettura");
				} 
				catch (FileException e) 
				{
					System.out.println(e.toString());
				} 
				catch (EccezioneTextFileEOF e) 
				{
					try 
					{
						file2.closeFile();
					} 
					catch (IOException e1) 
					{
						System.out.println("impossibile accedere al file");
					}
				}*/

	}

}
