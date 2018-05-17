import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) 
	{
		LocalDate dataPartenza1=LocalDate.of(2018 , 5, 31);
		LocalDate dataPartenza2=LocalDate.of(2018 , 7, 6);
		LocalDate dataPartenza3=LocalDate.of(2018 , 8, 13);
		Iscrizione i1=new Iscrizione("Alessandro", "Finazzi"+" ", 1, dataPartenza1,"Maldive");
		Iscrizione i2=new Iscrizione("Alessandra", "Finazzo"+" ", 1, dataPartenza2,"Caraibi");
		Iscrizione i3=new Iscrizione("Alessandru", "Finassi"+" ", 1, dataPartenza3, "Egitto");
			
		
		ListaIscrizioni l1=new ListaIscrizioni();
		l1.inserisciInTesta(i1);
		l1.inserisciInTesta(i2);
		l1.inserisciInTesta(i3);
		
		System.out.println(l1.toString());
		
				//***************scrittura*********************
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
				}

	}

}
